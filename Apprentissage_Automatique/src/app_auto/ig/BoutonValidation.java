/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.ig;

import app_auto.algo.KPlusProcheVoisin;
import app_auto.graph.TraceurGraphique;
import app_auto.utils.IgConstante;
import app_auto.utils.BufferedImageToMatrix;
import app_auto.utils.ChiffreMatriceFreeman;
import app_auto.utils.CodeFreeman;
import app_auto.utils.Erreurs;
import app_auto.utils.Reader;
import app_auto.utils.Writer;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 *
 * @author kaldoran
 */
public class BoutonValidation extends JPanel implements ActionListener {

    private JButton reset;
    private ArrayList<ChiffreMatriceFreeman> base;

    public BoutonValidation() {
        super();
        this.setPreferredSize(new Dimension(50, 50));

        Reader reader = new Reader();
        base = reader.recupTotal();
        TraceurGraphique traceur = new TraceurGraphique();
        traceur.creerDonneeApprentissage(base);
        traceur.afficherReprensationGraphiqueBase();

        IgConstante.BOUTON_VALIDATION = new JButton("Valider");
        IgConstante.BOUTON_VALIDATION.addActionListener(this);
        IgConstante.BOUTON_VALIDATION.setPreferredSize(new Dimension(85, 24));
        this.add(IgConstante.BOUTON_VALIDATION, BorderLayout.WEST);

        reset = new JButton("Reset");
        reset.addActionListener(this);
        reset.setPreferredSize(new Dimension(85, 24));
        this.add(reset, BorderLayout.EAST);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(reset)) {
            IgConstante.CODE_FREEMAN.setText("");
            IgConstante.VALEUR_TROUVEE.setText("");
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
            IgConstante.CODE_FREEMAN.setToolTipText(resFree);

            if (IgConstante.RESULTAT_TROUVEE.getBorder().equals(IgConstante.OUT)) {
                // on calcul les k-plus proche voisin 
                KPlusProcheVoisin kppv = new KPlusProcheVoisin();

                String s = String.valueOf(kppv.kppv(matrice, base, IgConstante.NUMBER_KPPV, IgConstante.ALGO_NUMBER));
                IgConstante.VALEUR_TROUVEE.setText(s);
            } else {
                Writer redac = new Writer();
                redac.enregistrer(IgConstante.VALEUR_TROUVEE.getText(), matrice, resFree);
            }
        }

        /* Dans le cas de reset ou valider, on reset le champs */
        IgConstante.VALEUR_TROUVEE.requestFocus();
        IgConstante.DESSIN.clean();

        if (IgConstante.BOUTON_RADIO.getState() == false) {
            IgConstante.VALEUR_TROUVEE.setText("");
            IgConstante.BOUTON_VALIDATION.setEnabled(false);
        }
    }
}
