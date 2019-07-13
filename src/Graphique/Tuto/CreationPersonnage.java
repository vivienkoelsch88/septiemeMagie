package Graphique.Tuto;

import Graphique.Bouton.Bouton1CombatTuto;
import Graphique.Bouton.Bouton1CreationPersonnage;
import Graphique.Fenetre;
import Graphique.Tuto.ListDial.ListDialCreationDePersonnage;
import Personnages.Guerrier;
import Personnages.Warrior;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import static javax.swing.text.StyleConstants.setIcon;

public class CreationPersonnage  extends JPanel implements MouseListener, ActionListener {
    private Fenetre fen;
    private Warrior warrior;
    private String imageDeFond = "";
    private String persoDroite = "";
    private String ligne1 = "";
    private String ligne2 = "";
    private String ligne3 = "";
    private int zoneText = 0;
    private String text;
    private int continu = 1;
    private ListDialCreationDePersonnage dial;

    public CreationPersonnage(Fenetre fen) {
        this.fen = fen;
        addMouseListener(this);
        this.dial = new ListDialCreationDePersonnage();
        this.warrior = new Guerrier();
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

        g.fillRoundRect(this.getWidth()-120 , this.getHeight()- 90, zoneText * 100, zoneText * 40, 5, 5);
        g.setColor((Color.BLACK));
        if(zoneText == 1){
            g.drawString(text, this.getWidth()-110, this.getHeight()- 68);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch (continu){
            case 1 :
                this.ligne1 = dial.dial1(continu, this.warrior);
                this.ligne2 = dial.dial2(continu, this.warrior);
                this.ligne3 = dial.dial3(continu, this.warrior);
                this.continu++;
                afficherListePersonnages(this.getGraphics());
                repaint();
                break;
        }
    }

    private void afficherListePersonnages(Graphics g){
            int placement = 30;
            this.setLayout(null);
            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout());
            JButton bouton;
            for( int i = 0; i < 2; i++) {
                if(i > 2){
                    placement = 190;
                }
                switch (i) {
                    case 0 :

                        bouton = new JButton(new Bouton1CreationPersonnage("Guerrier"));
                        bouton.addActionListener(this);
                        bouton.setBounds(5 + i * 125, placement , 115, 150);
                        bouton.setIcon(new ImageIcon("iconGuerrier.png"));
                        this.add(bouton);
                    break;

                    case 1 :

                        bouton = new JButton(new Bouton1CreationPersonnage("MaitreRune"));
                        bouton.addActionListener(this);
                        bouton.setBounds(5 + i * 125, placement , 115, 150);
                        bouton.setIcon(new ImageIcon("iconRunique.png"));
                        this.add(bouton);
                        break;
                }
            }

    }

//    ****************** getter and setter ***********************




    public String getImageDeFond() {
        return imageDeFond;
    }

    public void setImageDeFond(String imageDeFond) {
        this.imageDeFond = imageDeFond;
    }

    public String getPersoDroite() {
        return persoDroite;
    }

    public void setPersoDroite(String persoDroite) {
        this.persoDroite = persoDroite;
    }

    public String getLigne1() {
        return ligne1;
    }

    public void setLigne1(String ligne1) {
        this.ligne1 = ligne1;
    }

    public String getLigne2() {
        return ligne2;
    }

    public void setLigne2(String ligne2) {
        this.ligne2 = ligne2;
    }

    public String getLigne3() {
        return ligne3;
    }

    public void setLigne3(String ligne3) {
        this.ligne3 = ligne3;
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

    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
