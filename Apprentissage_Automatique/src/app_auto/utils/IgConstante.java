/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.utils;

import app_auto.algo.KPlusProcheVoisin;
import app_auto.ig.BoutonRadio;
import app_auto.ig.Dessin;
import app_auto.ig.TexteCodeFreeman;
import app_auto.ig.TexteResultat;
import app_auto.ig.ZoneResultat;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;
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
    public static JButton BOUTON_VALIDATION;
    public static BoutonRadio BOUTON_RADIO;
    public static int NUMBER_KPPV = KPlusProcheVoisin._3_VOISINS;
    public static int ALGO_NUMBER = KPlusProcheVoisin.MANHATTAN;
    
    // Constantes du titre du label.
    public final static TitledBorder OUT = new TitledBorder("Out");
    public final static TitledBorder IN = new TitledBorder("In");
    
    // Constantes de taille du dessin.
    public final static int HAUTEUR_IMAGE = 200;
    public final static int LARGEUR_IMAGE = 150;
    
    // RGB blanc et noir.
    public final static int BLACK = new Color(0,0,0).getRGB();
    public final static int WHITE = new Color(255,255,255).getRGB();
    
    public final static String APROPOS = "Projet - Mini-François - \n v.1.0 \n\n Réalisé par BKNK\n     Bachir BOUACHERIA\n     Kevin LAOUSSING\n     Nicolas REYNAUD\n     Kevin BASCOL\n\n UJM 2014-2015";
    
    // reference de la base d'apprentissage (beurk!)
    public static ArrayList<ChiffreMatriceFreeman> BASE_APPRENTISSAGE;
    public static int[] EVALUATION;

}
