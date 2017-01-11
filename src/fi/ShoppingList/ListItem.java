package fi.ShoppingList;

/**
 * ListItem is an item that is saved to a linked list. In this case a list item
 * has a name and amount representing an item in the shopping list. List item
 * has also a next item.
 *
 * @author          Ville Haapavaara        ville.haapavaara@cs.tamk.fi
 * @version         2016-12-19
 * @since           1.8
 */
public class ListItem {

    /**
     * Name of the item.
     */
    private String name;

    /**
     * Amount of the item.
     */
    private int amount = 0;

    /**
     * Next item of this item.
     */
    private ListItem nextItem;

    /**
     * Constructs a new list item. Takes amount and name as parameters.
     *
     * @param amount    The amount of the given item.
     * @param name      The name of the item.
     */
    public ListItem(int amount, String name) {
        setName(name);
        setAmount(amount);
    }

    /**
     * Sets the item's name to a name given as a parameter.
     *
     * @param name      The name that's set for the item.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the name of the item.
     *
     * @return      The name of the item.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the item's amount to amount given as a parameter.
     *
     * @param amount    The amount that's set for the item.
     */
    public void setAmount(int amount) {
        if (amount < 0) {
            if (this.amount + amount <= 0) {
                this.amount = 0;
            } else {
                this.amount += amount;
            }
        } else {
            this.amount += amount;
        }
    }

    /**
     * Returns the amount of the item.
     *
     * @return      The amount of the item.
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Updates the amount of the item.
     *
     * Sums up the current amount of the item with the amount that's been given
     * as a parameter.
     *
     * @param amount    The amount that's going to get summed.
     */
    public void updateAmount(int amount) {
        this.amount += amount;
    }

    /**
     * Sets the item's next item.
     *
     * Sets the item's nextItem to the ListItem that's been given as a
     * parameter.
     *
     * @param nextItem  The item's next item to be.
     */
    public void setNextItem(ListItem nextItem) {
        this.nextItem = nextItem;
    }

    /**
     * Returns the item's nextItem.
     *
     * @return      Item's next item.
     */
    public ListItem getNextItem() {
        return nextItem;
    }
}
