/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.ig;

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
    private JMenuItem quitter;


    private JMenu kpp;
    private ButtonGroup distance;
    private JCheckBoxMenuItem manhattan;
    private JCheckBoxMenuItem euclidienne;
    private JMenu kpp_value;

    private ButtonGroup number;
    private JCheckBoxMenuItem three;
    private JCheckBoxMenuItem five;
    private JCheckBoxMenuItem seven;
    
    private JMenu menu_tests;
    private JMenuItem test_freeman;
    private JMenuItem test_freeman_ligne;

    public BarreMenu() {
        super();

        /**
         * allocations JMenu
         */
        menu_fichier = new JMenu("Fichier");
        menu_tests = new JMenu("Test");

        /**
         * allocations JMenuItem
         */
        mfich_nouveau = new JMenuItem("Nouveau");
        mfich_nouveau.setAccelerator(KeyStroke.getKeyStroke('N',
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask())); // Ctrl + N (Windows & Linux ) - Commande + N (Mac )

        mfich_nouveau.addActionListener(this);

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
        
        
        /**
         * Constructions
         */
        menu_fichier.add(mfich_nouveau);
        menu_fichier.add(quitter);
        
        menu_tests.add(test_freeman);
        menu_tests.add(test_freeman_ligne);
        
        this.add(menu_fichier);

        kpp = new JMenu("KPP Configuration");
        euclidienne = new JCheckBoxMenuItem("Euclidienne");
        manhattan = new JCheckBoxMenuItem("manhattan");

        kpp.add(euclidienne);
        kpp.add(manhattan);

        distance = new ButtonGroup();
        distance.add(euclidienne);
        distance.add(manhattan);

        kpp_value = new JMenu("Kpp Value");
        three = new JCheckBoxMenuItem("3");
        five = new JCheckBoxMenuItem("5");
        seven = new JCheckBoxMenuItem("7");

        kpp_value.add(three);
        kpp_value.add(five);
        kpp_value.add(seven);

        number = new ButtonGroup();
        number.add(three);
        number.add(five);
        number.add(seven);

        manhattan.setSelected(true);
        three.setSelected(true);

        kpp.add(kpp_value);
        this.add(kpp);

        this.add(menu_tests);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();
        if (source.equals(mfich_nouveau)) {
            IgConstante.DESSIN.clean();
        } else if (source.equals(quitter)) {
            System.exit(0);
        } else if (source.equals(test_freeman)){
            String morgan = JOptionPane.showInputDialog(null, "Code de freeman", "Tester un code de freeman", JOptionPane.QUESTION_MESSAGE);
            
            ChiffreMatriceFreeman.testerFreeman(morgan, "X");
        } else if (source.equals(test_freeman_ligne)){
            Integer ligne = Integer.parseInt(JOptionPane.showInputDialog(null, "Ligne du code de freeman", "Tester un code de freeman dans la base", JOptionPane.QUESTION_MESSAGE));
            
            Reader lecteur = new Reader();
            
            ChiffreMatriceFreeman.testerFreeman(lecteur.recupLigne(ligne).getFreeman(), ligne.toString());
        }
    }
}
