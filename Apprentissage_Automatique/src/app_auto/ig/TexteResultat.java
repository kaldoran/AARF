/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.ig;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

/**
 *
 * @author kaldoran
 */
public class TexteResultat extends JTextField {

    public TexteResultat() {
        super();
        
        this.setEditable(false);
        this.setBackground(Color.white);
        this.setHighlighter(null);
        this.setFont(new Font("Serif", Font.PLAIN, 18));
        this.setHorizontalAlignment(JTextField.CENTER);
    }

}
