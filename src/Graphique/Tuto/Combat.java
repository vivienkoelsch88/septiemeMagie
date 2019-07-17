package Graphique.Tuto;

import Cartes.Techniques;
import Graphique.Fenetre;
import Graphique.Tuto.ListDial.ListDialCombat;
import Personnages.Warrior;
import Graphique.Bouton.Bouton1CombatTuto;
import Graphique.Bouton.Bouton2CombatTuto;
import Graphique.Bouton.Bouton3CombatTuto;
import Monstre.Monstre;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Combat extends JComponent implements MouseListener, ActionListener {
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
    private Techniques techniqueChoisie;
    private Fenetre fen;
    private String dommage = "";
    private int AnimationDommage = 0;
    private boolean choixBouton = true;

//    ************** Animation de dommage adverse **************************
    private Timer timer = new Timer(20, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(AnimationDommage < 30) {
                AnimationDommage++;
                repaint();
            } else {
                AnimationDommage = 0;
                dommage = "";
                repaint();
                timer.stop();
            }
        }
    });

//******************************Constructeur *******************************
    public Combat(Fenetre fen) {
        addMouseListener(this);
        this.dial = new ListDialCombat();
        this.fen = fen;
    }

//    ********************* PaintComponent ************************************
    public void paintComponent(Graphics g){
        //            ************************Background*******************************
        Image img = new javax.swing.ImageIcon(getClass().getResource(imageDeFond)).getImage();
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);

//            ************************** Monstre ********************************
        Image img2 = new javax.swing.ImageIcon(getClass().getResource(persoDroite)).getImage();
        g.drawImage(img2, this.getWidth()-20-img2.getWidth(this), this.getHeight()-130-img2.getHeight(this), img2.getWidth(this), img2.getHeight(this), this);

//        *********************** Fenêtre de dialogue ********************************
        g.fillRoundRect(0, this.getHeight()-130, this.getWidth(), 100, 5, 5);
        Font font = new Font("desc", Font.BOLD, 12);
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString(ligne1, 20, this.getHeight()-95);
        g.drawString(ligne2, 20, this.getHeight()-75);
        g.drawString(ligne3, 20, this.getHeight()-55);

//        ************************** States du joueur ***************************************
        g.setColor((Color.GRAY));
        g.fillRoundRect(5 , 5, this.getWidth()/4, this.getHeight()/4, 5, 5);
        g.setColor((Color.WHITE));
        g.drawString("Concentration : " + this.warrior.getConcentration(), 15, 30);
        g.drawString("Adresse : " + this.warrior.getAdresse(), 15, 50);
        g.drawString("Charisme : " + this.warrior.getCharisme(), 15, 70);
        g.drawString("Force : " + this.warrior.getForce(), 15, 90);
        g.drawString("Endurance : " + this.warrior.getRessource(), 15, 110);
        g.drawString("Attaque : " + this.warrior.getAttaque() + "  Défense : " + this.warrior.getDefense(), 15, 130);
        g.drawString("Vie : " + this.warrior.getLife(), 15, 150);

//        **************************** zone de choix d'investissement ******************************'
        g.setColor((Color.WHITE));
        g.fillRoundRect(this.getWidth()-120 , this.getHeight()- 90, zoneText * 100, zoneText * 40, 5, 5);
        g.setColor((Color.BLACK));
        if(zoneText == 1){
            g.drawString(text, this.getWidth()-110, this.getHeight()- 68);
        }

//****************************************** Affichage de la main *************************************
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

//        *************************************** Animation des dommages *********************************
        font = new Font("Source Code Pro Semibold", Font.BOLD, 50);
        g.setFont(font);
        g.setColor((Color.RED));

        g.drawString(dommage, fen.getWidth() - 120, 100 - (AnimationDommage));


    }


    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println(continu);
        switch (continu){
            case 1 :
                piochePremiereMain();
                ligne1 = dial.dial1(continu, this.warrior);
                ligne2 = dial.dial2(continu, this.warrior);
                ligne3 = dial.dial3(continu, this.warrior);
                continu = 2;
                repaint();
                break;

            case 2 :
                continu = 3;
                tourDeCombat();
                break;

            case 4 :
                riposteDuMonstre();
                this.warrior.resetBonus();
                this.monstre.resetBonus();
                break;

            case 10 :
                ligne1 = "";
                ligne2 = "Le gobelin tombe sous vos coups, bien joué!";
                ligne3 = "";
                repaint();
                continu = 11;
                break;

            case 11 :
                this.fen.CreationPersonnage();
                break;
        }
    }

    private void piochePremiereMain(){
        for(int i = 0; i < this.warrior.getConcentration()/10; i++){
            this.main.add(this.deck.get(i));

        }
    }


    private void tourDeCombat(){
//            ********************** Choix de la carte *********************************
            choixBouton = true;
            ligne1 = "";
            ligne2 = "Choisissez une carte";
            ligne3 = "";

//            **************************** Création des boutons ****************************
        this.setLayout(null);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JButton bouton = new JButton(new Bouton1CombatTuto("Choisir", this));
        bouton.addActionListener(this);
        bouton.setBounds(35, 345, 50, 20);
        this.add(bouton);

        JButton bouton2 = new JButton(new Bouton2CombatTuto("Choisir", this));
        bouton2.addActionListener(this);
        bouton2.setBounds(160, 345, 50, 20);
        this.add(bouton2);

        JButton bouton3 = new JButton(new Bouton3CombatTuto("Choisir", this));
        bouton3.addActionListener(this);
        bouton3.setBounds(285, 345, 50, 20);
        this.add(bouton3);

        repaint();

    }

    public void choixTechnique(int choix){
        if(choixBouton) {
            this.ligne1 = "vous avez choisi la carte " + this.deck.get(choix).getName();
            this.ligne2 = "Combien y investissez vous?";
            this.zoneText = 1;
            this.techniqueChoisie = this.deck.get(choix);
            repaint();
            this.fen.requestFocus();
        }
    }

    public void keyPressed(KeyEvent e) throws InterruptedException {
        char Caract = e.getKeyChar();
        String carS = String.valueOf(Caract);

//        ********************************************* Investissement **********************************
        if(zoneText == 1){
            if(carS.equals("1") || carS.equals("2") || carS.equals("3") || carS.equals("4") || carS.equals("5") || carS.equals("6") || carS.equals("7") || carS.equals("8") || carS.equals("9") || carS.equals("0")) {
                if(text.length() < 3) {
                    this.text = this.text + Caract;
                    repaint();
                }
            }
            if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                choixBouton = false;
//                ************************* Vérification technique niveau 1 *********************************
                if(Integer.parseInt(this.text) <= techniqueChoisie.getLevel()*10 && Integer.parseInt(this.text) >= 0) {
                    this.zoneText = 0;
                    choixBouton = false;
                    this.warrior.setMonstre(this.monstre);

//                    **************************** Utilisation de la technique par le joueur *********************
                    this.techniqueChoisie.utilisationTuto(warrior, Integer.parseInt(this.text));
                    this.ligne1 = techniqueChoisie.getMoveDesc();
                    this.ligne2 = techniqueChoisie.getMoveDesc2();
                    this.ligne3 = techniqueChoisie.getMoveDesc3();
                    repaint();

//                    ****************************** Si la technique est une attaque, dommage au monstre *******************
                    if(this.warrior.getAttaque() + this.warrior.getAttaqueBonus() > 0){
                        this.dommage = "" + this.monstre.prendreDommages(this.warrior.getAttaque() + this.warrior.getAttaqueBonus());

//                    *********************** Animation de dommage ***************************
                        timer.start();
                    }
                    this.text = "";

                    if(this.monstre.getLife()>0) {
                        continu = 4;
                    } else {
                        continu = 10;
                    }

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
        continu = 2;
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

    public Warrior getWarrior() {
        return warrior;
    }
}
