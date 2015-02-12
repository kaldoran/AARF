/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.ig;

import app_auto.utils.IgConstante;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author kaldoran
 */
public class ZoneResultat extends JPanel {

    public ZoneResultat() {
        super();
        
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(50, 50));
        
        this.setBorder(IgConstante.OUT);

        IgConstante.VALEUR_TROUVEE = new TexteResultat();
        this.add(IgConstante.VALEUR_TROUVEE);
    }

}
