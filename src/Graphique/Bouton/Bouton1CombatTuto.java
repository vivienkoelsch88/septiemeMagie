package Graphique.Bouton;

import Graphique.Tuto.Combat;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static javax.swing.text.StyleConstants.setIcon;

public class Bouton1CombatTuto extends AbstractAction {
    private String name;
    private Combat combat;


    public Bouton1CombatTuto(String texte, Combat combat){
        super(texte);
        this.name = "Carte 1";
        this.combat = combat;
    }

    public void actionPerformed(ActionEvent e) {
        this.combat.choixTechnique(0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
