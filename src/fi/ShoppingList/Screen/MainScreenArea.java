package fi.ShoppingList.Screen;

import fi.ShoppingList.*;
import fi.ShoppingList.Screen.Components.*;

import javax.swing.*;
import java.awt.*;

/**
 * MainScreenArea is the view of the app. It contains all the buttons, labels,
 * tables and text fields that are required for the app to function. It also
 * sets the GUI properly and it can reset the view when the table is updated.
 *
 * @author          Ville Haapavaara        ville.haapavaara@cs.tamk.fi
 * @version         2016-12-20
 * @since           1.8
 */
public class MainScreenArea extends JPanel {

    /**
     * MainScreen object that contains necessary methods.
     */
    private MainScreen ms;

    /**
     * ShoppingListTable is the table format of the current linked list.
     */
    private ShoppingListTable slt;

    /**
     * The linked list in a table form.
     */
    private JTable table;

    /**
     * Constraints for the grid bag layout.
     */
    private GridBagConstraints gbc;

    /**
     * Scroll pane for the view.
     */
    private JScrollPane scrollPane;

    /**
     * Title of the view.
     */
    private TitleLabel title;

    /**
     * Save button to save the list. Deprecated.
     */
    private SaveButton saveButton;

    /**
     * Saves button for the dropbox saving function.
     */
    private SaveToDropboxButton saveToDropboxButton;

    /**
     * Adds a new item to the list.
     */
    private AddButton addButton;

    /**
     * Clear button for clearing the active list.
     */
    private ClearButton clearButton;

    /**
     * Name of the item that's going to be added to the list.
     */
    private ItemNameTextField itemName;

    /**
     * Amount of the item that's going to be added to the list.
     */
    private ItemAmountTextField itemAmount;

    /**
     * File chooser menu to open and save shopping lists.
     */
    private FileChooserMenu fcm;

    /**
     * Opens the file chooser save a file menu.
     */
    private FCSaveButton fcSaveButton;

    /**
     * Opens the file chooser open file menu.
     */
    private FCOpenButton fcOpenButton;

    /**
     * Constructs the object and it's components.
     *
     * Constructs a MainScreenArea and all it's components. It also sets the
     * layout of the GUI.
     *
     * @param ms    MainScreen that contains nessessary methods.
     */
    public MainScreenArea(MainScreen ms) {
        this.ms = ms;
        slt = new ShoppingListTable(ShoppingListCore.getList());
        fcm = new FileChooserMenu(this);
        title = new TitleLabel();
        saveButton = new SaveButton(this);
        saveToDropboxButton = new SaveToDropboxButton(this);
        clearButton = new ClearButton(this);
        addButton = new AddButton(this);
        itemName = new ItemNameTextField();
        itemAmount = new ItemAmountTextField();
        table = slt.getShoppingListTable();
        scrollPane = new JScrollPane(table);
        fcOpenButton = new FCOpenButton(this);
        fcSaveButton = new FCSaveButton(this);

        setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        setLayoutAndComponents();
    }

    /**
     * Resets the view.
     *
     * Resets the view by removing every component from it and adding the
     * again to the view.
     */
    public void resetJScrollPane() {
        System.out.println("resetJScrollPane");
        slt.setTable();
        table = slt.getShoppingListTable();
        remove(scrollPane);
        remove(fcOpenButton);
        remove(fcSaveButton);
        remove(title);
        remove(saveButton);
        remove(saveToDropboxButton);
        remove(clearButton);
        remove(addButton);
        remove(itemName);
        remove(itemAmount);
        scrollPane = new JScrollPane(table);
        setLayoutAndComponents();
        // table.setPreferredScrollableViewportSize(new Dimension(400, 300));
        // table.setFillsViewportHeight(true);
        // gbc.gridx = 0;
        // gbc.gridy = 1;
        // gbc.fill = GridBagConstraints.HORIZONTAL;
        // add(scrollPane, gbc);
        revalidate();
        repaint();
    }

    /**
     * Returns the file chooser menu for objects that need it's methods.
     *
     * @return  FileChooserMenu that contains nessessary methods.
     */
    public FileChooserMenu getFileChooserMenu() {
        return fcm;
    }

    /**
     * Returns the itemName's input.
     *
     * Returns the itemName's current input for the objects that need.
     * it.
     *
     * @return  Name of the new item as a string.
     */
    public String getItemName() {
        return itemName.getInput();
    }

    /**
     * Returns the itemAmount's current input for the objecs that need it.
     *
     * @return  Amount of the new item as a string.
     */
    public String getItemAmount() {
        return itemAmount.getInput();
    }

    /**
     * Adds the components to the view.
     *
     * Sets the table's size for the view and all the other components that are
     * shown in the view. Sets the x and y values of every component for the
     * view.
     *
     */
    private void setLayoutAndComponents() {
        table.setPreferredScrollableViewportSize(new Dimension(400, 300));
        table.setFillsViewportHeight(true);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.fill = GridBagConstraints.NONE;
        add(title, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(scrollPane, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(new JLabel("Add an item:"), gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(new JLabel("Item name"), gbc);
        gbc.gridy++;
        add(itemName, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(new JLabel("Item amount"), gbc);
        gbc.gridy++;
        add(itemAmount, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(addButton, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(new JLabel(" "), gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(fcOpenButton, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(fcSaveButton, gbc);

        gbc.gridy++;
        add(saveToDropboxButton, gbc);
        gbc.gridy++;
        add(clearButton, gbc);
    }
}
