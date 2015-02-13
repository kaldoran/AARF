package app_auto.ig;

import app_auto.utils.IgConstante;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author kaldoran
 */
public class PanneauPrincipal extends JPanel {

    private BarreResulat barre_resultat;
    private ZoneDessin zone_dessin;
    private ZoneValidation zone_validation;

    public PanneauPrincipal() {
        super();
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(315, 285));

        barre_resultat = new BarreResulat();
        this.add(barre_resultat, BorderLayout.NORTH);

        zone_dessin = new ZoneDessin();
        this.add(zone_dessin, BorderLayout.CENTER);

        zone_validation = new ZoneValidation();
        this.add(zone_validation, BorderLayout.EAST);

    }

}
