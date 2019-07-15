package Graphique.Tuto;

import Graphique.Bouton.*;
import Graphique.Fenetre;
import Graphique.Tuto.ListDial.ListDialCreationDePersonnage;
import Personnages.Guerrier;
import Personnages.Warrior;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CreationPersonnage  extends JComponent implements MouseListener, ActionListener {
    private Fenetre fen;
    private Warrior warrior;
    private String imageDeFond = "";
    private String persoDroite = "";
    private String ligne1 = "";
    private String ligne2 = "";
    private String ligne3 = "";
    private int zoneText = 0;
    private String text;
    private int continu = 0;
    private boolean assignerAttribut = false;
    private boolean afficherPortraitPersonnage = false;
    private boolean choixCartes = false;
    private Boolean affichageDial = true;
    private ListDialCreationDePersonnage dial;
    private int tailleLigne1 = 0;
    private int tailleLigne2 = 0;
    private int tailleLigne3 = 0;
    private int pointsRestant = 30;
    private Timer timer = new Timer(50, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (ligne1.length() > tailleLigne1) {
                tailleLigne1++;
                if (ligne1.length() > tailleLigne1) {
                    tailleLigne1++;
                    if (ligne1.length() > tailleLigne1) {
                        tailleLigne1++;
                    }
                }
                repaint();
            } else if (ligne2.length() > tailleLigne2) {
                tailleLigne2++;
                if (ligne2.length() > tailleLigne2) {
                    tailleLigne2++;
                    if (ligne2.length() > tailleLigne2) {
                        tailleLigne2++;
                    }
                }
                repaint();
            } else if (ligne3.length() > tailleLigne3) {
                tailleLigne3++;
                if (ligne3.length() > tailleLigne3) {
                    tailleLigne3++;
                    if (ligne3.length() > tailleLigne3) {
                        tailleLigne3++;
                    }
                }
                repaint();
            } else {
                continu++;
                affichageDial = false;
                timer.stop();
            }



        }
    });

    public CreationPersonnage(Fenetre fen) {
        this.fen = fen;
        addMouseListener(this);
        this.dial = new ListDialCreationDePersonnage();
        this.warrior = new Guerrier();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Image img = new javax.swing.ImageIcon(getClass().getResource(imageDeFond)).getImage();
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);

        Image img2 = new javax.swing.ImageIcon(getClass().getResource(persoDroite)).getImage();
        g.drawImage(img2, this.getWidth()-20-img2.getWidth(this), this.getHeight()-130-img2.getHeight(this), img2.getWidth(this), img2.getHeight(this), this);
        g.fillRoundRect(0, this.getHeight()-130, this.getWidth(), 100, 5, 5);
        Font font = new Font("desc", Font.BOLD, 12);
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString(ligne1.substring(0, tailleLigne1), 20, this.getHeight()-95);
        g.drawString(ligne2.substring(0, tailleLigne2), 20, this.getHeight()-75);
        g.drawString(ligne3.substring(0, tailleLigne3), 20, this.getHeight()-55);

        if(zoneText == 1){
            g.setColor(new Color(142, 162, 198,80));
            g.fillRoundRect(5 , 5, 500, 520, 15, 15);
        }

        if (assignerAttribut){
            font = new Font("desc", Font.BOLD, 25);
            g.setFont(font);
            g.setColor(Color.WHITE);
            g.drawString("Points réstant : " + pointsRestant, 130, 370);
            g.drawString("Concentration", 155, 45);
            g.drawString("" +warrior.getConcentration(), 220, 75);
            g.drawString("Force", 198, 120);
            g.drawString("" + warrior.getForce(), 220, 150);
            g.drawString("Adresse", 180, 195);
            g.drawString("" + warrior.getAdresse(), 220, 225);
            g.drawString("Charisme", 180, 270);
            g.drawString("" + warrior.getCharisme(), 220, 310);

            JButton boutonConcUp = new JButton(new Bouton3CreationPersonnage("Concentration", true, false, this));
            boutonConcUp.addActionListener(this);
            boutonConcUp.setBounds(280, 50 , 30, 30);
            this.add(boutonConcUp);

            JButton boutonConcDown = new JButton(new Bouton3CreationPersonnage("Concentration", false, false, this));
            boutonConcDown.addActionListener(this);
            boutonConcDown.setBounds(160, 50 , 30, 30);
            this.add(boutonConcDown);

            JButton boutonForUp = new JButton(new Bouton3CreationPersonnage("Force", true, false, this));
            boutonForUp.addActionListener(this);
            boutonForUp.setBounds(280, 125 , 30, 30);
            this.add(boutonForUp);

            JButton boutonForDown = new JButton(new Bouton3CreationPersonnage("Force", false, false, this));
            boutonForDown.addActionListener(this);
            boutonForDown.setBounds(160, 125 , 30, 30);
            this.add(boutonForDown);

            JButton boutonAddUp = new JButton(new Bouton3CreationPersonnage("Adresse", true, false, this));
            boutonAddUp.addActionListener(this);
            boutonAddUp.setBounds(280, 200 , 30, 30);
            this.add(boutonAddUp);

            JButton boutonAddDown = new JButton(new Bouton3CreationPersonnage("Adresse", false, false, this));
            boutonAddDown.addActionListener(this);
            boutonAddDown.setBounds(160, 200 , 30, 30);
            this.add(boutonAddDown);

            JButton boutonChaUp = new JButton(new Bouton3CreationPersonnage("Charisme", true, false, this));
            boutonChaUp.addActionListener(this);
            boutonChaUp.setBounds(280, 285 , 30, 30);
            this.add(boutonChaUp);

            JButton boutonChaDown = new JButton(new Bouton3CreationPersonnage("Charisme", false, false, this));
            boutonChaDown.addActionListener(this);
            boutonChaDown.setBounds(160, 285 , 30, 30);
            this.add(boutonChaDown);

            JButton boutonValidate = new JButton(new Bouton3CreationPersonnage("", false, true, this));
            boutonValidate.addActionListener(this);
            boutonValidate.setBounds(190, 400 , 100, 40);
            this.add(boutonValidate);
        }

        if(choixCartes){
            int placement = 20;
            int placementX = 0;
            for(int i = 0; i < 12; i++){
                if(i == 4){
                    placement = 170;
                    placementX = 0;
                } else if (i == 8 ){
                    placement = 320;
                    placementX = 0;
                }
                JButton boutonCarte = new JButton(new Bouton4CreationPersonnage(this, i, warrior.getListTechnique(), "carte " + (i+1)));
                boutonCarte.addActionListener(this);
                boutonCarte.setBounds(20 + placementX * 95, placement , 90, 120);
                this.add(boutonCarte);

                placementX++;
            }
        }

        if(afficherPortraitPersonnage){
            JButton profilPersonnage = new JButton(new BoutonPersonnage(this.getFen(), this.warrior));
            profilPersonnage.addActionListener(this);
            profilPersonnage.setBounds(this.getWidth() - 120, 5 , 115, 150);
            profilPersonnage.setIcon(new ImageIcon(getClass().getResource(this.warrior.getIcon())));
            this.add(profilPersonnage);

        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println(continu);
        System.out.println(affichageDial);

        switch (continu){
            case 3 :
                afficherListePersonnages(this.getGraphics());
                repaint();
                affichageDial = false;
                break;

            case 13 :
                zoneText = 1;
                warrior.setCharisme(30);
                warrior.setAdresse(30);
                warrior.setForce(30);
                assignerAttribut = true;
                timer.stop();
                tailleLigne1 = 0;
                tailleLigne2 = 0;
                tailleLigne3 = 0;

                ligne1 = dial.dial1(continu, warrior);
                ligne2 = dial.dial2(continu, warrior);
                ligne3 = dial.dial3(continu, warrior);
                timer.start();
                affichageDial = true;
                this.continu++;
                break;

            case 14 :
                tailleLigne1 = ligne1.length();
                tailleLigne2 = ligne2.length();
                tailleLigne3 = ligne3.length();
                timer.stop();
                repaint();
                affichageDial = false;
                break;

            case 19 :
                choixCartes = true;
                repaint();
                break;

            case 26 :
                afficherPortraitPersonnage = true;
                imageDeFond = "/img/tuto.jpg";
                persoDroite = "/img/narrateur.png";
                repaint();
                break;

            default :
                if (affichageDial) {
                    tailleLigne1 = ligne1.length();
                    tailleLigne2 = ligne2.length();
                    tailleLigne3 = ligne3.length();
                    timer.stop();
                    repaint();
                    affichageDial = false;
                    continu++;

                } else {
                    timer.stop();
                    tailleLigne1 = 0;
                    tailleLigne2 = 0;
                    tailleLigne3 = 0;

                    ligne1 = dial.dial1(continu, warrior);
                    ligne2 = dial.dial2(continu, warrior);
                    ligne3 = dial.dial3(continu, warrior);
                    timer.start();
                    affichageDial = true;
                    this.continu++;
                }
                break;
        }

    }

    private void afficherListePersonnages(Graphics g){
            int placement = 30;
            this.setLayout(null);
            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout());
            JButton bouton;
            JButton boutonChoix;
            for( int i = 0; i < 4; i++) {
                if(i > 3){
                    placement = 190;
                }
                switch (i) {
                    case 0 :

                        bouton = new JButton(new Bouton1CreationPersonnage("Guerrier"));
                        bouton.addActionListener(this);
                        bouton.setBounds(5 + i * 125, placement , 115, 150);
                        bouton.setIcon(new ImageIcon(getClass().getResource("/img/iconGuerrier.png")));
                        this.add(bouton);

                        boutonChoix = new JButton(new Bouton2CreationPersonnage("Guerrier", this));
                        boutonChoix.addActionListener(this);
                        boutonChoix.setBounds(20 + i * 125, placement + 155 , 80, 25);
                        this.add(boutonChoix);
                        break;

                    case 1 :

                        bouton = new JButton(new Bouton1CreationPersonnage("MaitreRune"));
                        bouton.addActionListener(this);
                        bouton.setBounds(5 + i * 125, placement , 115, 150);
                        bouton.setIcon(new ImageIcon(getClass().getResource("/img/iconRunique.png")));
                        this.add(bouton);

                        boutonChoix = new JButton(new Bouton2CreationPersonnage("MaitreRune", this));
                        boutonChoix.addActionListener(this);
                        boutonChoix.setBounds(20 + i * 125, placement + 155 , 80, 25);
                        this.add(boutonChoix);

                        break;

                    case 2 :

                        bouton = new JButton(new Bouton1CreationPersonnage("Ensorceleuse"));
                        bouton.addActionListener(this);
                        bouton.setBounds(5 + i * 125, placement , 115, 150);
                        bouton.setIcon(new ImageIcon(getClass().getResource("/img/iconEnsorceleuse.png")));
                        this.add(bouton);

                        boutonChoix = new JButton(new Bouton2CreationPersonnage("Ensorceleuse", this));
                        boutonChoix.addActionListener(this);
                        boutonChoix.setBounds(20 + i * 125, placement + 155 , 80, 25);
                        this.add(boutonChoix);

                        break;

                    case 3 :

                        bouton = new JButton(new Bouton1CreationPersonnage("Alchimiste"));
                        bouton.addActionListener(this);
                        bouton.setBounds(5 + i * 125, placement , 115, 150);
                        bouton.setIcon(new ImageIcon(getClass().getResource("/img/iconAlchimiste.png")));
                        this.add(bouton);

                        boutonChoix = new JButton(new Bouton2CreationPersonnage("Alchimiste", this));
                        boutonChoix.addActionListener(this);
                        boutonChoix.setBounds(20 + i * 125, placement + 155 , 80, 25);
                        this.add(boutonChoix);

                        break;
                }
            }

    }

    public void personnageChoix(){
        this.removeAll();
        this.persoDroite = "";
        this.imageDeFond = warrior.getFondEcran();

        this.continu++;
        affichageDial = true;
        tailleLigne1 = 0;
        tailleLigne2 = 0;
        tailleLigne3 = 0;

        ligne1 = "Vous avez choisis : " + this.warrior.getClasse();
        ligne2 = "Nous allons pouvoir passer à la suite...";
        ligne3 = "Le choix de vos Attributs.";
        timer.start();
    }

    public void attributsChoix(){
        this.removeAll();
        assignerAttribut = false;
        affichageDial = true;
        continu = 15;
        timer.stop();
        tailleLigne1 = 0;
        tailleLigne2 = 0;
        tailleLigne3 = 0;

        ligne1 = dial.dial1(continu, warrior);
        ligne2 = dial.dial2(continu, warrior);
        ligne3 = dial.dial3(continu, warrior);
        timer.start();
        continu = 16;
    }

    public void finChoixCarte(){
        this.removeAll();
        this.choixCartes = false;

        assignerAttribut = false;
        affichageDial = true;
        continu = 20;
        timer.stop();
        tailleLigne1 = 0;
        tailleLigne2 = 0;
        tailleLigne3 = 0;

        ligne1 = dial.dial1(continu, warrior);
        ligne2 = dial.dial2(continu, warrior);
        ligne3 = dial.dial3(continu, warrior);
        timer.start();
        continu = 21;
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

    public Timer getTimer() {
        return timer;
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

    public Warrior getWarrior() {
        return warrior;
    }

    public void setWarrior(Warrior warrior) {
        this.warrior = warrior;
    }

    public void ajouterPoint(){
        this.pointsRestant++;
    }

    public void retirerPoint(){
        this.pointsRestant--;
    }

    public int getPointsRestant() {
        return pointsRestant;
    }

    public Fenetre getFen() {
        return fen;
    }

    public boolean isChoixCartes() {
        return choixCartes;
    }

    public void setChoixCartes(boolean choixCartes) {
        this.choixCartes = choixCartes;
    }
}
