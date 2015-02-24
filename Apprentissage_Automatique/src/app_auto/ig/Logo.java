/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.ig;

import java.awt.BorderLayout;
import static javax.swing.BorderFactory.createEmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author kaldoran
 */
public class Logo extends JPanel {

    public Logo() {
        super();
        this.setLayout(new BorderLayout());

        Border outset = createEmptyBorder(0, 0, 15, 0);
        this.setBorder(outset);
        JLabel picLabel = new JLabel(new ImageIcon(this.getClass().getResource("/Ressources/bknk.png")));
        this.add(picLabel);

    }
}
