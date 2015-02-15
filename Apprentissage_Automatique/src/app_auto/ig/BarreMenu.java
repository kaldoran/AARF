/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.ig;

import app_auto.algo.KPlusProcheVoisin;
import app_auto.utils.ChiffreMatriceFreeman;
import app_auto.utils.IgConstante;
import app_auto.utils.Reader;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 *
 * @author kaldoran
 */
public class BarreMenu extends JMenuBar implements ActionListener {

    private JMenu menu_fichier;
    private JMenuItem mfich_nouveau;
    private JMenuItem validate;
    private JMenuItem quitter;

    private JMenu kpp;
    private ButtonGroup distance;
    private JCheckBoxMenuItem manhattan;
    private JCheckBoxMenuItem euclidienne;
    private JCheckBoxMenuItem codeFreeman;
    private JMenu kpp_value;

    private ButtonGroup number;
    private JCheckBoxMenuItem three;
    private JCheckBoxMenuItem five;
    private JCheckBoxMenuItem seven;

    private JMenu divers;
    private JMenuItem test_freeman;
    private JMenuItem test_freeman_ligne;
    private JMenuItem apropos;

    public BarreMenu() {
        super();

        /**
         * allocations JMenu
         */
        menu_fichier = new JMenu("Fichier");
        divers = new JMenu("Divers");

        /**
         * allocations JMenuItem
         */
        mfich_nouveau = new JMenuItem("Nouveau");
        mfich_nouveau.setAccelerator(KeyStroke.getKeyStroke('N',
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask())); // Ctrl + N (Windows & Linux ) - Commande + N (Mac )

        mfich_nouveau.addActionListener(this);

        validate = new JMenuItem("Valider");
        validate.setAccelerator(KeyStroke.getKeyStroke('S',
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask())); // Ctrl + N (Windows & Linux ) - Commande + N (Mac )

        validate.addActionListener(this);

        quitter = new JMenuItem("Quitter");
        quitter.setAccelerator(KeyStroke.getKeyStroke('Q',
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask())); // Ctrl + N (Windows & Linux ) - Commande + N (Mac )

        quitter.addActionListener(this);

        test_freeman = new JMenuItem("Tester Freeman");
        test_freeman.setAccelerator(KeyStroke.getKeyStroke('F',
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask())); // Ctrl + N (Windows & Linux ) - Commande + N (Mac )
        test_freeman.addActionListener(this);
        test_freeman.setToolTipText("Tester le code de freeman donné.");

        test_freeman_ligne = new JMenuItem("Tester Freeman ligne X");
        test_freeman_ligne.setAccelerator(KeyStroke.getKeyStroke('L',
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask())); // Ctrl + N (Windows & Linux ) - Commande + N (Mac )
        test_freeman_ligne.addActionListener(this);
        test_freeman_ligne.setToolTipText("Tester le code de freeman se trouvant à une ligne donnée dand le fichier de base d'apprentissage.");

        apropos = new JMenuItem("A propos");
        apropos.setAccelerator(KeyStroke.getKeyStroke('A',
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask())); // Ctrl + N (Windows & Linux ) - Commande + N (Mac )
        apropos.addActionListener(this);
        apropos.setToolTipText("En savoir plus sur notre projet.");

        /**
         * Constructions
         */
        menu_fichier.add(mfich_nouveau);
        menu_fichier.add(validate);
        menu_fichier.add(quitter);

        divers.add(test_freeman);
        divers.add(test_freeman_ligne);
        divers.add(apropos);

        this.add(menu_fichier);

        kpp = new JMenu("KPP Configuration");
        euclidienne = new JCheckBoxMenuItem("Euclidienne");
        manhattan = new JCheckBoxMenuItem("Manhattan");
        codeFreeman = new JCheckBoxMenuItem("Code Freeman");

        kpp.add(euclidienne);
        kpp.add(manhattan);
        kpp.add(codeFreeman);
        
        euclidienne.addActionListener(this);
        manhattan.addActionListener(this);
        codeFreeman.addActionListener(this);

        distance = new ButtonGroup();
        distance.add(euclidienne);
        distance.add(manhattan);
        distance.add(codeFreeman);

        kpp_value = new JMenu("Kpp Value");
        three = new JCheckBoxMenuItem("3");
        five = new JCheckBoxMenuItem("5");
        seven = new JCheckBoxMenuItem("7");

        kpp_value.add(three);
        kpp_value.add(five);
        kpp_value.add(seven);
        
        three.addActionListener(this);
        five.addActionListener(this);
        seven.addActionListener(this);

        number = new ButtonGroup();
        number.add(three);
        number.add(five);
        number.add(seven);

        manhattan.setSelected(true);
        three.setSelected(true);

        kpp.add(kpp_value);
        this.add(kpp);

        this.add(divers);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if (source.equals(validate)) {
            IgConstante.BOUTON_VALIDATION.doClick();
        }
        else if (source.equals(mfich_nouveau)) {
            IgConstante.DESSIN.clean();
        } else if (source.equals(quitter)) {
            System.exit(0);
        } else if (source.equals(test_freeman)) {
            String morgan = JOptionPane.showInputDialog(null, "Code de freeman", "Tester un code de freeman", JOptionPane.QUESTION_MESSAGE);

            ChiffreMatriceFreeman.testerFreeman(morgan, "X");
        } else if (source.equals(test_freeman_ligne)) {
            Integer ligne = Integer.parseInt(JOptionPane.showInputDialog(null, "Ligne du code de freeman", "Tester un code de freeman dans la base", JOptionPane.QUESTION_MESSAGE));

            Reader lecteur = new Reader();

            ChiffreMatriceFreeman.testerFreeman(lecteur.recupLigne(ligne).getFreeman(), ligne.toString());
        } else if (source.equals(apropos)) {
            BoiteDialogueImage bdi = new BoiteDialogueImage(null, "A propos", true, "Apprentissage Automatique", IgConstante.APROPOS, "/Ressources/jacquenetForever.png");
        } else if (source.equals(euclidienne)) {
            IgConstante.ALGO_NUMBER = KPlusProcheVoisin.EUCLIDIENNE;
        } else if (source.equals(manhattan)) {
            IgConstante.ALGO_NUMBER = KPlusProcheVoisin.MANHATTAN;
        } else if (source.equals(codeFreeman)) {
            IgConstante.ALGO_NUMBER = KPlusProcheVoisin.CODEFREEMAN;
        } else if (source.equals(three)) {
            IgConstante.NUMBER_KPPV = KPlusProcheVoisin._3_VOISINS;
        } else if (source.equals(five)) {
            IgConstante.NUMBER_KPPV = KPlusProcheVoisin._5_VOISINS;
        } else if (source.equals(seven)) {
            IgConstante.NUMBER_KPPV = KPlusProcheVoisin._7_VOISINS;
        }
    }
}
