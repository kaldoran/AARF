package app_auto.ig;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;


/**
 *
 * @author kaldoran
 */
public class PanneauPrincipal extends JPanel {

    private BarreResulat barre_resultat;
    private ZoneDessin zone_dessin;
    
    public PanneauPrincipal() {
        super();
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(350, 400));

        barre_resultat = new BarreResulat();
        this.add(barre_resultat, BorderLayout.NORTH);
        
        zone_dessin = new ZoneDessin();
        this.add(zone_dessin, BorderLayout.CENTER);
    }

}
