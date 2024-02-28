package fr.enac.tictactoe;

import fr.enac.tictactoe.model.TicTacToeModel;
import fr.enac.tictactoe.view.TicTacToeSwingView;
import fr.enac.tictactoe.view.TicTacToeTextView;
import javax.swing.SwingUtilities;

/**
 * Factory (in the sense of "Design Pattern") of the different versions of the tic-tac-toe game. 
 * https://en.wikipedia.org/wiki/Factory_method_pattern
 *
 * @author leriche
 *
 */
public abstract class MainTicTacToeFactory {
    
    private static final TicTacToeModel MODEL = new TicTacToeModel(3, 3);

    /**
     * Launch the game in its textual version.
     */
    @SuppressWarnings("unused")
    private static void launchTextView() {
        new TicTacToeTextView(MODEL);
    }

    /**
     * Launch the game in its Swing version.
     */
    @SuppressWarnings("unused")
    private static void launchSwingView() {
        // How to launch a Swing application:
        // https://docs.oracle.com/javase/tutorial/uiswing/concurrency/initial.html
        SwingUtilities.invokeLater(() -> {
            //new TicTacToeSwingView(MODEL);
            // The previous line is commented in order to compile and execute 
            // the provided code even without the class TicTacToeSwingView yet to create.
            // When creating this class, do not forget to uncomment this line
            // to be able to use the factory...
        });
    }

    public static void main(String[] args) {
        // The factory setup is here: 
        // UnComment the method corresponding to the view you want to create,
        // Comment the other(s)...
        launchTextView();
        //launchSwingView();
    }

}
