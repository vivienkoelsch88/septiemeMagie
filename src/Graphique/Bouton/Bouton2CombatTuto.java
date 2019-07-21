package Graphique.Bouton;

import Graphique.Tuto.CombatTuto;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Bouton2CombatTuto extends AbstractAction {
    private String name;
    private CombatTuto combatTuto;

    public Bouton2CombatTuto(String texte, CombatTuto combatTuto){
        super(texte);
        this.name = "Carte 2";
        this.combatTuto = combatTuto;
    }

    public void actionPerformed(ActionEvent e) {
        this.combatTuto.choixTechnique(1);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
