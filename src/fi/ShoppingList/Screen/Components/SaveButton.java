package fi.ShoppingList.Screen.Components;

import fi.ShoppingList.Screen.MainScreenArea;
import fi.ShoppingList.Tools.ListHandler;

import javax.swing.*;

/**
 * SaveButton saves the currently active linked list to a ShoppingList.txt
 * named file. Saving a file with using this button is deprecated. Use the
 * file chooser's saving options instead.
 *
 * @author          Ville Haapavaara        ville.haapavaara@cs.tamk.fi
 * @version         2016-12-20
 * @since           1.8
 */
public class SaveButton extends JButton {

    /**
     * The MainScreenArea of the app.
     */
    private MainScreenArea msa;

    /**
     * Constructs the object, sets it's name and adds an action listener.
     *
     * @param msa   MainScreenArea that constains nessessary methods.
     */
    public SaveButton(MainScreenArea msa) {
        super("Save list");
        this.msa = msa;
        this.addActionListener((e -> {
            buttonPressed();
        }));
    }

    /**
     * Calls a method that saves the linked list to a text file.
     */
    private void buttonPressed() {
        ListHandler.linkedListToFile();
    }
}
