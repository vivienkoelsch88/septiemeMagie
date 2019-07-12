package Donjon;

import Personnages.Warrior;

import java.util.Scanner;

public class SalleVide extends Salle{

    public SalleVide() {
        super("Vide");
    }

    @Override
    public void parcourir(Scanner sc, Warrior warrior) {
        System.out.println("Vous arrivez dans une grande salle lugubre... Cela ne vous dit rien qui vaille...");
        sc.hasNext();
        sc.nextLine();
        System.out.println("Mais non ça roule, allez, dépêche toi!");
    }
}
