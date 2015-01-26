/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.ig;

import java.awt.Dimension;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

/**
 *
 * @author kaldoran
 */
public class BoutonRadio extends JPanel {

    private TitledBorder bordure;
    private JRadioButton mode_test;
    private JRadioButton mode_ajout;
    private ButtonGroup choix;

    public BoutonRadio() {
        super();
        this.setPreferredSize(new Dimension(150, 70));

        bordure = new TitledBorder("Choix Mode");
        this.setBorder(bordure);

        choix = new ButtonGroup();
        mode_test = new JRadioButton("Mode Tests");
        mode_test.setSelected(true);
        mode_ajout = new JRadioButton("Mode Ajout");

        choix.add(mode_test);
        choix.add(mode_ajout);

        this.add(mode_test);
        this.add(mode_ajout);

    }

}
