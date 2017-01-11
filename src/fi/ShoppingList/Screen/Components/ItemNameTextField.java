package fi.ShoppingList.Screen.Components;

import javax.swing.*;

/**
 * ItemNameTextField is a text field object that takes the user input of the
 * name for the new item.
 *
 * @author          Ville Haapavaara        ville.haapavaara@cs.tamk.fi
 * @version         2016-12-20
 * @since           1.8
 */
public class ItemNameTextField extends JTextField {

    /**
     * Returns the text of the text field.
     *
     * @return  Text of the text field.
     */
    public String getInput() {
        return getText();
    }
}
