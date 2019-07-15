package Personnages;

import Cartes.Techniques;
import Graphique.Bouton.*;
import Graphique.Fenetre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ProfilPersonnage extends JComponent implements MouseListener, ActionListener {
    private Fenetre fen;
    private Warrior warrior;
    private boolean voirStats = true;
    private Techniques techniquesADeplacer;
    private int emplacementTechniqueADeplacer = 1000;

    public ProfilPersonnage(Fenetre fen, Warrior warrior) {
        this.fen = fen;
        this.warrior = warrior;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Image img = new javax.swing.ImageIcon(getClass().getResource(this.warrior.getFondEcran())).getImage();
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);

        g.setColor(new Color(142, 162, 198, 80));
        g.fillRoundRect(5, 5, 500, 520, 15, 15);

        Font font = new Font("desc", Font.BOLD, 25);
        g.setFont(font);
        g.setColor(Color.WHITE);

        if (voirStats) {
            g.drawString(warrior.getClasse(), 155, 65);

            font = new Font("desc", Font.BOLD, 15);
            g.setFont(font);
            g.drawString("Concentration : " + warrior.getConcentration(), 25, 100);
            g.drawString("Force : " + warrior.getForce(), 25, 130);
            g.drawString("Adresse : " + warrior.getAdresse(), 25, 160);
            g.drawString("Charisme : " + warrior.getCharisme(), 25, 190);
            g.drawString("Concentration : " + warrior.getConcentration(), 25, 220);
            g.drawString(warrior.getTypeRessource() + " : " + warrior.getRessource(), 25, 250);
            g.drawString("Attaque : " + warrior.getAttaque(), 25, 310);
            g.drawString("Défense : " + warrior.getDefense(), 25, 340);
            g.drawString("Vie : " + warrior.getLife(), 25, 280);
        } else {
            font = new Font("desc", Font.BOLD, 10);
            g.setFont(font);
            int placement = 20;
            int placementX = 0;
            for (int i = 0; i < warrior.getDeck().size(); i++) {
                if (i == 4) {
                    placement = 170;
                    placementX = 0;
                } else if (i == 8) {
                    placement = 320;
                    placementX = 0;
                }
                JButton boutonCarte = new JButton(new Bouton3Personnage(this, i + 1));
                boutonCarte.addActionListener(this);
                boutonCarte.setBounds(20 + placementX * 95, placement, 90, 120);
                this.add(boutonCarte);

                g.drawString(warrior.getDeck().get(i).getName(), 20 + placementX * 95, placement + 130);

                placementX++;
            }
        }


        JButton boutonRetour = new JButton(new Bouton1AfficherCarte(this.fen));
        boutonRetour.addActionListener(this);
        boutonRetour.setBounds(this.getWidth() - 150, this.getHeight() - 150, 130, 120);
        this.add(boutonRetour);

        JButton boutonDeck = new JButton(new Bouton2Personnage(this));
        boutonDeck.addActionListener(this);
        boutonDeck.setBounds(this.getWidth() - 300, this.getHeight() - 150, 130, 120);
        this.add(boutonDeck);

    }

    public void changeVue() {
        if (this.voirStats) {
            this.voirStats = false;
        } else {
            this.voirStats = true;
        }
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public boolean isVoirStats() {
        return voirStats;
    }

    public Techniques getTechniquesADeplacer() {
        return techniquesADeplacer;
    }

    public void setTechniquesADeplacer(Techniques techniquesADeplacer) {
        this.techniquesADeplacer = techniquesADeplacer;
    }

    public Warrior getWarrior() {
        return warrior;
    }

    public int getEmplacementTechniqueADeplacer() {
        return emplacementTechniqueADeplacer;
    }

    public void setEmplacementTechniqueADeplacer(int emplacementTechniqueADeplacer) {
        this.emplacementTechniqueADeplacer = emplacementTechniqueADeplacer;
    }
}
