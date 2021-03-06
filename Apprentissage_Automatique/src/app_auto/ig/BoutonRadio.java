/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.ig;

import app_auto.utils.IgConstante;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

/**
 *
 * @author kaldoran
 */
public class BoutonRadio extends JPanel implements ItemListener {

    private TitledBorder bordure;
    private JRadioButton mode_test;
    private JRadioButton mode_ajout;
    private ButtonGroup choix;

    public BoutonRadio() {
        super();
        this.setPreferredSize(new Dimension(150, 80));

        bordure = new TitledBorder("Choix Mode");
        this.setBorder(bordure);

        choix = new ButtonGroup();
        mode_test = new JRadioButton("Mode Tests");
        mode_test.addItemListener(this);
        mode_test.setSelected(true);

        mode_ajout = new JRadioButton("Mode Ajout");
        mode_ajout.addItemListener(this);

        choix.add(mode_test);
        choix.add(mode_ajout);

        this.add(mode_test);
        this.add(mode_ajout);

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getItem().equals(mode_test)) {
            IgConstante.VALEUR_TROUVEE.setText("");
            IgConstante.RESULTAT_TROUVEE.setBorder(IgConstante.OUT);
            IgConstante.VALEUR_TROUVEE.setEditable(false);
            if (IgConstante.BOUTON_VALIDATION != null) {
                IgConstante.BOUTON_VALIDATION.setEnabled(true);
                IgConstante.BOUTON_ANNULER.setVisible(false);
            }
        } else {
            IgConstante.BOUTON_VALIDATION.setEnabled(false);
            IgConstante.RESULTAT_TROUVEE.setBorder(IgConstante.IN);
            IgConstante.VALEUR_TROUVEE.requestFocus();
            IgConstante.VALEUR_TROUVEE.setEditable(true);
            IgConstante.BOUTON_ANNULER.setVisible(true);
        }
    }

    public boolean testSelect() {
        return mode_test.isSelected();
    }
    
     public boolean ajoutSelect() {
        return mode_ajout.isSelected();
    }   
}
