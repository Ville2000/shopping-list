package fi.ShoppingList.Screen;

import fi.ShoppingList.ShoppingListCore;
import javax.swing.*;

/**
 * MainScreen is the frame of the GUI view. It has a title, size and some
 * options.
 *
 * @author          Ville Haapavaara        ville.haapavaara@cs.tamk.fi
 * @version         2016-12-20
 * @since           1.8
 */
public class MainScreen extends JFrame {

    /**
     * ShoppingListCore object that contains necessary methods.
     */
    private ShoppingListCore slc;

    /**
     * MainScreenArea which this constructs.
     */
    private MainScreenArea msa;

    /**
     * Constructs the object and adds a title to it.
     *
     * Constructs a MainScreen object and adds a title to it. Also sets the
     * close function for the frame and it's size. It also sets the frame to
     * be visible.
     *
     * @param slc   ShoppingListCore that contains necessary methods.
     */
    public MainScreen(ShoppingListCore slc) {
        this.slc = slc;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("ShoppingList");
        setSize(500, 400);
        msa = new MainScreenArea(this);
        msa.setOpaque(true);
        setContentPane(msa);
        pack();
        setVisible(true);
    }
}
