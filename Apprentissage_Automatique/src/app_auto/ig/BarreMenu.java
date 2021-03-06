/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_auto.ig;

import app_auto.algo.KPlusProcheVoisin;
import app_auto.algo.ReseauNeurones;
import app_auto.graph.TraceurGraphique;
import app_auto.ig.graph.FenetreGraphe;
import app_auto.utils.AlgosConstantes;
import app_auto.utils.ChiffreMatriceFreeman;
import app_auto.utils.FichierConstante;
import app_auto.utils.IgConstante;
import app_auto.utils.Reader;
import app_auto.utils.Stats;
import app_auto.utils.Writer;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 *
 * @author kaldoran
 */
public class BarreMenu extends JMenuBar implements ActionListener {

    private JMenu menu_fichier;
    private JMenuItem mfich_nouveau;
    private JMenuItem validate;
    private JMenuItem recharger;
    private JMenuItem baseVersArff;
    private JMenuItem quitter;

    private JMenu algo;
    private ButtonGroup distance;
    private JCheckBoxMenuItem manhattan;
    private JCheckBoxMenuItem euclidienne;
    private JCheckBoxMenuItem codeFreeman;
    private JCheckBoxMenuItem neurones;
    private JMenu kpp_value;
    private JMenuItem training;

    private ButtonGroup number;
    private JCheckBoxMenuItem three;
    private JCheckBoxMenuItem five;
    private JCheckBoxMenuItem seven;

    private JMenu divers;
    private JMenuItem test_freeman;
    private JMenuItem test_freeman_ligne;
    private JMenuItem afficher_graphes;
    private JMenuItem apropos;

    private JMenu tests;
    private JMenuItem testEns;
    private JMenuItem activAjoutTest;
    private JMenuItem desAjoutTest;

    private FenetreGraphe fenetre_graphe;

    public BarreMenu() {
        super();

        /**
         * allocations JMenu
         */
        menu_fichier = new JMenu("Fichier");
        divers = new JMenu("Divers");
        tests = new JMenu("Tester");

        /**
         * allocations JMenuItem
         */
        mfich_nouveau = new JMenuItem("Nouveau");
        mfich_nouveau.setAccelerator(KeyStroke.getKeyStroke('N',
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask())); // Ctrl + N (Windows & Linux ) - Commande + N (Mac )
        mfich_nouveau.addActionListener(this);

        validate = new JMenuItem("Valider");
        validate.setAccelerator(KeyStroke.getKeyStroke('S',
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask())); // Ctrl + N (Windows & Linux ) - Commande + N (Mac )
        validate.addActionListener(this);

        recharger = new JMenuItem("Recharger Base");
        recharger.setAccelerator(KeyStroke.getKeyStroke('R',
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask())); // Ctrl + N (Windows & Linux ) - Commande + N (Mac )
        recharger.setToolTipText("Rafraichir la base d'apprentissage.");
        recharger.addActionListener(this);

        baseVersArff = new JMenuItem("Base vers arff");
        baseVersArff.setAccelerator(KeyStroke.getKeyStroke('T',
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask())); // Ctrl + N (Windows & Linux ) - Commande + N (Mac )
        baseVersArff.setToolTipText("Crée un fichier .arff correspondant à la base de connaissance.");
        baseVersArff.addActionListener(this);

        quitter = new JMenuItem("Quitter");
        quitter.setAccelerator(KeyStroke.getKeyStroke('Q',
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask())); // Ctrl + N (Windows & Linux ) - Commande + N (Mac )
        quitter.addActionListener(this);

        test_freeman = new JMenuItem("Tester Freeman");
        test_freeman.setAccelerator(KeyStroke.getKeyStroke('F',
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask())); // Ctrl + N (Windows & Linux ) - Commande + N (Mac )
        test_freeman.addActionListener(this);
        test_freeman.setToolTipText("Tester le code de freeman donné.");

        test_freeman_ligne = new JMenuItem("Tester Freeman ligne X");
        test_freeman_ligne.setAccelerator(KeyStroke.getKeyStroke('L',
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask())); // Ctrl + N (Windows & Linux ) - Commande + N (Mac )
        test_freeman_ligne.addActionListener(this);
        test_freeman_ligne.setToolTipText("Tester le code de freeman se trouvant à une ligne donnée dand le fichier de base d'apprentissage.");

        afficher_graphes = new JMenuItem("Afficher graphiques");
        afficher_graphes.setAccelerator(KeyStroke.getKeyStroke('G',
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        afficher_graphes.addActionListener(this);
        afficher_graphes.setToolTipText("Afficher les représentations graphique de l'apprentissage de Mini-François");

        apropos = new JMenuItem("A propos");
        apropos.setAccelerator(KeyStroke.getKeyStroke('A',
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask())); // Ctrl + N (Windows & Linux ) - Commande + N (Mac )
        apropos.addActionListener(this);
        apropos.setToolTipText("En savoir plus sur notre projet.");

        testEns = new JMenuItem("Tester");
        testEns.addActionListener(this);
        testEns.setToolTipText("Tester les exemples de la base de test.");
        
        activAjoutTest = new JMenuItem("Activer ajout");
        activAjoutTest.addActionListener(this);
        activAjoutTest.setToolTipText("Activer l'ajout des nouveaux exemple dans la base de test.");
        
        desAjoutTest = new JMenuItem("Desactiver ajout");
        desAjoutTest.addActionListener(this);
        desAjoutTest.setToolTipText("Desactiver l'ajout des nouveaux exemple dans la base de test.");
        desAjoutTest.setVisible(false);

        /**
         * Constructions
         */
        menu_fichier.add(mfich_nouveau);
        menu_fichier.add(validate);
        menu_fichier.add(recharger);
        menu_fichier.add(baseVersArff);
        menu_fichier.add(quitter);

        divers.add(test_freeman);
        divers.add(test_freeman_ligne);
        divers.add(afficher_graphes);
        divers.add(apropos);

        tests.add(testEns);
        tests.add(activAjoutTest);
        tests.add(desAjoutTest);
        
        this.add(menu_fichier);

        algo = new JMenu("Algo Configuration");
        euclidienne = new JCheckBoxMenuItem("Euclidienne");
        manhattan = new JCheckBoxMenuItem("Manhattan");
        codeFreeman = new JCheckBoxMenuItem("Code Freeman");
        neurones = new JCheckBoxMenuItem("Reseau de Neurones");
        training = new JMenuItem("Trainning");
        training.setVisible(false);

        algo.add(euclidienne);
        algo.add(manhattan);
        algo.add(codeFreeman);
        algo.add(neurones);
        algo.add(training);

        euclidienne.addActionListener(this);
        manhattan.addActionListener(this);
        codeFreeman.addActionListener(this);
        neurones.addActionListener(this);
        training.addActionListener(this);

        distance = new ButtonGroup();
        distance.add(euclidienne);
        distance.add(manhattan);
        distance.add(codeFreeman);
        distance.add(neurones);

        kpp_value = new JMenu("Kpp Value");
        three = new JCheckBoxMenuItem("3");
        five = new JCheckBoxMenuItem("5");
        seven = new JCheckBoxMenuItem("7");

        kpp_value.add(three);
        kpp_value.add(five);
        kpp_value.add(seven);

        three.addActionListener(this);
        five.addActionListener(this);
        seven.addActionListener(this);

        number = new ButtonGroup();
        number.add(three);
        number.add(five);
        number.add(seven);

        manhattan.setSelected(true);
        three.setSelected(true);

        algo.add(kpp_value);
        this.add(algo);

        this.add(divers);
        this.add(tests);

        fenetre_graphe = new FenetreGraphe();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if (source.equals(validate)) {
            IgConstante.BOUTON_VALIDATION.doClick();
        } else if (source.equals(mfich_nouveau)) {
            IgConstante.DESSIN.clean();
        } else if (source.equals(recharger)) {
            IgConstante.BASE_APPRENTISSAGE = new Reader().recupTotal();
        } else if (source.equals(baseVersArff)) {
            Reader lect = new Reader();

            Writer.tradBaseEnArff(lect.recupTotal(), AlgosConstantes.LARG_MAT_CONV, AlgosConstantes.HAUT_MAT_CONV, false);
        } else if (source.equals(quitter)) {
            System.exit(0);
        } else if (source.equals(test_freeman)) {
            String morgan = JOptionPane.showInputDialog(null, "Code de freeman", "Tester un code de freeman", JOptionPane.QUESTION_MESSAGE);

            ChiffreMatriceFreeman.testerFreeman(morgan, "X");
        } else if (source.equals(test_freeman_ligne)) {
            Integer ligne = Integer.parseInt(JOptionPane.showInputDialog(null, "Ligne du code de freeman", "Tester un code de freeman dans la base", JOptionPane.QUESTION_MESSAGE));

            Reader lecteur = new Reader();

            ChiffreMatriceFreeman.testerFreeman(lecteur.recupLigne(ligne).getFreeman(), ligne.toString());
        } else if (source.equals(apropos)) {
            BoiteDialogueImage bdi = new BoiteDialogueImage(null, "A propos", true, "Apprentissage Automatique", IgConstante.APROPOS, "/Ressources/jacquenetForever.png");
        } else if (source.equals(euclidienne)) {
            kpp_value.setVisible(true);
            training.setVisible(false);
            IgConstante.ALGO_NUMBER = AlgosConstantes.EUCLIDIENNE;
        } else if (source.equals(manhattan)) {
            kpp_value.setVisible(true);
            training.setVisible(false);
            IgConstante.ALGO_NUMBER = AlgosConstantes.MANHATTAN;
        } else if (source.equals(codeFreeman)) {
            kpp_value.setVisible(true);
            training.setVisible(false);
            IgConstante.ALGO_NUMBER = AlgosConstantes.CODEFREEMAN;
        } else if (source.equals(neurones)) {
            kpp_value.setVisible(false);
            training.setVisible(true);
            IgConstante.ALGO_NUMBER = AlgosConstantes.NEURONES;
        } else if (source.equals(training)) {
            ReseauNeurones rdn = new ReseauNeurones();
            rdn.training();
        } else if (source.equals(three)) {
            IgConstante.NUMBER_KPPV = KPlusProcheVoisin._3_VOISINS;
        } else if (source.equals(five)) {
            IgConstante.NUMBER_KPPV = KPlusProcheVoisin._5_VOISINS;
        } else if (source.equals(seven)) {
            IgConstante.NUMBER_KPPV = KPlusProcheVoisin._7_VOISINS;
        } else if (source.equals(afficher_graphes)) {
            IgConstante.BASE_APPRENTISSAGE = new Reader().recupTotal();
            fenetre_graphe.getPanneauGraphes().setChartRepresentationDonneeApprentissage(
                    TraceurGraphique.creerRepresentationDonneeApprentissage(IgConstante.BASE_APPRENTISSAGE));
            Stats stats = Reader.recupStats();
            fenetre_graphe.getPanneauGraphes().setChartEvaluationChiffre(
                    TraceurGraphique.creerRepresentationEvalChiffres(stats));
            fenetre_graphe.getPanneauGraphes().setChartEvaluationAlgos(
                    TraceurGraphique.creerRepresentationEvalAlgos(stats));
            fenetre_graphe.getPanneauGraphes().setChartStatsGenerales(
                    TraceurGraphique.creerRepresentationStatsGenerales(stats));

            fenetre_graphe.setVisible(true);
        } else if (source.equals(testEns)) {
            Reader lect = new Reader();
            ArrayList<ChiffreMatriceFreeman> baseTest = lect.recupTotal(FichierConstante.FICHIER_TEST);
            
            ChiffreMatriceFreeman cmf;
            KPlusProcheVoisin kppv = new KPlusProcheVoisin();
            
            int l = baseTest.size();
            int i, j;
            
            String s;
            
            int[] voisins = new int[3];
            voisins[0] = KPlusProcheVoisin._3_VOISINS;
            voisins[1] = KPlusProcheVoisin._5_VOISINS;
            voisins[2] = KPlusProcheVoisin._7_VOISINS;
            
            for(j = 0; j < l; ++j){
                cmf = baseTest.get(j);
                
                IgConstante.ALGO_NUMBER = AlgosConstantes.CODEFREEMAN;
                for(i = 0; i < 3; ++i){
                    IgConstante.NUMBER_KPPV = voisins[i];
                    
                    s = String.valueOf(kppv.kppv(cmf.getFreeman(), IgConstante.BASE_APPRENTISSAGE, IgConstante.NUMBER_KPPV));
                    
                    if (s.equals(cmf.getChiffre())) {
                        Writer.majStat(Integer.parseInt(s), 0);
                    } else {
                        Writer.majStat(Integer.parseInt(s), 1);
                    }
                }
                    
                IgConstante.ALGO_NUMBER = AlgosConstantes.MANHATTAN;
                for(i = 0; i < 3; ++i){
                    IgConstante.NUMBER_KPPV = voisins[i];
                    
                    s = String.valueOf(kppv.kppv(cmf.getMatrice(), IgConstante.BASE_APPRENTISSAGE, IgConstante.NUMBER_KPPV, IgConstante.ALGO_NUMBER));
                    
                    if (s.equals(cmf.getChiffre())) {
                        Writer.majStat(Integer.parseInt(s), 0);
                    } else {
                        Writer.majStat(Integer.parseInt(s), 1);
                    }
                }
                
                IgConstante.ALGO_NUMBER = AlgosConstantes.EUCLIDIENNE;
                for(i = 0; i < 3; ++i){
                    IgConstante.NUMBER_KPPV = voisins[i];
                    
                    s = String.valueOf(kppv.kppv(cmf.getMatrice(), IgConstante.BASE_APPRENTISSAGE, IgConstante.NUMBER_KPPV, IgConstante.ALGO_NUMBER));
                    
                    if (s.equals(cmf.getChiffre())) {
                        Writer.majStat(Integer.parseInt(s), 0);
                    } else {
                        Writer.majStat(Integer.parseInt(s), 1);
                    }
                }
                
                IgConstante.ALGO_NUMBER = AlgosConstantes.CHEBYSHEV;
                for(i = 0; i < 3; ++i){
                    IgConstante.NUMBER_KPPV = voisins[i];
                    
                    s = String.valueOf(kppv.kppv(cmf.getMatrice(), IgConstante.BASE_APPRENTISSAGE, IgConstante.NUMBER_KPPV, IgConstante.ALGO_NUMBER));
                    
                    if (s.equals(cmf.getChiffre())) {
                        Writer.majStat(Integer.parseInt(s), 0);
                    } else {
                        Writer.majStat(Integer.parseInt(s), 1);
                    }
                }
      
                IgConstante.ALGO_NUMBER = AlgosConstantes.NEURONES;
                ReseauNeurones rdn = new ReseauNeurones();

                Writer.ecrireEntreeArff(ChiffreMatriceFreeman.redFreeman(cmf.getFreeman(), AlgosConstantes.NB_PART), AlgosConstantes.NB_PART, "?");
                s = Integer.toString(rdn.tester());

                if (s.equals(cmf.getChiffre())) {
                    Writer.majStat(Integer.parseInt(s), 0);
                } else {
                    Writer.majStat(Integer.parseInt(s), 1);
                }
            }
        } else if(source.equals(desAjoutTest)){
            desAjoutTest.setVisible(false);
            activAjoutTest.setVisible(true);
            
            IgConstante.AJOUT_TEST = false;
        } else if (source.equals(activAjoutTest)){
            desAjoutTest.setVisible(true);
            activAjoutTest.setVisible(false);
            
            IgConstante.AJOUT_TEST = true;
        }
    }
}
