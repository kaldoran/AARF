/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.ig;

import app_auto.utils.IgConstante;
import app_auto.BufferedImageToMatrix;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author kaldoran
 */
public class BoutonValidation extends JPanel implements ActionListener {

    private JButton validation;
    private JButton reset;

    public BoutonValidation() {
        super();
        this.setPreferredSize(new Dimension(50, 50));

        validation = new JButton("Valider");
        validation.addActionListener(this);
        this.add(validation, BorderLayout.WEST);

        reset = new JButton("Reset");
        reset.addActionListener(this);
        this.add(reset, BorderLayout.EAST);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(reset)) {
            IgConstante.DESSIN.clean();
        }

        if (e.getSource().equals(validation)) {
            BufferedImageToMatrix bim = new BufferedImageToMatrix(IgConstante.DESSIN.getImage());
        }

    }

}
