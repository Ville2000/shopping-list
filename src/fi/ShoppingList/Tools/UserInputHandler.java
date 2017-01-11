package fi.ShoppingList.Tools;

import fi.ShoppingList.ShoppingListCore;

import java.util.Scanner;

/**
 * UserInputHandler handles the input that's been given to the app as command
 * line parameters. This class is not used when the user chooses to use the
 * GUI.
 *
 * @author          Ville Haapavaara        ville.haapavaara@cs.tamk.fi
 * @version         2016-12-19
 * @since           1.8
 */
public class UserInputHandler {

    /**
     * Scanner for the user input.
     */
    private Scanner sc;

    /**
     * Constructs the object and creates the scanner.
     */
    public UserInputHandler() {
        sc = new Scanner(System.in);
    }

    /**
     * Reads the user input.
     *
     * Reads the user given input and acts according to it. There are a few
     * options for the input: 1. if the input is 'list' the app lists every
     * item that's on currently in the linked list, 2. if the input is 'exit'
     * the app closes itself. If the input is something else the app takes it
     * as a new list item, parses it and tries to add it to the linked list.
     *
     * @param slc   The ShoppingListCore object.
     */
    public void getUserInput(ShoppingListCore slc) {
        userInputQuestion();
        String userInput = sc.nextLine();

        if (userInput.equals("list")) {
            if (slc.getList().getFirstItem() == null) {
                ListHandler.fileToMyLinkedList();
            } else {
                ListHandler.printAll();
            }
        } else if (userInput.equals("exit")) {
            ShoppingListWriter.writeToFile();
            System.exit(0);
        } else {
            parseInput(userInput);
        }
    }

    /**
     * Parses the user given input.
     *
     * Parses the user input if it's not 'list' nor 'exit'. It splits the user
     * given input String by the ';' chars to an array. It then parses every
     * array item by the spaces (" ") and to another array and passes these
     * arrays to the ListHandler object. This way the user can add several
     * items at once.
     *
     * @param input     The user given input.
     */
    private static void parseInput(String input) {

        String[] parsedInput = input.split(";");

        for (String item : parsedInput) {
            String[] parsedArrayItem = item.split(" ");
            ListHandler.checkExistenceAndAdd(parsedArrayItem);
        }

        ListHandler.printAll();
    }

    /**
     * Prints the helper line to the console.
     */
    private static void userInputQuestion() {
        System.out.println
                ("Give shopping list (example: 1 milk;2 tomato;3 carrot;)");
    }
}
