package Graphique.Tuto;

import Graphique.Fenetre;
import Graphique.Tuto.ListDial.ListDialTuto;
import Personnages.Guerrier;
import Personnages.Warrior;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class Tuto extends JComponent implements MouseListener {
    private String imageDeFond = "";
    private String ligne1 = "";
    private String ligne2 = "";
    private String ligne3 = "";
    private String persoDroite = "";
    private ListDialTuto dial;
    private int continu = 1;
    private Warrior warrior;
    private int zoneText = 0;
    private String text;
    public Fenetre fen;


    public Tuto(Fenetre fen) {
        this.fen = fen;
        addMouseListener(this);
        this.dial = new ListDialTuto();
        this.warrior = new Guerrier();
    }

    public void paintComponent(Graphics g){

        Image img = new javax.swing.ImageIcon(getClass().getResource(imageDeFond)).getImage();
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);

        Image img2 = new javax.swing.ImageIcon(getClass().getResource(persoDroite)).getImage();
        g.drawImage(img2, this.getWidth()-20-img2.getWidth(this), this.getHeight()-130-img2.getHeight(this), img2.getWidth(this), img2.getHeight(this), this);
        g.fillRoundRect(0, this.getHeight()-130, this.getWidth(), 100, 5, 5);
        Font font = new Font("desc", Font.BOLD, 12);
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString(ligne1, 20, this.getHeight()-95);
        g.drawString(ligne2, 20, this.getHeight()-75);
        g.drawString(ligne3, 20, this.getHeight()-55);

        g.fillRoundRect(this.getWidth()-120 , this.getHeight()- 90, zoneText * 100, zoneText * 40, 5, 5);
        g.setColor((Color.BLACK));
        if(zoneText == 1){
            g.drawString(text, this.getWidth()-110, this.getHeight()- 68);
        }
    }



    @Override
    public void mousePressed(MouseEvent e) {
        if(continu == 12){
            this.fen.CombatTuto();
        }

        if(continu == 10){
            warrior.setArtsLearned(new ArtMartiaux(3));
            warrior.setArtsLearned(new ArtMartiaux(4));
        }
        if(continu != 3 && continu != 7 && continu < 12) {
            ligne1 = dial.dial1(continu, this.warrior);
            ligne2 = dial.dial2(continu, this.warrior);
            ligne3 = dial.dial3(continu, this.warrior);
            continu++;
            repaint();
        }

        if(continu == 7){
            this.text = "";
            fenetreChoix();
        }

    }


    public void keyPressed(KeyEvent e) {
        char Caract = e.getKeyChar();
        String carS = String.valueOf(Caract);
        if(continu == 3){
            if(carS.equals("1") || carS.equals("2")) {
                if(carS.equals("1")){
                    techniqueChoix(1);
                } else {
                    techniqueChoix(2);
                }
                ligne1 = dial.dial1(continu, this.warrior);
                ligne2 = dial.dial2(continu, this.warrior);
                ligne3 = dial.dial3(continu, this.warrior);
                continu++;
                repaint();
            }
        }

        if(continu == 7){
            if(carS.equals("1") || carS.equals("2") || carS.equals("3") || carS.equals("4") || carS.equals("5") || carS.equals("6") || carS.equals("7") || carS.equals("8") || carS.equals("9") || carS.equals("0")) {
                if(text.length() < 3) {
                    this.text = this.text + Caract;
                    fenetreChoix();
                }
            }
            if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                if(Integer.parseInt(this.text) < 10 && Integer.parseInt(this.text) > 0) {
                    ligne1 = "Alors on investie " + this.text + " points dedans";
                    ligne2 = dial.dial2(continu, this.warrior);
                    ligne3 = warrior.getArtsLearned().get(0).getDesc();
                    continu++;
                    this.zoneText = 0;
                    repaint();
                    warrior.getArtsLearned().get(0).utilisationTuto(warrior, Integer.parseInt(this.text));

                } else {
                    ligne1 = "";
                    ligne2 = "Euh non, la technique est niveau 1";
                    ligne3 = "Tu ne peux investir q'entre 0 et 10 points";
                    this.text = "";
                    repaint();
                }
            }
            if(e.getKeyCode()==KeyEvent.VK_DELETE  || e.getKeyCode()==KeyEvent.VK_BACK_SPACE) {
                if(this.text.length() > 0) {
                    this.text = this.text.substring(0, this.text.length() - 1);
                    fenetreChoix();
                }
            }
        }

    }

    private void fenetreChoix(){
        this.zoneText = 1;
        repaint();
    }

    public void techniqueChoix(int choix){
        warrior.setArtsLearned(new ArtMartiaux(choix));
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


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    public void setImageDeFond(String imageDeFond) {
        this.imageDeFond = imageDeFond;
    }

    public void setLigne1(String ligne1) {
        this.ligne1 = ligne1;
    }

    public void setLigne2(String ligne2) {
        this.ligne2 = ligne2;
    }

    public void setLigne3(String ligne3) {
        this.ligne3 = ligne3;
    }

    public void setPersoDroite(String persoDroite) {
        this.persoDroite = persoDroite;
    }

    public void setDial(ListDialTuto dial) {
        this.dial = dial;
    }

    public void setContinu(int continu) {
        this.continu = continu;
    }

    public void setWarrior(Warrior warrior) {
        this.warrior = warrior;
    }

    public int getContinu() {
        return continu;
    }

    public Warrior getWarrior() {
        return warrior;
    }
}
