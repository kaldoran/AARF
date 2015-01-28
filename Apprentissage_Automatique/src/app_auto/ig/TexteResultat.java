/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.ig;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

/**
 *
 * @author kaldoran
 */
public class TexteResultat extends JTextField implements KeyListener {

    public TexteResultat() {
        super();

        this.addKeyListener(this);
        this.setHighlighter(null);
        this.setBackground(Color.white);
        this.setFont(new Font("Serif", Font.PLAIN, 18));
        this.setHorizontalAlignment(JTextField.CENTER);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if ( this.getText().length() >= 1
                || ! Character.isDigit(c) ) {
            e.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

}
