package Graphique;

import Monstre.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;


public class Fenetre extends JFrame implements KeyListener, ActionListener {

    private Tuto pan = new Tuto(this);
    private Combat panCombat = new Combat(this);
    private String actif;

    public Fenetre(){
        this.setTitle("Ma première fenêtre Java");
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
        pan.setImageDeFond("tuto.jpg");
        pan.setPersoDroite("narrateur.png");
        pan.setLigne1("Bienvenue sur la 7eme magie, on va commencer par créer votre personnage,");
        pan.setLigne2("Pour le momment il n'existe qu'une classe, le Guerrier,");
        pan.setLigne3("Celui-ci possède des stats moyennes autant en défense qu'en attaque, parfait pour commencer...");
        pan.repaint();
    }

    public void CombatTuto(){
        Monstre monstre = new Gobelin();

        this.setContentPane(panCombat);
        this.actif = "panCombat";
        panCombat.setWarrior(this.pan.getWarrior());
        panCombat.setMonstre(monstre);
        panCombat.setImageDeFond("combatTuto.jpg");
        panCombat.setPersoDroite("gobelin.png");
        panCombat.setLigne1("");
        panCombat.setLigne2("un gobelin vous fait face");
        panCombat.setLigne3("");
        panCombat.setDeck(this.pan.getWarrior().getDeck());

        panCombat.repaint();
        this.getContentPane().revalidate();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(this.actif.equals("pan")){
            pan.keyPressed(e);
        } else if (this.actif.equals("panCombat")){
            try {
                panCombat.keyPressed(e);
            } catch (InterruptedException e1) {
            }
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
