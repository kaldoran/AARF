/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.utils;


/**
 *
 * @author Kevin
 */
public class AlgosConstantes {
    public final static String LABEL_MANH = "KM [Manh]";
    public final static String LABEL_EUCL = "KM [Eucl]";
    public final static String LABEL_CHEB = "KM [Cheb]";
    public final static String LABEL_FREE = "K Freeman";
    public final static String LABEL_RDN = "R Neurone";
    
    public final static int MANHATTAN = 0;
    public final static int EUCLIDIENNE = 1;
    public final static int CHEBYSHEV = 2;
    public final static int CODEFREEMAN = 3;
    public final static int NEURONES = 4;
    
    public final static int LARG_MAT_CONV = 5;
    public final static int HAUT_MAT_CONV = 5;
    
    public final static String RDN_OPTIONS = "-L 0.02 -M 0.2 -N 500 -V 20 -S 0 -E 20 -H 300,200";
       
    
    public final static String labelParNum(int num){
        switch(num){
            case MANHATTAN:
                return LABEL_MANH;
            case EUCLIDIENNE:
                return LABEL_EUCL;
            case CHEBYSHEV:
                return LABEL_CHEB;
            case CODEFREEMAN:
                return LABEL_FREE;
            case NEURONES:
                return LABEL_RDN;
            default:
                return "Error";
        }
    }

    public final static String[] labels() {
        String[] labels = {
            LABEL_MANH,
            LABEL_EUCL,
            LABEL_CHEB,
            LABEL_FREE,
            LABEL_RDN
        };
        
        return labels;
    }
}
