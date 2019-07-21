package Graphique;

import Cartes.CartesGuerrier.AttaqueDouble;
import Cartes.CartesGuerrier.CoupAssomant;
import Cartes.CartesGuerrier.Feinte;
import Cartes.Techniques;
import Graphique.Bouton.*;
import Monstre.Monstre;
import Personnages.Warrior;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Combat extends JComponent implements MouseListener, ActionListener {
    private String imageDeFond;
    private String persoDroite;
    private String Joueur;
    private Fenetre fen;
    private int placementJoueur;
    private int placementMonstre;
    private Warrior warrior;
    private Monstre monstre;
    private String message;
    private ArrayList<Techniques> mainDuJoueur = new ArrayList();
    private boolean afficherCarte = false;
    private int carteChoisie;
    private boolean afficherMain = true;
    private int Action1 = 1;
    private int Action2 = 2;
    private int Action3 = 0;
    private int compteurChoix = 1;
    private String attributInvest1;
    private String attributInvest2;
    private String attributInvest3;
    private int[] investissement = {0,0,0};
    private int defenseDuWarrior = 0;
    private String TypeNextMove = "";


    public Combat(String imageDeFond, Fenetre fen, Warrior warrior, Monstre monstre) {
        this.imageDeFond = imageDeFond;
        this.fen = fen;
        this.warrior = warrior;
        this.monstre = monstre;
        placementJoueur = 4;
        placementMonstre = 6;
        this.message = "Choisissez une carte";
//        **********************
        warrior.getDeck().add(new AttaqueDouble());
        warrior.getDeck().add(new CoupAssomant());
        warrior.getDeck().add(new Feinte());

//        *************************
        for(int i = 0; i < warrior.getConcentration()/10 ; i++) {
            pioche(1);
        }
    }

    public void paintComponent(Graphics g){
        int uniteX = (getWidth())/11;
        //            ************************Background*******************************
        Image img = new javax.swing.ImageIcon(getClass().getResource(imageDeFond)).getImage();
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);

//            ************************** Monstre et héro ********************************

        Image img2 = new javax.swing.ImageIcon(getClass().getResource(persoDroite)).getImage();
        g.drawImage(img2, uniteX * placementMonstre, 210, uniteX, 120, this);

        Image img3 = new javax.swing.ImageIcon(getClass().getResource(Joueur)).getImage();
        g.drawImage(img3, uniteX * placementJoueur, 210, uniteX, 120, this);


//        ******************************* Zone de combat **********************************
        g.setColor(Color.black);
        Graphics2D g1 = (Graphics2D) g;
        BasicStroke line = new BasicStroke(4.0f);
        g1.setStroke(line);


        for(int i=0; i<10; i++) {
            g.drawLine(uniteX * (i + 1), 200, uniteX * (i + 1), 350);
        }
        g.drawLine(uniteX, 200, getWidth() - uniteX - 5, 200);
        g.drawLine(uniteX, 350, getWidth() - uniteX - 5, 350);

        g.setColor((Color.GRAY));
        g.fillRoundRect(50 , 365, this.getWidth() - 100, 80, 5, 5);
        Font font = new Font("desc", Font.BOLD, 25);
        g.setFont(font);
        g.setColor((Color.WHITE));
        g.drawString(message , 80, 410);

//        ******************************** fenetre du joueur ******************************************************
        g.setColor((Color.GRAY));
        g.fillRoundRect(5 , 5, this.getWidth()/4, this.getHeight()/4, 5, 5);
        font = new Font("desc", Font.BOLD, 15);
        g.setFont(font);
        g.setColor((Color.WHITE));
        g.drawString("Concentration : " + this.warrior.getConcentration(), 15, 30);
        g.drawString("Adresse : " + this.warrior.getAdresse(), 15, 50);
        g.drawString("Charisme : " + this.warrior.getCharisme(), 15, 70);
        g.drawString("Force : " + this.warrior.getForce(), 15, 90);
        g.drawString(this.warrior.getTypeRessource() + " : " + this.warrior.getRessource(), 15, 110);
        g.drawString("Attaque : " + this.warrior.getAttaque() + "  Défense : " + this.warrior.getDefense(), 15, 130);
        g.drawString("Vie : " + this.warrior.getLife(), 15, 150);

//        ******************************** Afficher la main du joueur **********************************************
        if(afficherMain) {
            for (int i = 0; i < mainDuJoueur.size(); i++) {
                JButton carte = new JButton(new AfficheCarteCombat(this.fen, i, this.mainDuJoueur.get(i).getName()));
                carte.addActionListener(this);
                carte.setBounds(50 + i * 125, this.getHeight() - 190, 120, 160);
                this.add(carte);
            }
        }

//        ********************************* Afficher la carte choisie par le joueur ***************************
        if(afficherCarte){
            g.setColor((Color.GRAY));
            g.fillRoundRect(255 , 20, this.getWidth()/2, this.getHeight() - 50, 5, 5);
            g.setColor((Color.WHITE));
            font = new Font("desc", Font.BOLD, 30);
            g.setFont(font);
            g.drawString( mainDuJoueur.get(carteChoisie).getName(), 400, 50);
            g.drawLine(280, 250, 720, 250);
            g.drawLine(280, 400, 720, 400);
            g.drawLine(280, 550, 720, 550);
            g.drawLine(650, 120, 650, 550);
            font = new Font("desc", Font.BOLD, 15);
            g.setFont(font);
            g.drawString( "Ordre " + compteurChoix, 665, 120);

            JButton retour = new JButton(new RetourChoixCarteCombat(this.fen));
            retour.addActionListener(this);
            retour.setBounds(320, 560 , 90, 35);
            this.add(retour);

            JButton choisir = new JButton(new ActiverCarteCombat(this.fen));
            choisir.addActionListener(this);
            choisir.setBounds(520, 560 , 90, 35);
            this.add(choisir);

//                                  ****************** Contenu de la carte ***************************
            font = new Font("desc", Font.BOLD, 15);
            g.setFont(font);
            g.drawString( mainDuJoueur.get(carteChoisie).affiche()[0], 280, 140);
            g.drawString( "Investir " + attributInvest1 + " : " + investissement[0], 280, 190);
            g.drawString( mainDuJoueur.get(carteChoisie).affiche()[2], 280, 290);
            g.drawString( "Investir " + attributInvest2 + " : " + investissement[1], 280, 340);
            g.drawString( mainDuJoueur.get(carteChoisie).affiche()[4], 280, 440);
            g.drawString( "Investir " + attributInvest3 + " : " + investissement[2], 280, 490);


            JButton OrdreAction = new JButton(new OrdreActionCombat(this.fen, Action1, 1));
            OrdreAction.addActionListener(this);
            OrdreAction.setBounds(670, 190 , 50, 35);
            this.add(OrdreAction);

            OrdreAction = new JButton(new OrdreActionCombat(this.fen, Action2, 2));
            OrdreAction.addActionListener(this);
            OrdreAction.setBounds(670, 340 , 50, 35);
            this.add(OrdreAction);

            OrdreAction = new JButton(new OrdreActionCombat(this.fen, Action3, 3));
            OrdreAction.addActionListener(this);
            OrdreAction.setBounds(670, 490 , 50, 35);
            this.add(OrdreAction);

            OrdreAction = new JButton(new ChoixInvestCombat(this.fen, -1, 1));
            OrdreAction.addActionListener(this);
            OrdreAction.setBounds(300, 200 , 50, 35);
            this.add(OrdreAction);

            OrdreAction = new JButton(new ChoixInvestCombat(this.fen, +1, 1));
            OrdreAction.addActionListener(this);
            OrdreAction.setBounds(400, 200 , 50, 35);
            this.add(OrdreAction);

            OrdreAction = new JButton(new ChoixInvestCombat(this.fen, -1, 2));
            OrdreAction.addActionListener(this);
            OrdreAction.setBounds(300, 350 , 50, 35);
            this.add(OrdreAction);

            OrdreAction = new JButton(new ChoixInvestCombat(this.fen, +1, 2));
            OrdreAction.addActionListener(this);
            OrdreAction.setBounds(400, 350 , 50, 35);
            this.add(OrdreAction);

            OrdreAction = new JButton(new ChoixInvestCombat(this.fen, -1, 3));
            OrdreAction.addActionListener(this);
            OrdreAction.setBounds(300, 500 , 50, 35);
            this.add(OrdreAction);

            OrdreAction = new JButton(new ChoixInvestCombat(this.fen, +1, 3));
            OrdreAction.addActionListener(this);
            OrdreAction.setBounds(400, 500 , 50, 35);
            this.add(OrdreAction);
        }


    }
//    ************************** Fin du paint **********************************************************

    public void afficheCarte(int numeroCarte){
        afficherCarte = true;
        afficherMain = false;
        this.removeAll();
        carteChoisie = numeroCarte;
        attributInvest1 = mainDuJoueur.get(carteChoisie).affiche()[1];
        attributInvest2 = mainDuJoueur.get(carteChoisie).affiche()[3];
        attributInvest3 =  mainDuJoueur.get(carteChoisie).affiche()[5];
        repaint();
    }

    public void retourChoixCarte(){
        afficherCarte = false;
        afficherMain = true;
        this.removeAll();
        carteChoisie = 0;
        investissement = new int[]{0, 0, 0};
        repaint();
    }

    public void activerCarteChoisie(){
        afficherCarte = false;
        this.removeAll();
        this.message = "Vous avez choisis la carte : " + mainDuJoueur.get(carteChoisie).getName();
        repaint();
        tourDeJeu(1);
    }

    public void modifierInvest(int refAction, int value){
        switch (refAction){
            case 1 :
                investissement[0] = investissement[0] + value * mainDuJoueur.get(carteChoisie).getCout1();
                if(investissement[0] < 0){
                    investissement[0] = 0;
                } else if (investissement[0] > mainDuJoueur.get(carteChoisie).getLevel() * 10){
                    investissement[0] = investissement[0] - mainDuJoueur.get(carteChoisie).getCout1();
                }
                break;

            case 2 :
                investissement[1] = investissement[1] + value * mainDuJoueur.get(carteChoisie).getCout2();
                if(investissement[1] < 0){
                    investissement[1] = 0;
                } else if (investissement[1] > mainDuJoueur.get(carteChoisie).getLevel() * 10){
                    investissement[1] = investissement[1] - mainDuJoueur.get(carteChoisie).getCout2();
                }
                break;

            case 3 :
                investissement[2] = investissement[2] + value * mainDuJoueur.get(carteChoisie).getCout3();
                if(investissement[2] < 0){
                    investissement[2] = 0;
                } else if (investissement[2] > mainDuJoueur.get(carteChoisie).getLevel() * 10){
                    investissement[2] = investissement[2] - mainDuJoueur.get(carteChoisie).getCout3();
                }
                break;
        }
        repaint();
    }

    private void tourDeJeu(int Action){
        int refAction1 = 0;
        int refAction2= 0;
        if(Action1 == 1){
            refAction1 = 1;
        } else if (Action1 == 2){
            refAction2 = 1;
        }
        if(Action2 == 1){
            refAction1 = 2;
        } else if (Action2 == 2){
            refAction2 = 2;
        }
        if(Action3 == 1){
            refAction1 = 3;
        } else if (Action3 == 2){
            refAction2 = 3;
        }
        switch (Action){
            case 1 :
                mainDuJoueur.get(carteChoisie).utilisation(this, investissement[refAction1 - 1], refAction1);
                tourDeJeuDuMonstre(1);
                break;

            case 2 :
                mainDuJoueur.get(carteChoisie).utilisation(this, investissement[refAction2 - 1], refAction2);
                tourDeJeuDuMonstre(2);
                break;
        }

    }

    public void tourDeJeuDuMonstre(int refAction){
        this.monstre.tourDeJeuDuMonstre(this);
        if(refAction == 1){
            tourDeJeu(2);
        } else {
            finDuTour();
        }

    }

    public void finDuTour(){

    }

//******************************* Différents effet appelés par les cartes *************************

    public void pioche(int nbrCartePioche){
        for(int i = 0; i < nbrCartePioche; i++) {
            mainDuJoueur.add(warrior.getDeck().get(mainDuJoueur.size()));
        }
    }

    public void deplacement(int nbrCase){
        placementJoueur = placementMonstre + nbrCase;
        if(placementJoueur < 1){
            placementJoueur = 1;
        } else if (placementJoueur >= placementMonstre){
            placementJoueur = placementMonstre - 1;
        }
    }

    public void attaquer(int puissance){
        this.monstre.prendreDommages(puissance + this.warrior.getAttaque() + this.warrior.getAttaqueBonus());
    }

    public void defendre(int puissance){
        this.defenseDuWarrior = this.defenseDuWarrior + puissance;
    }

    //    ******************************** Choix de l'ordre des actions *****************************
    public void ordreAction(int refAction){
        this.removeAll();

            switch (refAction) {
                case 1 :
                    if (Action1 == 1 && compteurChoix == 2){
                        break;
                    }
                    Action1 = compteurChoix;
                    if(compteurChoix == 2){
                        compteurChoix = 1;
                        if(Action2 == 1){
                            Action3 = 0;
                        } else {
                            Action2 = 0;
                        }
                    } else {
                        compteurChoix = 2;
                        Action2 = 2;
                        Action3 = 0;
                    }
                    break;

                case 2:
                    if (Action2 == 1 && compteurChoix == 2){
                        break;
                    }
                    Action2 = compteurChoix;
                    if(compteurChoix == 2){
                        compteurChoix = 1;
                        if(Action1 == 1){
                            Action3 = 0;
                        } else {
                            Action1 = 0;
                        }
                    } else {
                        compteurChoix = 2;
                        Action1 = 2;
                        Action3 = 0;
                    }
                    break;

                case 3:
                    if (Action3 == 1 && compteurChoix == 2){
                        break;
                    }
                    Action3 = compteurChoix;
                    if(compteurChoix == 2){
                        compteurChoix = 1;
                        if(Action2 == 1){
                            Action1 = 0;
                        } else {
                            Action2 = 0;
                        }
                    } else {
                        compteurChoix = 2;
                        Action2 = 0;
                        Action1 = 2;
                    }
                    break;
            }
        repaint();
    }


//    *******************************************************************************************
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

    public Fenetre getFen() {
        return fen;
    }

    public void setFen(Fenetre fen) {
        this.fen = fen;
    }

    public String getJoueur() {
        return Joueur;
    }

    public void setJoueur(String joueur) {
        Joueur = joueur;
    }

    public Warrior getWarrior() {
        return warrior;
    }

    public void setWarrior(Warrior warrior) {
        this.warrior = warrior;
    }

    public Monstre getMonstre() {
        return monstre;
    }

    public void setMonstre(Monstre monstre) {
        this.monstre = monstre;
    }

    public String getTypeNextMove() {
        return TypeNextMove;
    }

    public void setTypeNextMove(String typeNextMove) {
        TypeNextMove = typeNextMove;
    }
}
