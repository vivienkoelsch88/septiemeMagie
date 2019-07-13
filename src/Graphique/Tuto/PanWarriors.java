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

        g.setColor(new Color(142, 162, 198,60));
        g.fillRoundRect(5 , 5, 500, 650, 15, 15);
        g.setColor((Color.WHITE));
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
