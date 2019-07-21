package Graphique;

import Graphique.Tuto.CombatTuto;
import Graphique.Tuto.CreationPersonnage;
import Graphique.Tuto.Tuto;
import Monstre.*;
import Personnages.Guerrier;
import Personnages.Warrior;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;


public class Fenetre extends JFrame implements KeyListener, ActionListener {

    private Tuto pan = new Tuto(this);
    private CombatTuto panCombatTuto = new CombatTuto(this);
    private CreationPersonnage panCreation = new CreationPersonnage(this);
    private Combat panCombat;
    private String actif;
    private JComponent panelEnCour;

    public Fenetre(){
        this.setTitle("La 7ème magie");
        this.setSize(1000, 700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pan);
        setResizable(false);
        addKeyListener(this);

        this.setVisible(true);
    }

    public void tuto(){
        this.actif = "pan";
        this.panelEnCour = this.pan;
        pan.setImageDeFond("/img/tuto.jpg");
        pan.setPersoDroite("/img/narrateur.png");
        pan.setLigne1("Bienvenue sur la 7eme magie, on va commencer par créer votre personnage,");
        pan.setLigne2("Pour le momment il n'existe qu'une classe, le Guerrier,");
        pan.setLigne3("Celui-ci possède des stats moyennes autant en défense qu'en attaque, parfait pour commencer...");
        pan.repaint();
    }

    public void CombatTuto(){
        Monstre monstre = new Gobelin();
        this.panelEnCour = this.panCombatTuto;
        this.setContentPane(panCombatTuto);
        this.actif = "panCombatTuto";
        panCombatTuto.setWarrior(this.pan.getWarrior());
        panCombatTuto.setMonstre(monstre);
        panCombatTuto.setImageDeFond("/img/combatTuto.jpg");
        panCombatTuto.setPersoDroite("/img/gobelin.png");
        panCombatTuto.setLigne1("");
        panCombatTuto.setLigne2("un gobelin vous fait face");
        panCombatTuto.setLigne3("");
        panCombatTuto.setDeck(this.pan.getWarrior().getDeck());

        panCombatTuto.repaint();
        this.getContentPane().revalidate();
    }

    public void CreationPersonnage(){
        this.panelEnCour = this.panCreation;
        this.setContentPane(panCreation);
        this.actif = "panCreationPersonnage";
        panCreation.setImageDeFond("/img/tuto.jpg");
        panCreation.setPersoDroite("/img/narrateur.png");
        panCreation.setLigne1("");
        panCreation.setLigne2("Il est maintenant temps de créer votre premier personnage");
        panCreation.setLigne3("");

        panCreation.getTimer().start();
        this.getContentPane().revalidate();
    }

    public void combat(){
        this.panCombat = new Combat("/img/tuto.jpg", this, new Guerrier(), new Gobelin());
        this.panelEnCour = this. panCombat;
        this.setContentPane(panelEnCour);
        this.actif = "panCombat";
        panCombat.setPersoDroite("/img/pionNoir.png");
        panCombat.setJoueur("/img/pionBlanc.png");


        panCombat.repaint();

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(this.actif.equals("pan")){
            pan.keyPressed(e);
        } else if (this.actif.equals("panCombatTuto")){
            try {
                panCombatTuto.keyPressed(e);
            } catch (InterruptedException e1) {
            }
        } else if (this.actif.equals("panCreationPersonnage")){
                panCreation.keyPressed(e);
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public JComponent getPanelEnCour() {
        return panelEnCour;
    }

    public Combat getPanCombat() {
        return panCombat;
    }
}
