package fi.ShoppingList;

/**
 * MyLinkedList is a class that links different ListItem objects to each
 * other. When a first ListItem object is added to a list it's set to be
 * the first item of the list. The next item that's added is going to be
 * the second item in the list. The first item has an attribute called
 * 'nextItem'. List's first item's next item is going to be the item that
 * was added second. The third item is going to be linked to the second
 * item's 'nextItem' attribute and so on. The object's in the list are
 * linked to each other and are not e.g. value of an attribute of an
 * object.
 *
 * @author          Ville Haapavaara            ville.haapavaara@cs.tamk.fi
 * @version         2016-11-18
 * @since           1.8
 */
public class MyLinkedList {

    /**
     * First item of the MyLinkedList.
     */
    private ListItem firstItem = null;

    /**
     * Curren item of the list when iterated.
     */
    private ListItem currentItem = null;

    /**
     * Size of the list.
     */
    private int size = 0;

    /**
     * Constructs the object and sets the necessary items.
     *
     * Constructs a MyLinkedList object. List's first and current items are
     * set to null. Size is set to 0.
     */
    public MyLinkedList() {
        firstItem = null;
        currentItem = null;
        size = 0;
    }

    /**
     * Adds an item to the list.
     *
     * Adds an item to the linked list. If list's size is 0, the item is set
     * to be the first item on the list. If the list is not empty, the method
     * starts to iterate through the list until it finds an list item that
     * has no next item. It then adds the item that the method got as a
     * parameter to that item's next item. Size of the list is now increased
     * by one.
     *
     * @param item  The item that's going to be added to the list.
     */
    public void add(ListItem item) {
        if (size == 0) {
            firstItem = item;
            size++;
        } else {
            currentItem = firstItem;

            while (true) {
                if (currentItem.getNextItem() != null) {
                    currentItem = currentItem.getNextItem();
                } else {
                    currentItem.setNextItem(item);
                    size++;
                    break;
                }
            }
        }
    }

    /**
     * Clears the list.
     *
     * Clears the list by setting the first item to be null. Nothing then
     * links to the first item of the list so it's no more.
     */
    public void clear() {
        firstItem = null;
        size = 0;
    }

    /**
     * Gets a list item with a specific index.
     *
     * Gets the list item at a current index. Index is given as a parameter.
     * First item of the list is index number 0. The second is index number
     * 1 and so on. Method returns the list item at the specified index if
     * it find one.
     *
     * @param index     Index that's going to be checked.
     * @return          List item at the given index.
     */
    public ListItem get(int index) {
        currentItem = null;

        if (firstItem != null) {
            currentItem = firstItem;

            if (index > 0) {
                for (int i = 0; i < index; i++) {
                    currentItem = currentItem.getNextItem();
                }
            }
        }

        return currentItem;
    }

    /**
     * Returns true if there's no firstItem.
     *
     * Checks if the list is empty e.g. checks if there is a firstItem in the
     * list.
     *
     * @return      Returns true if there is no firstItem in the list.
     */
    public boolean isEmpty() {
        if (firstItem == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Removes an item from the list.
     *
     * Removes a list item at the specific index if there's an item. If an
     * item is found and removed, the size of the list is reduced by one.
     *
     * @param index     Index of an list item that's going to get removed.
     * @return          The list item that got removed.
     */
    public ListItem remove(int index) {
        System.out.println("Object");
        ListItem prevItem = null;
        ListItem removedItem = null;

        if (firstItem != null) {
            currentItem = firstItem;

            if (index == 0) {
                removedItem = currentItem;

                if (size > 1) {
                    firstItem = currentItem.getNextItem();
                    size--;
                } else {
                    System.out.println("index = 0, size = 0");
                    firstItem = null;
                    size = 0;
                }
            } else {
                for (int i = 0; i < index; i++) {
                    prevItem = currentItem;
                    currentItem = currentItem.getNextItem();
                }

                if (currentItem.getNextItem() != null) {
                    prevItem.setNextItem(currentItem.getNextItem());
                } else {
                    prevItem.setNextItem(null);
                }

                removedItem = currentItem;
                size--;
            }
        }

        return removedItem;
    }

    /**
     * Removes a list item by it's name.
     *
     * Removes a list item that the method got as a parameter. The method
     * checks if the name of the item that it got as a parameter is equals
     * with any item's name that's already on the list. If a match is found
     * an item is removed.
     *
     * @param item      Item that's going to be removed.
     * @return          Returns true if an item got removed.
     */
    public boolean remove(ListItem item) {
        System.out.println("Boolean");
        String listItemName = item.getName();
        currentItem = firstItem;
        ListItem prevItem = null;
        ListItem removedItem = null;
        boolean objectRemoved = false;

        if (firstItem != null) {
            for (int i = 0; i < size; i++) {
                if (currentItem.getName().equals(listItemName)) {
                    removedItem = currentItem;
                    objectRemoved = true;

                    if (i > 0) {
                        prevItem.setNextItem(currentItem.getNextItem());
                    }
                } else {
                    prevItem = currentItem;
                    currentItem = currentItem.getNextItem();
                }
            }
        }

        return objectRemoved;
    }

    /**
     * Returns the first item of the list.
     *
     * @return      The first item of the list.
     */
    public ListItem getFirstItem() {
        return firstItem;
    }

    /**
     * Returns the size of the list as an integer.
     *
     * @return      The size of the list.
     */
    public int getSize() {
        return size;
    }

    /**
     * Passes the linked list to a string.
     *
     * Returns the list as a string. The string is formatted so that the rest
     * of the apps functions can handle the string returned.
     *
     * @return      The list as a string.
     */
    public String toString() {
        String listString = "";
        String currentItemInfo = "";

        if (getFirstItem() != null) {
            ListItem currentItem = getFirstItem();

            while (true) {
                currentItemInfo = currentItem.getAmount() + " " +
                        currentItem.getName() + ";";
                listString += currentItemInfo;

                if (currentItem.getNextItem() != null) {
                    currentItem = currentItem.getNextItem();
                } else {
                    break;
                }
            }
        }

        return listString;
    }
}
