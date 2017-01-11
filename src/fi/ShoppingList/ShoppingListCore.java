package fi.ShoppingList;

import fi.ShoppingList.Screen.MainScreen;
import fi.ShoppingList.Tools.ListHandler;
import fi.ShoppingList.Tools.UserInputHandler;

import java.util.Scanner;

/**
 * ShoppingListCore is a core object for the app. It creates the linked list
 * and a handler for the user input. It also calls the list handler to pass the
 * ShoppingList.txt file to the app linked list. Here you can also set how the
 * app is run: in a console or in a GUI.
 *
 * @author          Ville Haapavaara        ville.haapavaara@cs.tamk.fi
 * @version         2016-12-20
 * @since           1.8
 */
public class ShoppingListCore {

    /**
     * Currently active linked list.
     */
    private static MyLinkedList ll;

    /**
     * MainScreen of the GUI.
     */
    private MainScreen ms;

    /**
     * Handles the user given input.
     */
    private UserInputHandler userInputHandler;

    /**
     * Constructs the object and it's necessary objects.
     *
     * Constructs the object and other necessary objects. Here you can decide
     * how the app is run by commenting or uncommenting the last two methods.
     */
    public ShoppingListCore() {
        ll = new MyLinkedList();
        userInputHandler = new UserInputHandler();
        ListHandler.fileToMyLinkedList();

        /**
         * Uncomment that method in which way you want to use the app.
         */
        // runAppInConsole();
        runAppWithGUI();
    }

    /**
     * Runs ShoppingList app in a console.
     */
    private void runAppInConsole() {
        System.out.println("SHOPPING LIST");
        System.out.println("Tampere University of Applied Sciences");
        Scanner sc = new Scanner(System.in);

        while (true) {
            userInputHandler.getUserInput(this);
        }
    }

    /**
     * Runs the app in a GUI.
     *
     * Runs ShoppingList app in GUI. Console can't be used when this is chosen.
     */
    private void runAppWithGUI() {
        ms = new MainScreen(this);

        ShoppingListTable slt = new ShoppingListTable(getList());
    }

    /**
     * Resets the main screen by creating a new one.
     */
    public void resetMainScreen() {
        ms = new MainScreen(this);
    }

    /**
     * Returns the linked list for the object that require it.
     *
     * @return  The currently active linked list.
     */
    public static MyLinkedList getList() {
        return ll;
    }
}
