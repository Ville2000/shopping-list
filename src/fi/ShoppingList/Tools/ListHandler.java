package fi.ShoppingList.Tools;

import fi.ShoppingList.ListItem;
import fi.ShoppingList.MyLinkedList;
import fi.ShoppingList.ShoppingListCore;

import java.io.File;

/**
 * ListHandler can add new list items to the current linked list. It also
 * handles the file reading and writing. It's also responsible for printing
 * of the list to the console in the console version.
 *
 * @author          Ville Haapavaara        ville.haapavaara@cs.tamk.fi
 * @version         2016-12-20
 * @since           1.8
 */
public class ListHandler {

    /**
     * Checks if an item exists and then adds it accordingly.
     *
     * Takes an array containing amount and a name for a list item. It then
     * iterates through the current linked list and updates the item's amount
     * if there's one already with the item name that's set in the parameter
     * array. If there's no such item, it'll add one to the list.
     *
     * @param array     Array with amount and name for a new item.
     */
    public static void checkExistenceAndAdd(String[] array) {
        ListItem currentItem = ShoppingListCore.getList().getFirstItem();
        int listSize = ShoppingListCore.getList().getSize();
        boolean itemAdded = false;

        if (currentItem == null) {
            ShoppingListCore.getList().add(new ListItem
                    (Integer.parseInt(array[0]),
                    array[1]));
            itemAdded = true;
        }

        if (itemAdded == false) {
            for (int i = 0; i < listSize; i++) {
                if (currentItem.getName().equals(array[1])) {
                    currentItem.setAmount(Integer.parseInt(array[0]));
                    itemAdded = true;
                }

                if (currentItem.getNextItem() != null) {
                    currentItem = currentItem.getNextItem();
                }
            }
        }

        if (itemAdded == false) {
            ShoppingListCore.getList().add(new ListItem
                    (Integer.parseInt(array[0]),
                    array[1]));
        }
    }

    /**
     * Passes the file to a linked list.
     *
     * Calls the ShoppingListReader's readFromFile method. Only reads the
     * ShoppingList.txt named file. Only used when the app starts and the
     * console version uses only to pass the file to the linked
     * list.
     */
    public static void fileToMyLinkedList() {
        String fileInfo = ShoppingListReader.readFromFile();

        if (fileInfo != null) {
            String[] parsedFileInfo = fileInfo.split(";");

            for (String item : parsedFileInfo) {
                String[] parsedArrayItem = item.split(" ");
                checkExistenceAndAdd(parsedArrayItem);
            }
        }
    }

    /**
     * Passes the file with a given name to linked list.
     *
     * Calls the ShoppingListReader's readFromFile method that takes a file as
     * a parameter. The file chooser uses to pass file to a
     * linked list.
     *
     * @param file  Name of the file.
     */
    public static void fileToMyLinkedList(File file) {
        String fileInfo = ShoppingListReader.readFromFile(file);

        if (fileInfo != null) {
            String[] parsedFileInfo = fileInfo.split(";");

            for (String item : parsedFileInfo) {
                String[] parsedArrayItem = item.split(" ");
                checkExistenceAndAdd(parsedArrayItem);
            }
        }
    }

    /**
     * Saves a linked list to a file.
     */
    public static void linkedListToFile() {
        ShoppingListWriter.writeToFile();
    }

    /**
     * Saves a linked list to a file that's name has been given as a parameter.
     *
     * @param fileName  Name of the save file.
     */
    public static void linkedListToFile(String fileName) {
        ShoppingListWriter.writeToFile(fileName);
    }

    /**
     * Clears the current linked list.
     */
    public static void resetList() {
        ShoppingListCore.getList().clear();
    }

    /**
     * Prints the linked list items accordingly to the console.
     */
    public static void printAll() {
        System.out.println("Your Shopping List now:");
        ListItem currentItem = ShoppingListCore.getList().getFirstItem();

        while (true) {
            System.out.println("  " + currentItem.getAmount() + " " +
                    currentItem.getName());

            if (currentItem.getNextItem() != null) {
                currentItem = currentItem.getNextItem();
            } else {
                break;
            }
        }

        System.out.println();
    }
}
