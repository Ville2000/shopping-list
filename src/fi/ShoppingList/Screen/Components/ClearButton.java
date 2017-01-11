package fi.ShoppingList.Screen.Components;

import fi.ShoppingList.Screen.MainScreenArea;
import fi.ShoppingList.Tools.ListHandler;

import javax.swing.*;

/**
 * Clear button has one function: when it's pressed the currently set linked
 * list is cleared.
 *
 * @author          Ville Haapavaara        ville.haapavaara@cs.tamk.fi
 * @version         2016-12-20
 * @since           1.8
 */
public class ClearButton extends JButton{

    /**
     * The MainScreenArea of the app.
     */
    private MainScreenArea msa;

    /**
     * Constructs a ClearButton.
     *
     * Constructs a ClearButton and gives it a name. Adds also an action
     * listener to the object.
     *
     * @param msa   MainScreenAre that contains nessessary methods.
     */
    public ClearButton(MainScreenArea msa) {
        super("Clear list");
        this.msa = msa;
        this.addActionListener(e -> {
            buttonPressed();
        });
    }

    /**
     * Clears the current linked list.
     *
     * Calls the list handlers resetList method that clears the currently
     * active linked list. After this the MSA is reset.
     */
    private void buttonPressed() {
        System.out.println("Button: Clear button");
        ListHandler.resetList();
        ListHandler.linkedListToFile();
        msa.resetJScrollPane();
    }
}
