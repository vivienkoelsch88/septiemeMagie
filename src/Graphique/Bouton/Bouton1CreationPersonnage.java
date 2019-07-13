package Graphique.Bouton;

import Graphique.Fenetre;
import Graphique.Tuto.FenetreWarriors;
import Personnages.Guerrier;
import Personnages.MaitreDesRunes;
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

            case "MaitreRune" :
                MaitreDesRunes maitreDesRunes = new MaitreDesRunes();
                fen = new FenetreWarriors(maitreDesRunes);
                this.fen = fen;
                break;
        }
    }
}
