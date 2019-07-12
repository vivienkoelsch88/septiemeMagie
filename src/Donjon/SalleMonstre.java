package Donjon;

import Combat.CombatSimple;
import Personnages.Warrior;
import Monstre.Monstre;
import Monstre.Orc;

import java.util.Scanner;

public class SalleMonstre extends  Salle{
    private Monstre monstre;

    public SalleMonstre() {
        super("Monstre");
    }

    private void generateMonstre(){
        int random = (int)(Math.random() * 1);
        if(random == 0) {
            this.monstre = new Orc();
        }
    }

    @Override
    public void parcourir(Scanner sc, Warrior warrior) {
        System.out.println("Vous arrivez dans une salle, hum... qui pue...");
        generateMonstre();
        warrior.setMonstre(this.monstre);
        CombatSimple combatSimple = new CombatSimple();
        combatSimple.combattre(sc, warrior, monstre);
    }
}
