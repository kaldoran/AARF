package app_auto.algo;

import app_auto.utils.AlgosConstantes;
import app_auto.utils.ChiffreMatriceFreeman;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class KPlusProcheVoisin {
    
    public static final int _3_VOISINS = 3;
    public static final int _5_VOISINS = 5;
    public static final int _7_VOISINS = 7;

    public KPlusProcheVoisin() {

    }

    /**
     * Cette méthode determine la classe de x en utilisant les matrices
     *
     * @param matrice_x
     * @param s
     * @param ALGO_DISTANCE
     * @return
     */
    public int kppv(int[][] matrice_x, ArrayList<ChiffreMatriceFreeman> s, int nombre_voisin, int ALGO_DISTANCE) {
        int classe_y = -1;
        Iterator<ChiffreMatriceFreeman> it_s = null;
        int tab_kppv[] = {0,0,0,0,0,0,0,0,0,0};
        
        //Si matrice est vide
        if (matrice_x.length == 0) {
            System.out.println("ERREUR : Matrice vide !");
            return -1;
        }

        //Si la base de connnaissance est vide
        if (s == null) {
            System.out.println("ERREUR : Probleme à la lecture de la base de connaissance");
            return -1;
        }
        
        if (s.isEmpty()) {
            System.out.println("ERREUR : Base de connaissance vide");
            return -1;
        }

        it_s = s.iterator();
        //Calcul des distances par rapport à x pour chaque point de la base
        while (it_s.hasNext()) {
            ChiffreMatriceFreeman cmf = it_s.next();
            
            switch (ALGO_DISTANCE) {

                case AlgosConstantes.MANHATTAN:
                    cmf.setDistance(manhattanDistance(matrice_x, cmf.getMatrice()));
                    break;

                case AlgosConstantes.EUCLIDIENNE:
                    cmf.setDistance(euclideanDistance(matrice_x, cmf.getMatrice()));
                    break;

                case AlgosConstantes.CHEBYSHEV:
                    cmf.setDistance(chebyshevDistance(matrice_x, cmf.getMatrice()));
                    break;

                default:
                    System.out.println("ERREUR : Algorithme de calcule de distance non existant");
                    return -1;
            }
        }

        //Trie par ordre croissant selon la distance (voir methode compareTo de ChiffreMatriceFreeman)
        Collections.sort(s);
        
        if(nombre_voisin != _3_VOISINS && nombre_voisin != _5_VOISINS && nombre_voisin != _7_VOISINS) {
            // par défaut on choisit les 3-ppv
            nombre_voisin = _3_VOISINS;
        }
        
        for( int i = 0; i < nombre_voisin; i++) {
            tab_kppv[Integer.valueOf(s.get(i).getChiffre())]++;
            System.out.println("voisin : " + s.get(i).getChiffre());
        }
        
        int max = tab_kppv[0];
        classe_y = 0;
        for(int i = 1 ; i < tab_kppv.length; i++) {
            if(max < tab_kppv[i]) {
                classe_y = i;
                max = tab_kppv[i];
            }
        }
        System.out.println("classe_ y : " + classe_y);
        return classe_y;
    }

    /**
     * Manhattan Distance
     *
     * @param matrice_x
     * @param matrice_y
     * @return Manhattan distance between matrix x and matrix y
     */
    public double manhattanDistance(int[][] matrix_x, int[][] matrix_y) {
        //hello
        double s = 0;
        for (int i = 0; i < matrix_x.length; i++) {
            for (int j = 0; j < matrix_x[0].length; j++) {
                if (matrix_x[i][j] != matrix_y[i][j]) {
                    s = s + Math.abs(matrix_x[i][j] - matrix_y[i][j]);
                }
            }
        }
        return s;
    }

    /**
     * Euclidean Distance
     *
     * @param matrix_x
     * @param matrix_y
     * @return Euclidean distance between matrix x and matrix y
     */
    public double euclideanDistance(int[][] matrix_x, int[][] matrix_y) {
        double s = 0;
        for (int i = 0; i < matrix_x.length; i++) {
            for (int j = 0; j < matrix_x[0].length; j++) {
                if (matrix_x[i][j] != matrix_y[i][j]) {
                    s = s + Math.pow(matrix_x[i][j] - matrix_y[i][j], 2);
                }
            }
        }

        return Math.sqrt(s);
    }

    /**
     * Chebyshev Distance
     *
     * @param matrix_x
     * @param matrix_y
     * @return Chebyshev Distance between matrix x and matrix y
     */
    public double chebyshevDistance(int[][] matrix_x, int[][] matrix_y) {
        double s = 0;
        double max = 0;
        for (int i = 0; i < matrix_x.length; i++) {
            for (int j = 0; j < matrix_x[0].length; j++) {
                if (matrix_x[i][j] != matrix_y[i][j]) {
                    if (Math.abs(matrix_x[i][j] - matrix_y[i][j]) > max) {
                        max = Math.abs(matrix_x[i][j] - matrix_y[i][j]);
                        s = max;
                    }
                }
            }
        }
        return s;
    }

    /**
     * levenshteinDistance ou distance d'édition
     *
     * @param firstCodeFreeman
     * @param secondCodeFreeman
     * @return
     */
    public int levenshteinDistance(String firstCodeFreeman, String secondCodeFreeman) {

        //longueur du premier et deuxième code de freeman 
        int firstLength = firstCodeFreeman.length() + 1;
        int secondLength = secondCodeFreeman.length() + 1;

        // tableau de distance
        int[] cost = new int[firstLength];
        int[] newcost = new int[firstLength];

        // cout initial 
        for (int i = 0; i < firstLength; i++) {
            cost[i] = i;
        }

        for (int j = 1; j < secondLength; j++) {

            // cout initial du deuxieme code de freeman
            newcost[0] = j - 1;

            // changement de cout pour chaque lettre dans le prmeier code de freeman
            for (int i = 1; i < firstLength; i++) {

                // verification des deux lettre dans les deux code de freeman
                int match = (firstCodeFreeman.charAt(i - 1) == secondCodeFreeman.charAt(j - 1)) ? 0 : 1;

                // changement de cout pour chaque transformation 
                int costReplace = cost[i - 1] + match;
                int costInsert = cost[i] + 1;
                int costDelete = newcost[i - 1] + 1;

                // prendre le coup minimal 
                newcost[i] = min(costInsert, costDelete, costReplace);
            }

            // changer les caleurs des tableau cost/newcost 
            int[] swap = cost;
            cost = newcost;
            newcost = swap;
        }

        //la distance c'est le cout pour trnasformer toutes les lettre dans les deux code de freeman
        return cost[firstLength - 1];
    }

    /**
     * tourve la valeur minimal entre trois valeurs
     *
     * @param costInsert
     * @param costDelete
     * @param costReplace
     * @return minimum value
     */
    public int min(int costInsert, int costDelete, int costReplace) {
        if (costInsert <= costDelete && costInsert <= costReplace) {
            return costInsert;
        } else if (costDelete <= costInsert && costDelete <= costReplace) {
            return costDelete;
        } else {
            return costReplace;
        }
    }

    public int kppv(String FreemanIn, ArrayList<ChiffreMatriceFreeman> liste, int nombre_voisin) {
        int[] mesPlusProcheVoisins = new int[10];
        
        int classe_y;

        for (ChiffreMatriceFreeman element : liste) {
            int distanse = levenshteinDistance(FreemanIn, element.getFreeman());
            element.setDistance(distanse);
        }
        Collections.sort(liste);
        
        for (int i = 0; i < 10; i++) {
            mesPlusProcheVoisins[i] = Integer.valueOf(liste.get(i).getChiffre());
        }
        
        if(nombre_voisin != _3_VOISINS && nombre_voisin != _5_VOISINS && nombre_voisin != _7_VOISINS) {
            // par défaut on choisit les 3-ppv
            nombre_voisin = _3_VOISINS;
        }
        classe_y = maClasse(mesPlusProcheVoisins,nombre_voisin);
        return classe_y;
    }
    
    public int maClasse(int[] Tableau, int k){
        int redandance;
        int maxRedandance = 0;
        int classeY = -1;
        for (int i = 0; i < k; i++) {
            redandance = 0;
            for (int j = i; j < k; j++) {
                if(Tableau[i] == Tableau[j]){
                    redandance++;
                }
            }
            if(redandance > maxRedandance){
                classeY = Tableau[i];
                maxRedandance = redandance;
            }
        }
        return classeY;
    }
}
