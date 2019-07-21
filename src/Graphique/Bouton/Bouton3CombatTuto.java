package Graphique.Bouton;

import Graphique.Tuto.CombatTuto;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Bouton3CombatTuto extends AbstractAction {
    private String name;
    private CombatTuto combatTuto;

    public Bouton3CombatTuto(String texte, CombatTuto combatTuto){
        super(texte);
        this.name = "Carte 3";
        this.combatTuto = combatTuto;
    }

    public void actionPerformed(ActionEvent e) {
        this.combatTuto.choixTechnique(2);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
