package fi.ShoppingList;

import com.dropbox.core.*;

import java.io.*;

/**
 * ShoppingListApp is the main class of the app. It creates a shopping list
 * core object to prevent issues risen from the main method being static.
 *
 * @author          Ville Haapavaara        ville.haapavaara@cs.tamk.fi
 * @version         2016-12-20
 * @since           1.8
 */
public class ShoppingListApp {

    /**
     * Core of the app.
     */
    public static ShoppingListCore slc;

    /**
     * Constructs only a new shopping list core object.
     *
     * Main method of the app.
     *
     * @param args              Command line parameters. Not used.
     * @throws DbxException     Exception for the dropbox functions.
     * @throws IOException      Exception for the input and output.
     */
    public static void main(String[] args) throws DbxException, IOException {
        slc = new ShoppingListCore();
    }

    /**
     * Returns the shopping list core object.
     *
     * @return  Shopping list core object.
     */
    public ShoppingListCore getSlc() {
        return slc;
    }
}
