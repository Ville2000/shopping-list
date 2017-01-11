package fi.ShoppingList.Screen.Components;

import fi.ShoppingList.Screen.MainScreenArea;

import javax.swing.*;

/**
 * FCSaveButton has one function: when it's pressed the file chooser menu's
 * save function menu is opened.
 *
 * @author          Ville Haapavaara        ville.haapavaara@cs.tamk.fi
 * @version         2016-12-20
 * @since           1.8
 */
public class FCSaveButton extends JButton {

    /**
     * The MainScreenArea of the app.
     */
    private MainScreenArea msa;

    /**
     * Constructs a FCSaveButton and adds an action listener to it.
     *
     * @param msa   MainScreenArea that contains nessessary methods.
     */
    public FCSaveButton(MainScreenArea msa) {
        super("Save with file chooser");
        this.msa = msa;
        this.addActionListener((e -> {
            buttonPressed();
        }));
    }

    /**
     * Saves the active linked list.
     *
     * Calls the file chooser menus fcSave method that saves the currently
     * active linked list.
     */
    private void buttonPressed() {
        msa.getFileChooserMenu().fcSave();
    }
}
