package fi.ShoppingList.Screen.Components;

import com.dropbox.core.DbxException;
import fi.ShoppingList.Screen.MainScreenArea;
import fi.ShoppingList.Tools.ShoppingListToDropbox;
import javax.swing.*;
import java.io.IOException;

/**
 * SaveToDropboxButton button pressed action saves the currently active linked
 * list to the Dropbox. Works only for Ville Haapavaara.
 *
 * @author          Ville Haapavaara        ville.haapavaara@cs.tamk.fi
 * @version         2016-12-20
 * @since           1.8
 */
public class SaveToDropboxButton extends JButton {

    /**
     * The MainScreenArea of the app.
     */
    private MainScreenArea msa;

    /**
     * Constructs the button and adds an action listener to it.
     *
     * @param msa   MainScreenArea for the necessary methods.
     */
    public SaveToDropboxButton(MainScreenArea msa) {
        super("Save to DB");
        this.msa = msa;
        this.addActionListener((e -> {
            try {
                buttonPressed();
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (DbxException e1) {
                e1.printStackTrace();
            }
        }));
    }

    /**
     * Calls a method to save the linked list to a file in dropbox.
     *
     * @throws IOException      Invalid input or output.
     * @throws DbxException     Invalid dropbox function.
     */
    private void buttonPressed() throws IOException, DbxException {
        System.out.println("Button: Save to dropbox");
        ShoppingListToDropbox.saveToDropbox();
    }
}
