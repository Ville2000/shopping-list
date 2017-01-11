package fi.ShoppingList.Tools;

import fi.ShoppingList.ShoppingListCore;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * ShoppingListWriter gets the current MyLinkedList object, and calls it's
 * toString() method. It then writes the String to the Shoppinglist.txt file
 * that gets overrided if it exists already.
 *
 * @author          Ville Haapavaara        ville.haapavaara@cs.tamk.fi
 * @version         2016-11-23
 * @since           1.8
 */
public class ShoppingListWriter {

    /**
     * Passes the linked list to a ShoppingList.txt file.
     *
     * Calls the MyLinkedList object's toString() method. It then passes this
     * String to a ShoppingList.txt file. The file is overrided if it already
     * exists.
     */
    public static void writeToFile() {
        String stringToWrite = ShoppingListCore.getList().toString();

        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter("src/ShoppingList.txt"))) {
            bw.write(stringToWrite);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Passes the linked list to a named text file.
     *
     * Calls the MyLinkedList object's toString() method. It then passes this
     * String to a new text file which name is given in the parameters.
     *
     * @param fileName  Name of the text file.
     */
    public static void writeToFile(String fileName) {
        String stringToWrite = ShoppingListCore.getList().toString();

        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter("src/" + fileName + ".txt"))) {
            bw.write(stringToWrite);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
