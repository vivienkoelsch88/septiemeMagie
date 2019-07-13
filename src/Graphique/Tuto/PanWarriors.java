package Graphique.Tuto;

import Personnages.Warrior;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class PanWarriors  extends JPanel implements MouseListener, ActionListener {

    private Warrior warrior;

    public PanWarriors(Warrior warrior) {
        this.warrior = warrior;
    }

    public void paintComponent(Graphics g){
        try {
//            ************************Background*******************************
            Image img = ImageIO.read(new File(warrior.getFondEcran()));
            g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);

            } catch (IOException e) {
            e.printStackTrace();
        }

        g.setColor(new Color(142, 162, 198,150));
        g.fillRoundRect(5 , 5, 500, 650, 15, 15);

        Font font = new Font("desc", Font.BOLD, 35);
        g.setFont(font);
        g.setColor((Color.WHITE));
        g.drawString(warrior.getClasse(), 80, 40);

        font = new Font("desc", Font.BOLD, 33);
        g.setFont(font);
        g.drawString("Description : ", 150, 200);

        font = new Font("desc", Font.BOLD, 25);
        g.setFont(font);
        g.drawString("Vie : " + warrior.getLife(), 30, 80);
        g.drawString("Attaque : " + warrior.getAttaque(), 30, 110);
        g.drawString("Défense : " + warrior.getDefense(), 30, 140);

        font = new Font("desc", Font.BOLD, 15);
        g.setFont(font);
        int compteur = 250;
        for (String line : warrior.getDesc()
             ) {
            g.drawString(line, 30, compteur);
            compteur = compteur + 20;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    public void keyPressed(KeyEvent e){

    }

//    ********************************************************************************************
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

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
