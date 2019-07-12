package Combat;

import CartesGuerrier.Techniques;
import Personnages.Warrior;
import Monstre.Monstre;

import java.util.ArrayList;
import java.util.Scanner;

public class CombatSimple extends Combat{

    public void combattre(Scanner sc, Warrior warrior, Monstre monstre) {
        ArrayList<Techniques> main = new ArrayList<>();
        System.out.println(monstre.getName() + " vous fait face...");

//        ************** Main de départ ***************************
        for (int i = 0; i < warrior.getConcentration() / 10; i++) {
            if (i < warrior.getDeck().size()) {
                int random = (int) (Math.random() * (warrior.getDeck().size() - 1));
                if (main.contains(warrior.getDeck().get(random))) {
                    i--;
                } else {
                    main.add(warrior.getDeck().get(random));
                }
            }
        }

        while (monstre.getLife() > 0 && warrior.getLife() > 0) {
//            ************* Pioche si nécessaire **********************
            if (warrior.getPioche() > 0) {
                for (int i = 0; i < warrior.getPioche(); i++) {
                    int random = (int) (Math.random() * (warrior.getDeck().size()));
                    if (main.contains(warrior.getDeck().get(random))) {
                        i--;
                    } else {
                        main.add(warrior.getDeck().get(random));
                    }
                }
                warrior.setPioche(0);
            }


            System.out.println("Liste de vos attaques : ");
            System.out.println("===================================================");
            int id = 1;
            int invest;
            int choix;
            for (Techniques techniques : main) {
                System.out.println(id + " : " + techniques.getName());
                id++;
            }
            System.out.println("===================================================");

            System.out.println("Alors? Laquelle on choisis?");
            boolean ok = false;
            choix = 0;
            while (!ok) {
                try {
                    choix = sc.nextInt();
                    if (choix <= main.size() && choix > 0) {
                        ok = true;
                    } else {
                        System.out.println("c'est pas une technique ça...");
                    }
                } catch (java.util.InputMismatchException e) {
                } finally {
                    sc.nextLine();
                }
            }

            System.out.println("Et on investie combien?");
            ok = false;
            invest = 0;
            while (!ok) {
                try {
                    invest = sc.nextInt();
                    if (invest <= main.get(choix - 1).getLevel() * 10) {
                        ok = true;
                    } else {
                        System.out.println("Et non, cette technique est de niveau " + main.get(choix - 1).getLevel());
                    }
                } catch (java.util.InputMismatchException e) {
                } finally {
                    sc.nextLine();
                }
            }

            main.get(choix - 1).utilisation(warrior, invest);
            if (warrior.getAttaqueBonus() + warrior.getAttaque() > 0 && warrior.getLife() > 0) {
                if (warrior.isFaiblesse()) {
                    monstre.prendreDommages(warrior.getAttaque());
                } else {
                    monstre.prendreDommages(warrior.getAttaqueBonus() + warrior.getAttaque());
                }
            }

            if (monstre.getLife() > 0 && warrior.getLife() > 0) {
                monstre.resetBonus();
                warrior.prendreDommages(monstre.patern(warrior));
            }

//            ************** Fin de tour **************************
            for (Techniques techniques : warrior.getEffetFinDeTour()) {
                techniques.effetFinDeTour(sc, warrior);
            }
            warrior.resetBonus();
        }
        if (warrior.getLife() > 0) {
            System.out.println("Et voilà! votre dernière attaque achève votre adversaire!");
        }
    }
}
