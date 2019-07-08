package Graphique;

import Glob.Techniques;
import Glob.Warrior;
import Graphique.Bouton.Bouton1;
import Graphique.Bouton.Bouton2;
import Graphique.Bouton.Bouton3;
import Monstre.Monstre;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Combat extends JPanel implements MouseListener, ActionListener {
    private Warrior warrior;
    private String imageDeFond = "";
    private String persoDroite = "";
    private String ligne1 = "";
    private String ligne2 = "";
    private String ligne3 = "";
    private int continu = 1;
    private int zoneText = 0;
    private String text = "";
    private Monstre monstre;
    private ListDialCombat dial;
    private ArrayList<Techniques> main= new ArrayList();
    private ArrayList<Techniques> deck= new ArrayList();
    private boolean choixCarte = false;
    private Techniques techniqueChoisie;
    private Fenetre fen;


    public Combat(Fenetre fen) {
        addMouseListener(this);
        this.dial = new ListDialCombat();
        this.fen = fen;
    }

    public void paintComponent(Graphics g){
        try {
            Image img = ImageIO.read(new File(imageDeFond));
            g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);

            Image img2 = ImageIO.read(new File(persoDroite));
            g.drawImage(img2, this.getWidth()-20-img2.getWidth(this), this.getHeight()-130-img2.getHeight(this), img2.getWidth(this), img2.getHeight(this), this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.fillRoundRect(0, this.getHeight()-130, this.getWidth(), 100, 5, 5);
        Font font = new Font("desc", Font.BOLD, 12);
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString(ligne1, 20, this.getHeight()-95);
        g.drawString(ligne2, 20, this.getHeight()-75);
        g.drawString(ligne3, 20, this.getHeight()-55);

        g.setColor((Color.GRAY));
        g.fillRoundRect(5 , 5, this.getWidth()/4, this.getHeight()/4, 5, 5);
        g.setColor((Color.WHITE));
        g.drawString("Concentration : " + this.warrior.getConcentration(), 15, 30);
        g.drawString("Adresse : " + this.warrior.getAdresse(), 15, 50);
        g.drawString("Charisme : " + this.warrior.getCharisme(), 15, 70);
        g.drawString("Force : " + this.warrior.getForce(), 15, 90);
        g.drawString("Endurance : " + this.warrior.getEndurance(), 15, 110);
        g.drawString("Attaque : " + this.warrior.getAttaque() + "  Défense : " + this.warrior.getDefense(), 15, 130);
        g.drawString("Vie : " + this.warrior.getLife(), 15, 150);

        g.setColor((Color.WHITE));
        g.fillRoundRect(this.getWidth()-120 , this.getHeight()- 90, zoneText * 100, zoneText * 40, 5, 5);
        g.setColor((Color.BLACK));
        if(zoneText == 1){
            g.drawString(text, this.getWidth()-110, this.getHeight()- 68);
        }


        font.deriveFont(8);
        if(this.main.size() > 0){
            int placement = 190;
            for( int i = 0; i < this.main.size(); i++) {
                if(i > 2){
                    placement = 350;
                }
                g.setColor((Color.GRAY));
                g.fillRoundRect(5 + i * 125, placement,115, 150, 5, 5);
                g.setColor((Color.WHITE));
                g.drawString(this.main.get(i).getName(), 15 + i * 125, placement + 75);

            }


        }

    }


    @Override
    public void mousePressed(MouseEvent e) {
        if(!choixCarte) {
            if (continu == 1) {
                ligne1 = dial.dial1(continu, this.warrior);
                ligne2 = dial.dial2(continu, this.warrior);
                ligne3 = dial.dial3(continu, this.warrior);
                continu++;
                repaint();
            }
            if (continu == 2) {
                piochePremiereMain();
                continu++;
            }
            if (continu == 3) {
                tourDeCombat();
                continu++;
            }
            if (continu == 6) {
                riposteDuMonstre();
                continu++;
            }
        }
    }

    private void piochePremiereMain(){
        for(int i = 0; i < this.warrior.getConcentration()/10; i++){
            this.main.add(this.deck.get(i));

        }
    }

    private void tourDeCombat(){
//            ********************** Choix de la carte *********************************
            choixCarte = true;
            ligne1 = "";
            ligne2 = "Choisissez une carte";
            ligne3 = "";

        this.setLayout(null);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JButton bouton = new JButton(new Bouton1("Choisir", this));
        bouton.addActionListener(this);
        bouton.setBounds(35, 345, 50, 20);
        this.add(bouton);

        JButton bouton2 = new JButton(new Bouton2("Choisir", this));
        bouton2.addActionListener(this);
        bouton2.setBounds(160, 345, 50, 20);
        this.add(bouton2);

        JButton bouton3 = new JButton(new Bouton3("Choisir", this));
        bouton3.addActionListener(this);
        bouton3.setBounds(285, 345, 50, 20);
        this.add(bouton3);

        repaint();

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

    public void setPersoDroite(String persoDroite) {
        this.persoDroite = persoDroite;
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

    public void setMonstre(Monstre monstre) {
        this.monstre = monstre;
    }

    public void setWarrior(Warrior warrior) {
        this.warrior = warrior;
    }

    public void setDeck(ArrayList<Techniques> deck) {
        this.deck = deck;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void choixTechnique(int choix){
        this.ligne1 = "vous avez choisis la carte " + this.deck.get(choix).getName();
        this.ligne2 = "Combien y investissez vous?";
        this.zoneText = 1;
        this.techniqueChoisie = this.deck.get(choix);
        repaint();
        this.fen.requestFocus();
    }

    public void keyPressed(KeyEvent e) {
        char Caract = e.getKeyChar();
        String carS = String.valueOf(Caract);
        if(zoneText == 1){
            if(carS.equals("1") || carS.equals("2") || carS.equals("3") || carS.equals("4") || carS.equals("5") || carS.equals("6") || carS.equals("7") || carS.equals("8") || carS.equals("9") || carS.equals("0")) {
                if(text.length() < 3) {
                    this.text = this.text + Caract;
                    repaint();
                }
            }
            if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                if(Integer.parseInt(this.text) <= 10 && Integer.parseInt(this.text) >= 0) {
                    continu++;
                    this.zoneText = 0;
                    choixCarte = false;
                    this.warrior.setMonstre(this.monstre);
                    this.techniqueChoisie.utilisation(warrior, Integer.parseInt(this.text));
                    this.ligne1 = techniqueChoisie.getMoveDesc();
                    this.ligne2 = techniqueChoisie.getMoveDesc2();
                    this.ligne3 = techniqueChoisie.getMoveDesc3();
                    repaint();
                    continu++;

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
                    repaint();
                }
            }

        }
    }

    private void riposteDuMonstre(){
        this.warrior.prendreDommages(this.monstre.patern(warrior));
        this.ligne1 = this.monstre.getMoveDesc();
        this.ligne2 = this.monstre.getMoveDesc2();
        this.ligne3 = this.monstre.getMoveDesc3();
        repaint();
    }

}
