package Graphique.Bouton;

import Graphique.Tuto.FenetreWarriors;
import Personnages.*;

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

            case "Ensorceleuse" :
                Ensorceleuse ensorceleuse = new Ensorceleuse();
                fen = new FenetreWarriors(ensorceleuse);
                this.fen = fen;
                break;

            case "Alchimiste" :
                Alchimiste alchimiste = new Alchimiste();
                fen = new FenetreWarriors(alchimiste);
                this.fen = fen;
                break;
        }
    }
}
