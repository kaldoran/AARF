/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.ig;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author kaldoran
 */
public class TexteResultatTrouvee extends TexteResultat {

    public TexteResultatTrouvee() {
        super();

        this.setHighlighter(null);
        this.setFocusable(false);
        this.setFont(new Font("Serif", Font.PLAIN, 18));
        this.setHorizontalAlignment(JTextField.CENTER);
    }

}
