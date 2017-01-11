package fi.ShoppingList.Tools;

import com.dropbox.core.*;
import java.io.*;
import java.util.Locale;

/**
 * ShoppingListToDropbox saves a current ShoppingList.txt file to the Ville
 * Haapavaara's Dropbox account's App/ShoppingListOOProject/ folder. Previously
 * saved ShoppingList.txt file's are not overwritten. To save the .txt file you
 * need to log in to the dropbox.com service. After you click the GUI's Save to
 * DB button a link appears to the console. You need to click the link and a
 * web page opens to your browser. You need to click allow here. After this a
 * code is given, which you need to copy and paste to the console. Pressing
 * enter starts the saving process which usually takes a few seconds.
 *
 * @author          Ville Haapavaara        ville.haapavaara@cs.tamk.fi
 * @version         2016-12-19
 * @since           1.8
 */
public class ShoppingListToDropbox {

    /**
     * Saves the current linked list to dropbox.
     *
     * Saves the current ShoppingList.txt file to the Dropbox service. This
     * feature requires a pre-generated APP_KEY and an APP_SECRET. After this
     * the user needs to authenticate. After the authentication is done the
     * ShoppingList.txt file is automatically saved to the Dropbox.
     *
     *
     * @throws IOException      Invalid input or output.
     * @throws DbxException     Invalid dropbox functions.
     */
    public static void saveToDropbox() throws IOException, DbxException {
        final String APP_KEY = "gl6grxgwx8zm325";
        final String APP_SECRET = "mpnxua09a1mgzzd";

        DbxAppInfo appInfo = new DbxAppInfo(APP_KEY, APP_SECRET);

        DbxRequestConfig config = new DbxRequestConfig(
                "JavaTutorial/1.0", Locale.getDefault().toString());
        DbxWebAuthNoRedirect webAuth = new DbxWebAuthNoRedirect
                (config, appInfo);

        String authorizeUrl = webAuth.start();
        System.out.println("1. Go to: " + authorizeUrl);
        System.out.println
                ("2. Click \"Allow\" (you might have to log in first)");
        System.out.println("3. Copy the authorization code.");
        String code = new BufferedReader(new InputStreamReader
                (System.in)).readLine().trim();
        System.out.println("Code: " + code);

        DbxAuthFinish authFinish = webAuth.finish(code);
        String accessToken = authFinish.accessToken;

        DbxClient client = new DbxClient(config, accessToken);

        File inputFile = new File("src/ShoppingList.txt");
        FileInputStream inputStream = new FileInputStream(inputFile);
        try {
            DbxEntry.File uploadedFile = client.uploadFile("/ShoppingList.txt",
                    DbxWriteMode.add(), inputFile.length(), inputStream);
            System.out.println("Uploaded: " + uploadedFile.toString());
        } finally {
            inputStream.close();
        }
    }
}
