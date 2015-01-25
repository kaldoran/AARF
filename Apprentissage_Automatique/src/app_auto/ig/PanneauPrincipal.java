package app_auto.ig;

import java.awt.BorderLayout;
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

    private ZoneCodeFreeman code_freeman;
    
    public PanneauPrincipal() {
        super();
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(300, 400));
        
        code_freeman = new ZoneCodeFreeman();
        this.add(code_freeman, BorderLayout.NORTH);
    }

}
