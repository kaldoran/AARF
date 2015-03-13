/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.ig;

import app_auto.algo.KPlusProcheVoisin;
import app_auto.algo.ReseauNeurones;
import app_auto.utils.AlgosConstantes;
import app_auto.utils.IgConstante;
import app_auto.utils.BufferedImageToMatrix;
import app_auto.utils.ChiffreMatriceFreeman;
import app_auto.utils.CodeFreeman;
import app_auto.utils.Erreurs;
import app_auto.utils.FichierConstante;
import app_auto.utils.Writer;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jfree.util.StringUtils;

/**
 *
 * @author kaldoran
 */
public class BoutonValidation extends JPanel implements ActionListener {

    private JButton reset;
    private KPlusProcheVoisin kppv = new KPlusProcheVoisin();
    private int resultat;

    public BoutonValidation() {
        super();

        Dimension d = new Dimension(85, 24);
        this.setPreferredSize(new Dimension(50, 50));

        IgConstante.BOUTON_VALIDATION = new JButton("Valider");
        IgConstante.BOUTON_VALIDATION.addActionListener(this);
        IgConstante.BOUTON_VALIDATION.setPreferredSize(d);
        this.add(IgConstante.BOUTON_VALIDATION, BorderLayout.NORTH);

        reset = new JButton("Reset");
        reset.addActionListener(this);
        reset.setPreferredSize(d);
        this.add(reset, BorderLayout.CENTER);

        IgConstante.BOUTON_ANNULER = new JButton("Revert");
        IgConstante.BOUTON_ANNULER.addActionListener(this);
        IgConstante.BOUTON_ANNULER.setPreferredSize(d);
        IgConstante.BOUTON_ANNULER.setVisible(false);
        this.add(IgConstante.BOUTON_ANNULER, BorderLayout.SOUTH);

        resultat = 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(reset)) {
            IgConstante.CODE_FREEMAN.setText("");
            IgConstante.VALEUR_TROUVEE.setText("");
            if ( IgConstante.BOUTON_RADIO.ajoutSelect() ) {
                IgConstante.BOUTON_VALIDATION.setEnabled(false);
            }
        } else if (e.getSource().equals(IgConstante.BOUTON_VALIDATION)) {
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
            
            String[] cutResFree = resFree.split("(?<=\\G.{40})");
            String output = "<html>"; /* Need this for multi line tooltip */
            for (String s : cutResFree)
                output += s + "<br>";
            output += "</html>";
            
            IgConstante.CODE_FREEMAN.setToolTipText(output);

            if (IgConstante.BOUTON_RADIO.testSelect()) {
                // on calcul les k-plus proche voisin 
                String s;
                if (IgConstante.ALGO_NUMBER == AlgosConstantes.CODEFREEMAN) {
                    s = String.valueOf(kppv.kppv(resFree, IgConstante.BASE_APPRENTISSAGE, IgConstante.NUMBER_KPPV));

                } else if (IgConstante.ALGO_NUMBER == AlgosConstantes.NEURONES) {
                    ReseauNeurones rdn = new ReseauNeurones();

                    Writer.ecrireEntreeArff(ChiffreMatriceFreeman.redFreeman(resFree, AlgosConstantes.NB_PART), AlgosConstantes.NB_PART, "?");
                    s = Integer.toString(rdn.tester());
                } else {
                    s = String.valueOf(kppv.kppv(matrice, IgConstante.BASE_APPRENTISSAGE, IgConstante.NUMBER_KPPV, IgConstante.ALGO_NUMBER));
                }

                IgConstante.VALEUR_TROUVEE.setText(s);

                try {
                    sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(BoutonValidation.class.getName()).log(Level.SEVERE, null, ex);
                }

                ImageIcon icone = new ImageIcon(getClass().getResource("/Ressources/iconeQuestion.png"));
                resultat = JOptionPane.showConfirmDialog(null, "Le bon chiffre a-t-il été trouvé ?", "Resultat", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icone);

                Writer.majStat(Integer.parseInt(s), resultat);
            } else {
                Writer.enregistrer(IgConstante.VALEUR_TROUVEE.getText(), matrice, resFree);
            }
        } else if (e.getSource().equals(IgConstante.BOUTON_ANNULER)) {

            try {
                System.out.println("Derniere ligne : " + IgConstante.DERNIERE_LIGNE);
                RandomAccessFile raf = new RandomAccessFile(FichierConstante.FICHIER_BASE, "rw");
                raf.setLength(raf.length() - IgConstante.DERNIERE_LIGNE);
                IgConstante.DERNIERE_LIGNE = 0;

                raf.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(BoutonValidation.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(BoutonValidation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        /* Dans le cas de reset ou valider, on reset le champs */
        IgConstante.VALEUR_TROUVEE.requestFocus();
        IgConstante.DESSIN.clean();

    }
}
