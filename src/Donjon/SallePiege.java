package Donjon;

import Glob.Warrior;

import java.util.Scanner;

public class SallePiege extends Salle{

    public SallePiege() {
        super("Piège");
    }

    @Override
    public void parcourir(Scanner sc, Warrior warrior) {
        System.out.println("Bon, cette salle a l'air safe, pas de monstre, pas âme qui vive en fait...");
        System.out.println("Bon ben on avance?");

        sc.hasNext();
        sc.nextLine();

        System.out.println("Au moment où vous passez la porte, allez savoir pourquoi, une des tables s'envole dans votre direction");

        if(warrior.getAdresse() > 50){
             System.out.println("Vous vous jetez à terre juste à temps pour l'esquiver mais vous êtes à peu près sûr qu'il va maintenant vous habituez à avoir moins de cheveux...");
        } else {
            System.out.println("Et forcément bon ben pan, dans la poire... Vous l'aimiez votre nez...");
            warrior.prendreDommages(15);
        }

    }
}
