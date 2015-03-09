    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.utils;

import java.io.File;

/**
 *
 * @author kaldoran
 */
public class FichierConstante {
    public final static String REPERTOIRE_APPRENTISSAGE = System.getProperties().getProperty("user.dir") + File.separator + "Base_Apprentissage" + File.separator;
    public final static String FICHIER_BASE = REPERTOIRE_APPRENTISSAGE + "Base";
    public final static String FICHIER_STATS = REPERTOIRE_APPRENTISSAGE + "Stats";
    public final static String PREFIX_ARFF = REPERTOIRE_APPRENTISSAGE + "Base_RdN_";
    public final static String ARFF = ".arff";
}