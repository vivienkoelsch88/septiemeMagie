package Graphique.Bouton;

import Graphique.Tuto.CreationPersonnage;
import Graphique.Tuto.FenetreWarriors;
import Personnages.Alchimiste;
import Personnages.Ensorceleuse;
import Personnages.Guerrier;
import Personnages.MaitreDesRunes;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Bouton2CreationPersonnage extends AbstractAction {
    private String name;
    private CreationPersonnage pan;

    public Bouton2CreationPersonnage(String name, CreationPersonnage pan) {
        super("Choix");
        this.name = name;
        this.pan = pan;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (this.name){
            case "Guerrier" :
                Guerrier guerrier = new Guerrier();
                this.pan.setWarrior(guerrier);
                this.pan.personnageChoix();
                break;

            case "MaitreRune" :
                MaitreDesRunes maitreDesRunes = new MaitreDesRunes();
                this.pan.setWarrior(maitreDesRunes);
                this.pan.personnageChoix();
                break;

            case "Ensorceleuse" :
                Ensorceleuse ensorceleuse = new Ensorceleuse();
                this.pan.setWarrior(ensorceleuse);
                this.pan.personnageChoix();
                break;

            case "Alchimiste" :
                Alchimiste alchimiste = new Alchimiste();
                this.pan.setWarrior(alchimiste);
                this.pan.personnageChoix();
                break;
        }
    }
}
