package Graphique.Bouton;

import Graphique.Tuto.CombatTuto;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Bouton1CombatTuto extends AbstractAction {
    private String name;
    private CombatTuto combatTuto;


    public Bouton1CombatTuto(String texte, CombatTuto combatTuto){
        super(texte);
        this.name = "Carte 1";
        this.combatTuto = combatTuto;
    }

    public void actionPerformed(ActionEvent e) {
        this.combatTuto.choixTechnique(0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
