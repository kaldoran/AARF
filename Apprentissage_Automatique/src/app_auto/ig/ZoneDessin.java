/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.ig;

import java.awt.BorderLayout;
import static javax.swing.BorderFactory.createEmptyBorder;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author kaldoran
 */
public class ZoneDessin extends JPanel {

    private Dessin dessin;

    public ZoneDessin() {
        super();
        this.setLayout(new BorderLayout());

        Border outset = createEmptyBorder(0, 3, 0, 3);
        TitledBorder inset = new TitledBorder(null, "Dessin", TitledBorder.CENTER, TitledBorder.CENTER);

        inset.setTitleJustification(TitledBorder.CENTER);

        this.setBorder(new CompoundBorder(outset, inset));

        dessin = new Dessin();
        this.add(dessin);

    }
    
}
