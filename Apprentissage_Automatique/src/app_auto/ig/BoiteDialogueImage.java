/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.ig;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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

    public BoiteDialogueImage(Frame owner, String title, boolean modal, String titre, String texte, String image) {
        super(owner, title, modal);
        
        this.setSize(313, 200);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.initComponent(titre, texte, image);

        this.setVisible(true);
    }
    
    private void initComponent(String titre, String txt, String image) {
        //Icône
        icon = new JLabel(new ImageIcon(this.getClass().getResource(image)));
        JPanel panIcone = new JPanel();
        panIcone.setSize(100,150);
        panIcone.setBackground(Color.WHITE);
        panIcone.setLayout(new BorderLayout());
        panIcone.add(icon, BorderLayout.CENTER);

        //Le nom
        JPanel panTexte = new JPanel();
        panTexte.setBackground(Color.WHITE);
        panTexte.setBorder(BorderFactory.createTitledBorder(titre));
        panTexte.setPreferredSize(new Dimension(200, 150));
        texte = new JTextArea(txt);
        texte.setSize(200, 150);
        texte.setFont(new Font("Arial", Font.PLAIN, 11));
        panTexte.add(texte, BorderLayout.WEST);
        
        this.getContentPane().setBackground(Color.WHITE);
        this.getContentPane().add(panIcone, BorderLayout.WEST);
        this.getContentPane().add(panTexte, BorderLayout.EAST);

    }

}
