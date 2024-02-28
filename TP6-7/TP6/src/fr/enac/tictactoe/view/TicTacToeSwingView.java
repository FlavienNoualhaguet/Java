/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.enac.tictactoe.view;

import fr.enac.tictactoe.model.Player;
import fr.enac.tictactoe.model.TicTacToeModel;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;


/**
 *
 * @author noualhfl
 */
public class TicTacToeSwingView  extends JFrame {
    private final TicTacToeModel model;
    private final int BOARD_SIZE;
    
    private boolean isEndAsked;
    
    
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
//        this.model.subscribe(this);
        // Create the view
        this.createView();
        
    }

    /**
     * Create the view.
     */
    private void createView() {
        // Configuration de la fenêtre, titre, taille, position initiale...
        setTitle("Tic-Tac-Toe Game ");
        setSize(50*this.BOARD_SIZE, (this.BOARD_SIZE + 3)*50);
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

        // Grid nxn
        JPanel gridPanel = new JPanel ();
        pane.add(gridPanel);
        gridPanel.setLayout(new GridLayout (this.BOARD_SIZE, this.BOARD_SIZE));
        gridPanel.setMaximumSize(new Dimension(50*this.BOARD_SIZE, 50*this.BOARD_SIZE));
        for (int i=0; i<this.BOARD_SIZE;i++) {
            for (int j=0; j<this.BOARD_SIZE; j++) {
                ImageIcon currentLogo = new ImageIcon("resources/void.jpg");
                JLabel player = new JLabel ();
                 player.setIcon(currentLogo);
                gridPanel.add(player);                
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
        JLabel nextPlayer = new JLabel ();
        nextPlayer.setIcon(logo);
        controlBar.add(nextPlayer);
        
        // Création d'un bouton, centré dans son parent
        JButton buttonQ = new JButton("Q");
        buttonQ.setPreferredSize(new Dimension(50, 50));
        controlBar.add(buttonQ);
    }
    
}
