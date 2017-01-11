package fi.ShoppingList.Screen.Components;

import fi.ShoppingList.Screen.MainScreenArea;
import fi.ShoppingList.Tools.ListHandler;
import javax.swing.*;

/**
 * Add button has one function: when it's pressed the currently set item name
 * and it's amount is saved to the currently active linked list.
 *
 * @author          Ville Haapavaara        ville.haapavaara@cs.tamk.fi
 * @version         2016-12-20
 * @since           1.8
 */
public class AddButton extends JButton {

    /**
     * The MainScreenArea of the app.
     */
    private MainScreenArea msa;

    /**
     * Constructs a new AddButton object.
     *
     * Adds the name of the button and adds an action listener to it.
     *
     * @param msa   MainScreenArea that contains nessessary methods.
     */
    public AddButton(MainScreenArea msa) {
        super("Add");
        this.msa = msa;
        this.addActionListener((e -> {
            buttonPressed();
        }));
    }

    /**
     * Calls the addFormInputToLinkedList method.
     */
    private void buttonPressed() {
        addFormInputToLinkedList();
    }

    /**
     * Creates a new list item to the linked list from the form input.
     *
     * Takes the MainScreenArea's items name and amount and passes this info to
     * the list handler which then tries to add it to the currently active
     * linked list. After this the MSA is reset.
     */
    private void addFormInputToLinkedList() {
        try {
            String[] item = new String[2];
            item[0] = msa.getItemAmount();
            item[1] = msa.getItemName();
            ListHandler.checkExistenceAndAdd(item);
            msa.resetJScrollPane();
        } catch(NullPointerException e) {
            e.printStackTrace();
        }
    }
}
