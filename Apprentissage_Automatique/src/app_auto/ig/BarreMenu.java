/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.ig;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 *
 * @author kaldoran
 */
public class BarreMenu extends JMenuBar implements ActionListener{
    
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
        
        mfich_nouveau.addActionListener();
        
        /** Constructions */
        menu_fichier.add(mfich_nouveau);

        this.add(menu_fichier);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == mfich_nouveau){
            
        }
    }
    
    
}
