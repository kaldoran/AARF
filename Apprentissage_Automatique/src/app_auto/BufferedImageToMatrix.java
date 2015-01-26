/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto;

import java.awt.image.BufferedImage;

/**
 *
 * @author kaldoran
 */
public class BufferedImageToMatrix {

    private int[][] matrix;
    private int width;
    private int height;

    public BufferedImageToMatrix(BufferedImage image) {
        width = image.getWidth();
        height = image.getHeight();
        int[][] matrix = new int[width][height];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                matrix[col][row] = (image.getRGB(col, row) == 0 ? 0 : 1);
                // System.out.print(matrix[col][row] + " ");
            }
            // System.out.println("");
        }
        
        System.out.println("Matrix done");
    }

    public int[][] getMatrix() {
        return matrix;
    }

}
