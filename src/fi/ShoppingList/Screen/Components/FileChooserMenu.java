package fi.ShoppingList.Screen.Components;

import fi.ShoppingList.Screen.MainScreenArea;
import fi.ShoppingList.Tools.ListHandler;

import javax.swing.*;
import java.io.*;

/**
 * FileChooserMenu can open previously saved text files and create new ones
 * from the current linked list. It has only two functions: to open and save
 * shopping lists.
 *
 * @author          Ville Haapavaara        ville.haapavaara@cs.tamk.fi
 * @version         2016-12-20
 * @since           1.8
 */
public class FileChooserMenu extends JFileChooser {

    /**
     * The MainScreenArea of the app.
     */
    private MainScreenArea msa;

    /**
     * Creates a new FileChooserMenu object.
     *
     * Creates a new FileChooserMenu object. It takes MainScreenArea as a
     * parameter since it contains a few nessessary methods. The constructor
     * also sets some nessessary settings straight away including the file
     * selection mode and the working directory. It also creates the buttons
     * and add's their action listeners.
     *
     * @param msa   MainScreenArea that contains nessessary methods.
     */
    public FileChooserMenu(MainScreenArea msa) {
        this.msa = msa;
        setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        File workingDirectory = new File(System.getProperty("user.dir"));
        setCurrentDirectory(workingDirectory);

        this.addActionListener((e -> {

        }));
    }

    /**
     * Opens the file chooser's open file window.
     *
     * Opens the file chooser menu window. If a file is chosen and a 'Open'
     * button is pressed the method passes the file to the ListHandler. After
     * this the GUI is reseted so the current linked list can be viewed.
     */
    public void fcOpen() {
        setApproveButtonText("Open");
        int returnVal = showOpenDialog(msa);

        if (returnVal == this.APPROVE_OPTION) {
            System.out.println("Open");
            ListHandler.resetList();
            File file = getSelectedFile();
            ListHandler.fileToMyLinkedList(file);
            msa.resetJScrollPane();
        }
    }

    /**
     * Opens the file chooser's save file window.
     *
     * Opens the file chooser menu window. If a file name is given and the
     * 'save' button is pressed a text file with the given name is created.
     * The newly created contains the current linked list items.
     */
    public void fcSave() {
        setApproveButtonText("Save");
        int returnVal = showOpenDialog(msa);

        if (returnVal == this.APPROVE_OPTION) {
            System.out.println("Save");
            ListHandler.linkedListToFile(getSelectedFile().getName());
        }
    }
}
