package Aventure1;

import Glob.Warrior;

import java.util.Scanner;

public class Aventure {

    public void debutDeLAventure(Scanner sc, Warrior warrior){
        warrior.resetBonus();
        warrior.setEndurance(100);
        warrior.setLife(50);
        warrior.setAttaque(20);

        System.out.println("==============================================================");
        System.out.println(" ");

        System.out.println("Depuis que Bérénice vous a confié cet artefact, il vous est arrivé pas mal de bricoles," + "\n" +
                "votre cheval qui se met à boiter, votre manteau déchiré, vos 4 compagnons de voyage morts lors d'une attaque de brigants..." + "\n" +
                "Mais bon, tout voyage entraîne son lot de désagréments");

        System.out.println(" ");

        System.out.println("Mais bon, nous y voilà, après un joli voyage de 4 mois, vous voilà arrivé à Goldgate," + "\n" +
                "Et vous avez même 1h d'avance, si ça c'est pas bien calculé! On visite?");
        System.out.println(" ");

        VilleDeGoldgate goldgate = new VilleDeGoldgate();
        goldgate.lieux(sc, warrior);
    }


}
