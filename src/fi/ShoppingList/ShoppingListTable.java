package fi.ShoppingList;

import javax.swing.*;

/**
 * ShoppingListTable contains the table form of the currently active linked
 * list. The table has headers.
 *
 * @author          Ville Haapavaara        ville.haapavaara@cs.tamk.fi
 * @version         2016-12-20
 * @since           1.8
 */
public class ShoppingListTable {

    /**
     * Table form of the linked list.
     */
    private JTable slt;

    /**
     * Currently active linked list.
     */
    private MyLinkedList ll;

    /**
     * Headers of the table's columns.
     */
    private String[] columnHeaders = {"Amount",
            "Item name"};

    /**
     * The items of the linked list.
     */
    private String[][] data;

    /**
     * Constructor of the object.
     *
     * Constructs the object and sets it. Also sets the objects linked list
     * attribute to be the currently active linked list.
     *
     * @param ll    Currently active linked list.
     */
    public ShoppingListTable(MyLinkedList ll) {
        this.ll = ll;
        setTable();
    }

    /**
     * Sets the table for the view.
     *
     * Sets the table. It gets the data from the linked list and parses it so
     * it fits the table form. It then creates a new JTable object and passes
     * the data and the headers to it.
     */
    public void setTable() {
        ListItem currentItem = ll.getFirstItem();
        System.out.println(currentItem);

        if (currentItem != null) {
            data = new String[ll.getSize()][2];

            for (int i = 0; i < ll.getSize(); i++) {
                data[i][0] = String.valueOf(currentItem.getAmount());
                data[i][1] = currentItem.getName();

                if (currentItem.getNextItem() != null) {
                    currentItem = currentItem.getNextItem();
                } else {
                    break;
                }
            }

            slt = new JTable(data, columnHeaders);
        } else {
            slt = new JTable();
        }
    }

    /**
     * Returns the current table.
     *
     * @return  Current table.
     */
    public JTable getShoppingListTable() {
        return slt;
    }
}
