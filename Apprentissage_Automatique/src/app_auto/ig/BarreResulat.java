/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.ig;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author kaldoran
 */
public class BarreResulat extends JPanel {
    
    ZoneCodeFreeman code_freeman;
    private ZoneResultat resultat_trouvee;
    
    public BarreResulat() {
        super();
        this.setPreferredSize(new Dimension(300, 60));

        code_freeman = new ZoneCodeFreeman();
        this.add(code_freeman, BorderLayout.WEST);
        
        resultat_trouvee = new ZoneResultat();
        this.add(resultat_trouvee, BorderLayout.EAST);
    }
    
}
