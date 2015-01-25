/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.ig;

import java.awt.Event;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 *
 * @author kaldoran
 */
public class BarreMenu extends JMenuBar{
    
    private JMenu menu_fichier;
    
    private JMenuItem mfich_nouveau;


    public BarreMenu() {
        super();
        
        /** allocations JMenu */
        menu_fichier = new JMenu("Fichier");
        
        /** allocations JMenuItem */
        mfich_nouveau = new JMenuItem("Nouveau");
        mfich_nouveau.setAccelerator(KeyStroke.getKeyStroke('N',
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask())); // Ctrl + N (Windows & Linux ) - Commande + N (Mac )

        /** Constructions */
        menu_fichier.add(mfich_nouveau);

        this.add(menu_fichier);
    }
    
    
}
