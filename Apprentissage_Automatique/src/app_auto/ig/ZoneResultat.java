/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.ig;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author kaldoran
 */
public class ZoneResultat extends JPanel {

    private TexteResultat valeur_trouvee;
    private TitledBorder bordure;

    public ZoneResultat() {
        super();
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(50, 50));
        valeur_trouvee = new TexteResultatTrouvee();

        bordure = new TitledBorder("Out");

        this.setBorder(bordure);
        this.add(valeur_trouvee);
    }

}
