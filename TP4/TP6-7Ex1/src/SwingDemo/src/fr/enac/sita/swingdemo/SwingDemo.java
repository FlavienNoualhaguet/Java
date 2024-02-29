

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 * Exemple - tutoriel Swing
 * 
 * @author leriche
 *
 */

/*
 * JFrame est la superclasse la plus 'simple' pour encapsuler une application graphique
 */
public class SwingDemo extends JFrame {

	public SwingDemo() {

		// Configuration de la fenêtre, titre, taille, position initiale...
		setTitle("Démo SITA Swing ENAC");
		setSize(400, 300);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Spécification du layout (contraintes de placement appliquées aux enfants de ce conteneur),
		// ici un alignement en colonne (l'équivalent du VBoxLayout de Qt)
		// https://docs.oracle.com/javase/tutorial/uiswing/layout/box.html
		setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
		// Comme en Qt il y a plein de layouts différents (ligne, colonne, grille...)

		// Création d'un bouton, centré dans son parent
		JButton button = new JButton("Ceci est un boutton");
		button.setAlignmentX(Component.CENTER_ALIGNMENT);

		// Ajout du bouton à son conteneur parent
		// (dans le cas de la JFrame il faut obtenir son contentPane)
		Container pane = getContentPane();
		pane.add(button);

		// Abonnement pour pouvoir réagir aux événements provenant du bouton.
		// Le mécanisme d'abonnement est très similaire à celui de Qt (connexion signal/slot),
		// mais d'une syntaxe plus compliquée :
		// Les événements sont des classes (https://docs.oracle.com/javase/8/docs/api/java/awt/event/package-summary.html)
		// et non plus des attributs du widget que l'on souhaite observer -> ici ActionEvent,
		// On crée une instance d'une classe implémentant une interface spécifique à l'événement -> ici ActionListener,
		// On s'abonne en invoquant sur le widget une méthode également spécifique à l'événement -> ici addActionListener
		button.addActionListener(new ActionListener() {
			@Override
    		public void actionPerformed(ActionEvent e) {
				// Afficher une popup (fenêtre modale)
				JOptionPane.showMessageDialog(SwingDemo.this, "Vous avez appuyé sur le bouton !");
			}
		});

		// Ajout d'une image, chargée sour la forme d'une icône, affectée à un JLabel
		// (le chemin pour récupérer l'image est relatif à la racine du projet)
		ImageIcon logo = new ImageIcon("LogoENAC.png");
		JLabel label = new JLabel();
		label.setIcon(logo);
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		pane.add(label);

		// ...
	}

	public static void main(String[] args) {
		// Création et affichage de la fenêtre dans le thread de Swing
		SwingUtilities.invokeLater(() -> {
			new SwingDemo().setVisible(true);
		});
	}

}
