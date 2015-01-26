/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.ig;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import javax.swing.JPanel;

/**
 *
 * @author kaldoran
 */
public class Dessin extends JPanel implements MouseListener, MouseMotionListener {

    private int x1 = -1, y1 = -1, cx = -1, cy = -1;

    private BufferedImage image;
    private Graphics2D g2;

    public Dessin() {
        super();
        this.addMouseListener(this);
        this.addMouseMotionListener(this);

        clean();
    }

    public void clean() {
        x1 = y1 = cx = cy = -1;

        image = newImage();
        repaint();
    }

    public BufferedImage newImage() {
        image = new BufferedImage(333, 250,
                BufferedImage.TYPE_INT_ARGB);

        g2 = image.createGraphics();
        g2.setBackground(Color.WHITE); // I am setting the background colour here
        g2.setColor(Color.BLACK);
        g2.setFont(new Font("Serif", Font.PLAIN, 30));
        g2.setStroke(new BasicStroke(8));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        return image;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (x1 != -1 && y1 != -1 && cx != -1 && cy != -1) {
            g2.drawLine(x1, y1, cx, cy);
        }

        g.drawImage(image, 0, 0, g2.getBackground(), this);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        cx = x1;
        cy = y1;
        x1 = e.getX();
        y1 = e.getY();

        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        x1 = e.getX();
        y1 = e.getY();
        cx = x1;
        cy = y1;
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        cx = e.getX();
        cy = e.getY();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        x1 = e.getX();
        y1 = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
