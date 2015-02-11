/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.ig;

import app_auto.utils.IgConstante;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
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

    public BarreMenu() {
        super();

        /**
         * allocations JMenu
         */
        menu_fichier = new JMenu("Fichier");

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

        /**
         * Constructions
         */
        menu_fichier.add(mfich_nouveau);
        menu_fichier.add(quitter);

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
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();
        if (source.equals(mfich_nouveau)) {
            IgConstante.DESSIN.clean();
        } else if (source.equals(quitter)) {
            System.exit(0);
        }
    }
}
