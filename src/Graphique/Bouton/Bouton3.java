package Graphique.Bouton;

import Graphique.Combat;
import Graphique.Fenetre;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Bouton3 extends AbstractAction {
    private String name;
    private Combat combat;

    public Bouton3(String texte, Combat combat){
        super(texte);
        this.name = "Carte 3";
        this.combat = combat;
    }

    public void actionPerformed(ActionEvent e) {
        this.combat.choixTechnique(2);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
