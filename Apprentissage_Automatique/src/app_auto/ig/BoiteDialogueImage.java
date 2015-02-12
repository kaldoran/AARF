/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.ig;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Kevin
 */
public class BoiteDialogueImage extends JDialog {
    private JLabel icon;
    private JTextArea texte;

    public BoiteDialogueImage(Frame owner, String title, boolean modal, String texte, String image) {
        super(owner, title, modal);
        
        this.setSize(300, 150);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.initComponent(texte, image);

        this.setVisible(true);
    }
    
    private void initComponent(String txt, String image) {
        //Icône
        icon = new JLabel(new ImageIcon(this.getClass().getResource(image)));
        JPanel panIcone = new JPanel();
        panIcone.setBackground(Color.WHITE);
        panIcone.setLayout(new BorderLayout());
        panIcone.add(icon);

        //Le nom
        JPanel panTexte = new JPanel();
        panTexte.setBackground(Color.WHITE);
        panTexte.setPreferredSize(new Dimension(200, 100));
        panTexte.setBorder(BorderFactory.createEmptyBorder(20, 10, 0, 0));
        texte = new JTextArea(txt);
        panTexte.add(texte, BorderLayout.CENTER);
        
        this.getContentPane().setBackground(Color.WHITE);
        this.getContentPane().add(panIcone, BorderLayout.WEST);
        this.getContentPane().add(panTexte, BorderLayout.EAST);

    }

}
