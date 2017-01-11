package fi.ShoppingList.Tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * ShoppingListReader contains one method that reads a ShoppingList.txt file
 * which is located in the src/ folder. It saves the input which it got from
 * the file to a String. It returns the String when the method is called.
 *
 * @author          Ville Haapavaara        ville.haapavaara@cs.tamk.fi
 * @version         2016-11-23
 * @since           1.8
 */
public class ShoppingListReader {

    /**
     * Reads a file then passes it to a linked list.
     *
     * Read input of a ShoppingList.txt file and pass it to a String. Return
     * this String.
     *
     * @return      Returns the input of the file in String format.
     */
    public static String readFromFile() {
        String fileInfoInString = "";

        try (BufferedReader br = new BufferedReader
                (new FileReader("src/ShoppingList.txt"))) {
            fileInfoInString = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileInfoInString;
    }

    /**
     * Reads a file with a name then passes it to a linked list.
     *
     * Reads the file which name is given in the parameters. It then passes
     * this input to a string. Returns this string.
     *
     * @param file  The file that's going to be passes to the linked list.
     * @return      Returns the input of the file in String format.
     */
    public static String readFromFile(File file) {
        String fileInfoInString = "";

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            fileInfoInString = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileInfoInString;
    }
}
