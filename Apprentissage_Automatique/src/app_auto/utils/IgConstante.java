/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.utils;

import app_auto.ig.Dessin;
import app_auto.ig.TexteCodeFreeman;
import app_auto.ig.TexteResultat;
import app_auto.ig.ZoneResultat;
import javax.swing.border.TitledBorder;

/**
 *
 * @author kaldoran
 */
public class IgConstante {

    public static Dessin DESSIN;  // Zone de dessin. 
    public static TexteResultat VALEUR_TROUVEE;  // Champ texte du chiffre trouvé (ou à chercher).
    public static ZoneResultat RESULTAT_TROUVEE;  // Label du champ texte du chiffre trouvé (ou à chercher).
    public static TexteCodeFreeman CODE_FREEMAN;  // Champ texte du code de freeman.

    // Constantes du titre du label.
    public final static TitledBorder OUT = new TitledBorder("Out");
    public final static TitledBorder IN = new TitledBorder("In");
    
    // Constantes de taille du dessin.
    public final static int HAUTEUR_IMAGE = 200;
    public final static int LARGEUR_IMAGE = 150;

}
