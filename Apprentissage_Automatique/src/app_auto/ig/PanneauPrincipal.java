package app_auto.ig;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kevin
 */
public class PanneauPrincipal extends JPanel {

    private BarreResulat barre_resultat;
    public PanneauPrincipal() {
        super();
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(300, 400));

        barre_resultat = new BarreResulat();
        this.add(barre_resultat, BorderLayout.NORTH);
    }

}
