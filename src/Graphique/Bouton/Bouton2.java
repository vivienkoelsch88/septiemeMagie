package Graphique.Bouton;

import Graphique.Combat;
import Graphique.Fenetre;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Bouton2 extends AbstractAction {
    private String name;
    private Combat combat;

    public Bouton2(String texte, Combat combat){
        super(texte);
        this.name = "Carte 2";
        this.combat = combat;
    }

    public void actionPerformed(ActionEvent e) {
        this.combat.choixTechnique(1);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
