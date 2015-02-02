/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.ig;

import app_auto.utils.IgConstante;
import app_auto.utils.BufferedImageToMatrix;
import app_auto.utils.CodeFreeman;
import app_auto.utils.Erreurs;
import app_auto.utils.FichierConstante;
import app_auto.utils.Writer;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author kaldoran
 */
public class BoutonValidation extends JPanel implements ActionListener {

    private JButton reset;

    public BoutonValidation() {
        super();
        this.setPreferredSize(new Dimension(50, 50));

        IgConstante.BOUTON_VALIDATION = new JButton("Valider");
        IgConstante.BOUTON_VALIDATION.addActionListener(this);
        this.add(IgConstante.BOUTON_VALIDATION, BorderLayout.WEST);

        reset = new JButton("Reset");
        reset.addActionListener(this);
        this.add(reset, BorderLayout.EAST);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(reset)) {
            IgConstante.DESSIN.clean();
            IgConstante.CODE_FREEMAN.setText("");
            IgConstante.VALEUR_TROUVEE.setText("");
            IgConstante.BOUTON_VALIDATION.setEnabled(false);
            IgConstante.VALEUR_TROUVEE.requestFocus();
        }

        if (e.getSource().equals(IgConstante.BOUTON_VALIDATION)) {
            BufferedImageToMatrix bim = new BufferedImageToMatrix(IgConstante.DESSIN.getImage());
            int[][] matrice = bim.getMatrix();
            CodeFreeman morgan = new CodeFreeman();

            String resFree;
            try {
                resFree = morgan.matriceToFreeman(matrice);
            } catch (Erreurs.MatriceVide | Erreurs.MatriceNull ex) {
                resFree = "err";
            }

            IgConstante.CODE_FREEMAN.setText(resFree);

            if (IgConstante.RESULTAT_TROUVEE.getBorder().equals(IgConstante.OUT)) {

            } else {
                Writer redac = new Writer();
                redac.enregistrer(IgConstante.VALEUR_TROUVEE.getText(), matrice, resFree);
            }
        }
    }
}
