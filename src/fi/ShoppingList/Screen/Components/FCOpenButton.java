package fi.ShoppingList.Screen.Components;

import fi.ShoppingList.Screen.MainScreenArea;

import javax.swing.*;

/**
 * FCOpen button has one function: when it's pressed the file chooser menu is
 * opened.
 *
 * @author          Ville Haapavaara        ville.haapavaara@cs.tamk.fi
 * @version         2016-12-20
 * @since           1.8
 */
public class FCOpenButton extends JButton {

    /**
     * The MainScreenArea of the app.
     */
    private MainScreenArea msa;

    /**
     * Constructs a FCOpenButton. Adds also an action listner to it.
     *
     * @param msa   MainScreenArea that contains nesessary methods.
     */
    public FCOpenButton(MainScreenArea msa) {
        super("Open file chooser");
        this.msa = msa;
        this.addActionListener((e -> {
            buttonPressed();
        }));
    }

    /**
     * Calls the file chooer menus fcOpen method that opens the file chooser.
     */
    private void buttonPressed() {
        msa.getFileChooserMenu().fcOpen();
    }
}
