/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.algo;

public class KPlusProcheVoisin {

    /**
     * Manhattan Distance
     *
     * @param matrice_x
     * @param matrice_y
     * @return Manhattan distance between matrix x and matrix y
     */
    public double manhattanDistance(int[][] matrix_x, int[][] matrix_y) {
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
                    if(Math.abs(matrix_x[i][j] - matrix_y[i][j]) > max){
                        max = Math.abs(matrix_x[i][j] - matrix_y[i][j]);
                        s = max;
                    }  
                }
            }
        }
        return s;
    }
}
