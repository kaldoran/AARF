/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto;

import app_auto.ig.IgConstante;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

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
        int[][] matrix = new int[height][width];

        for (int row = 0; row < height - 1; row++) {
            for (int col = 0; col < width - 1; col++) {
                matrix[row][col] = (image.getRGB(col, row) == 0 ? 0 : 1);
                // System.out.print(matrix[row][col] + " ");
            }
            // System.out.println("");
        }
        
        System.out.println("Matrix done");
    }

    public int[][] getMatrix() {
        return matrix;
    }

}
