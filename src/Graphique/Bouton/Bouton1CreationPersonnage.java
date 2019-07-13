package Graphique.Bouton;

import Graphique.Fenetre;
import Graphique.Tuto.FenetreWarriors;
import Personnages.Guerrier;
import Personnages.Warrior;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Bouton1CreationPersonnage extends AbstractAction {
    private String name;
    private FenetreWarriors fen;

    public Bouton1CreationPersonnage(String name) {
        super("Voir");
        this.name = name;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (this.name){
            case "Guerrier" :
                Guerrier guerrier = new Guerrier();
                FenetreWarriors fen = new FenetreWarriors(guerrier);
                this.fen = fen;
                break;
        }
    }
}
