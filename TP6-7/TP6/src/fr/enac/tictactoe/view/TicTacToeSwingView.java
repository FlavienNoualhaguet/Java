/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.enac.tictactoe.view;

import fr.enac.tictactoe.model.Player;
import static fr.enac.tictactoe.model.Player.CIRCLE;
import static fr.enac.tictactoe.model.Player.CROSS;
import static fr.enac.tictactoe.model.Player.VOID;
import fr.enac.tictactoe.model.TicTacToeModel;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;


/**
 *
 * @author noualhfl
 */
public class TicTacToeSwingView  extends JFrame implements IBoardGameView {
    private final TicTacToeModel model;
    private final int BOARD_SIZE;
    
    private boolean isEndAsked;
    
    private JLabel[][] board;
    private JLabel nextPlayer;
    
    public TicTacToeSwingView (TicTacToeModel model) {
        // Set up this instance
        this.model = model;
        this.BOARD_SIZE = model.BOARD_SIZE;
        // Subscribe to the model so that it updates the view 
        // (by calling the methods specified by the IBoardGameView interface).
        // It is not a good practice to pass to another object a reference 
        // to this instance under construction. The other object could then 
        // try to act on our instance before the end of its initialization 
        // (especially in multi-thread), which could cause problems. 
        // To avoid this it would be necessary to set up a mechanism 
        // similar to the launch of a JavaFX application (see ViewMorpionJavaFX).

        // Create the view
        this.createView();
        this.model.subscribe(this);

    }

    /**
     * Create the view.
     */
    private void createView() {
        // Configuration de la fenêtre, titre, taille, position initiale...
        setTitle("Tic-Tac-Toe Game ");
        setSize(50*(this.BOARD_SIZE+1), (this.BOARD_SIZE + 3)*50);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        // Ajout du bouton à son conteneur parent
        // (dans le cas de la JFrame il faut obtenir son contentPane)
        Container pane = getContentPane();
        
        // Spécification du layout (contraintes de placement appliquées aux enfants de ce conteneur),
        // ici un alignement en colonne (l'équivalent du VBoxLayout de Qt)
        // https://docs.oracle.com/javase/tutorial/uiswing/layout/box.html
        pane.setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS));

        // Menu
        JMenuBar barMenu = new JMenuBar ();
        JMenu menuGame = new JMenu ("Game");
        menuGame.setMnemonic(KeyEvent.VK_G);
        menuGame.getAccessibleContext().setAccessibleDescription(
        "The only menu in this program that has menu items");
        barMenu.add(menuGame);
        
        //a group of JMenuItems
        JMenuItem newGame = new JMenuItem("New Game",
                                 KeyEvent.VK_N);
        newGame.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_N, ActionEvent.ALT_MASK));
        newGame.getAccessibleContext().setAccessibleDescription(
                "This doesn't really do anything");
        menuGame.add(newGame);

        pane.add(barMenu);
        
        
        // Grid nxn
        JPanel gridPanel = new JPanel ();
        pane.add(gridPanel);
        gridPanel.setLayout(new GridLayout (this.BOARD_SIZE, this.BOARD_SIZE));
        gridPanel.setMaximumSize(new Dimension(50*this.BOARD_SIZE, 50*this.BOARD_SIZE));
        
        this.board = new JLabel[this.BOARD_SIZE][this.BOARD_SIZE];
        
        for (int i=0; i<this.BOARD_SIZE;i++) {
            int idi = i;
            for (int j=0; j<this.BOARD_SIZE; j++) {
                int idj=j;
                ImageIcon currentLogo = new ImageIcon("resources/void.jpg");
                JLabel player = new JLabel ();
                player.setIcon(currentLogo);
                gridPanel.add(player);
                this.board[i][j] = player;
                
                
                // Abonnement des JLabel
                player.addMouseListener(new MouseAdapter () {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                       // JOptionPane.showMessageDialog(TicTacToeSwingView.this, String.format("(%s, %s)", idi+1, idj+1));
                        model.playMove(idi,idj);
                    }
                });
            }
        }
        
        // Grid 1x3
        JPanel controlBar = new JPanel ();
        controlBar.setMaximumSize(new Dimension(150,50));
        pane.add(controlBar);
        controlBar.setLayout(new GridLayout (1, 3));

        // Création d'un bouton, centré dans son parent
        JButton buttonN = new JButton("N");
        buttonN.setPreferredSize(new Dimension(50, 50));
        controlBar.add(buttonN);
        
        // Creation d'un jlabel
        ImageIcon logo = new ImageIcon("resources/circle.jpg");
        this.nextPlayer = new JLabel ();
        this.nextPlayer.setIcon(logo);
        controlBar.add(this.nextPlayer);
        
        // Création d'un bouton, centré dans son parent
        JButton buttonQ = new JButton("Q");
        buttonQ.setPreferredSize(new Dimension(50, 50));
        controlBar.add(buttonQ);
        
        // Abonnement bouton N
        // Abonnement pour pouvoir réagir aux événements provenant du bouton.
        // Le mécanisme d'abonnement est très similaire à celui de Qt (connexion signal/slot),
        // mais d'une syntaxe plus compliquée :
        // Les événements sont des classes (https://docs.oracle.com/javase/8/docs/api/java/awt/event/package-summary.html)
        // et non plus des attributs du widget que l'on souhaite observer -> ici ActionEvent,
        // On crée une instance d'une classe implémentant une interface spécifique à l'événement -> ici ActionListener,
        // On s'abonne en invoquant sur le widget une méthode également spécifique à l'événement -> ici addActionListener
        buttonN.addActionListener(new ActionListener() {
                @Override
        public void actionPerformed(ActionEvent e) {
            // Afficher une popup (fenêtre modale)
            JOptionPane.showMessageDialog(TicTacToeSwingView.this, "Vous avez appuyé sur le bouton N !");
                }
        });

        // Abonnement bouton Q
        buttonQ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Afficher une popup (fenêtre modale)
                JOptionPane.showMessageDialog(TicTacToeSwingView.this, "Vous avez appuyé sur le bouton Q !");
                    }
        });
        
        
        
        this.pack();        
    }

    @Override
    public void displayGame() {
        ImageIcon cross = new ImageIcon("resources/cross.jpg");
        ImageIcon circle = new ImageIcon("resources/cross.jpg");
        ImageIcon voidij = new ImageIcon("resources/void.jpg");

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                switch (model.getPlayerOnSquare(i, j)) {
                    case CROSS:
                        this.board[i][j].setIcon(cross);
                        break;
                    case VOID:
                        this.board[i][j].setIcon(voidij);
                        break;
                    case CIRCLE:
                        this.board[i][j].setIcon(circle);
                        break;
                }
            }
        }
        
    }

    @Override
    public void displayLastMove(int line, int column) {
        ImageIcon cross = new ImageIcon("resources/cross.jpg");
        ImageIcon circle = new ImageIcon("resources/circle.jpg");
        ImageIcon voidd = new ImageIcon("resources/voidd.jpg");

        switch (model.getCurrentPlayer()) {
            case CROSS:
                this.board[line][column].setIcon(cross);
                this.nextPlayer.setIcon(circle);
                break;
            case VOID:
                this.board[line][column].setIcon(voidd);
                break;
            case CIRCLE:
                this.board[line][column].setIcon(circle);
                this.nextPlayer.setIcon(cross);
                break;
        }
    }
    

    @Override
    public void displayError(String err) {
        JOptionPane.showMessageDialog(TicTacToeSwingView.this, err);
    }

    @Override
    public void displayWinnerAndRestart(Player winner) {
        JOptionPane.showMessageDialog(TicTacToeSwingView.this, winner + " won !");
        model.newGame();
        
    }

    @Override
    public void displayEndWithNoWinnerAndRestart() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void exit() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
