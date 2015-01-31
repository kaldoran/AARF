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

    private JButton validation;
    private JButton reset;

    public BoutonValidation() {
        super();
        this.setPreferredSize(new Dimension(50, 50));

        validation = new JButton("Valider");
        validation.addActionListener(this);
        this.add(validation, BorderLayout.WEST);

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
        }

        if (e.getSource().equals(validation)) {
            BufferedImageToMatrix bim = new BufferedImageToMatrix(IgConstante.DESSIN.getImage());
            CodeFreeman morgan = new CodeFreeman();
            
            String resFree;
            try {
                resFree = morgan.codeFreeman(bim.getMatrix());
            } catch (Erreurs.MatriceVide | Erreurs.MatriceNull ex) {
                resFree = "err";
            }
            
            IgConstante.CODE_FREEMAN.setText(resFree);
            
            if (IgConstante.RESULTAT_TROUVEE.getBorder().equals(IgConstante.OUT)) {
                
            } else {
                Writer redac = new Writer();
                redac.enregistrer(IgConstante.VALEUR_TROUVEE.getText(), bim.getMatrix(), resFree);
            }
        }
    }
}
