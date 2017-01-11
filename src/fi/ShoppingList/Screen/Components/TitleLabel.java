package fi.ShoppingList.Screen.Components;

import javax.swing.*;
import java.awt.*;

/**
 * TitleLabel is a headline of the app, the one that's shown on the top of the
 * screen when the app is used in it's GUI form.
 *
 * @author          Ville Haapavaara        ville.haapavaara@cs.tamk.fi
 * @version         2016-12-20
 * @since           1.8
 */
public class TitleLabel extends JLabel {

    /**
     * Constructs the TitleLable, adds a name for it and sets it's font.
     */
    public TitleLabel() {
        super("SHOPPING LIST");
        this.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
    }
}
