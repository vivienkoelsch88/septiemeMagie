package Cartes;

import Graphique.Bouton.Bouton1AfficherCarte;
import Graphique.Bouton.Bouton2AfficherCarte;
import Graphique.Fenetre;
import Graphique.Tuto.CreationPersonnage;
import Personnages.Warrior;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AfficherCarte extends JComponent implements MouseListener, ActionListener {
    private Fenetre fen;
    private Warrior warrior;
    private Techniques techniques;
    private CreationPersonnage creationPersonnage;

    public AfficherCarte(Fenetre fen, Warrior warrior, Techniques techniques, CreationPersonnage creationPersonnage) {
        this.fen = fen;
        this.warrior = warrior;
        this.techniques = techniques;
        this.creationPersonnage = creationPersonnage;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Image img = new javax.swing.ImageIcon(getClass().getResource(this.warrior.getFondEcran())).getImage();
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);

        g.setColor(new Color(142, 162, 198,80));
        g.fillRoundRect(5 , 5, 500, 520, 15, 15);

        Font font = new Font("desc", Font.BOLD, 25);
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString(this.techniques.getName(), 155, 65);
        font = new Font("desc", Font.BOLD, 12);
        g.setFont(font);
        int placementDesc = 0;
        for (String desc : this.techniques.getDesc()){
            g.drawString(desc, 40, 105 + (placementDesc * 20));
            placementDesc++;
        }


        JButton boutonRetour = new JButton(new Bouton1AfficherCarte(this.fen));
        boutonRetour.addActionListener(this);
        boutonRetour.setBounds(this.getWidth() - 150, this.getHeight() - 150 , 130, 120);
        this.add(boutonRetour);

        JButton boutonChoisir = new JButton(new Bouton2AfficherCarte(this.fen, this.warrior, this.techniques, creationPersonnage));
        boutonChoisir.addActionListener(this);
        boutonChoisir.setBounds(this.getWidth() - 320, this.getHeight() - 150 , 130, 120);
        this.add(boutonChoisir);
    }




//    ********************************************************************************************
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
}
