package Aventure1;

import Aventure1.Bestiaire.Voleur;
import Combat.CombatSimple;
import Glob.Warrior;

import java.util.Scanner;

public class VilleDeGoldgate {
    private int horaire = 18;
    private boolean aubergeVisite = false;
    private boolean aubergiste = false;

    private boolean marcherVisite = false;
    private boolean vole = false;

    private boolean egliseVisite = false;
    private boolean placeVisite = false;

    public void lieux(Scanner sc, Warrior warrior){
        if(horaire == 20){
            auberge(sc,warrior);
        }
        System.out.println("___________________________" + "\n" +
                "| 1 : Auberge" +"\n" +
                "| 2 : Marché" +"\n" +
                "| 3 : Eglise" +"\n" +
                "| 4 : Grande place" + "\n" +
                " ");

        System.out.println("Bon, on va où? il est " + horaire + "h");
        boolean ok = false;
        int choix = 0;
        while (!ok) {
            try {
                choix = sc.nextInt();
                if(choix < 5 && choix > 0){
                    ok = true;
                } else {
                    System.out.println("Le GPS ne connait pas cet endroit");
                }
            } catch (java.util.InputMismatchException e){
            } finally {
                sc.nextLine();
            }
        }
        if(choix == 1){
            auberge(sc, warrior);
        } else if (choix == 2){
            marcher(sc, warrior);
        }  else if (choix == 3){
            eglise(sc, warrior);
        }
//        else if (choix == 4){
//            grandePlace(sc, warrior);
//        }
    }

//    *************************************************************************************************

    private void auberge(Scanner sc, Warrior warrior){
        if(horaire == 20){

            //            *********** Ici le code du rencard **************************

        }
        if(!this.aubergeVisite){
            this.aubergeVisite = true;
            System.out.println("Vous entrez dans une petite taverne, vous êtes peut-être un peu trop... C'est beaucoup trop propre ici!" +  "\n" +
                    "Vous regardez votre montre, vous êtes encore un peu en avance, le temps d'une bière");
            sc.hasNext();
            sc.nextLine();

            System.out.println("==========================================================");
            if(warrior.getCharisme() > 50){
                System.out.println("Vous bavardez un peu avec le tavernier, il maudit sa petite vie tranquile mais dans l'ensemble il a l'air gentil" +  "\n" +
                        "vous ne pouvez néanmoins vous attarder, mais vous sentez que vous allez vous plaire ici");
                this.aubergiste = true;
            } else {
                System.out.println("Bon, mais comme dans toute auberge qui se respecte, ça dégénère..." + "\n" +
                        "Vous restez de votre côté mais une bouteille vole...");
                warrior.prendreDommages(12);
            }

            System.out.println("Mouais... Il est temps de partir...");
            this.horaire++;
            lieux(sc, warrior);


        } else {

//            *************************************

        }
    }

    private void marcher(Scanner sc, Warrior warrior) {
        if (!this.marcherVisite) {
            this.marcherVisite = true;
            System.out.println("Vous vous promettez intérieurement de ne pas céder aux achats impulsifs" + "\n" +
                    "bon, mais quand même, c'est bon le pain au marron..." + "\n" +
                    "et puis il faudrait changer mes bottes..." + "\n" +
                    "et cette dague est simpa..." +  "\n" +
                    "et puis aussi...");
            sc.hasNext();
            sc.nextLine();

            if(warrior.getConcentration() > 50){
                System.out.println("Vite fuyons!");
            } else {
                System.out.println("Bon, vous vous attardez un peu, pas beaucoup, pas trop..." + "\n" +
                        "juste assez pour vous rendre compte qu'un gamin vient de vous voler votre bourse");

                System.out.println("investir de l'endurance pour le rattraper?");

                int choice = 0;
                boolean ok = false;

                while (!ok) {
                    try {
                        choice = sc.nextInt();
                        if(choice < warrior.getEndurance()){
                            ok = true;
                        } else {
                            System.out.println("Pas assez d'endurance, il vous reste " + warrior.getEndurance() + " points");
                        }
                    } catch (java.util.InputMismatchException e){
                    } finally {
                        sc.nextLine();
                    }
                }

                if(choice > 0 && (choice + warrior.getEndurance()) > 100){
                    System.out.println("Aha! vous lui mettez la main dessus!" + "\n" +
                            "A lui et à... sûrement son TRES grand frère...");
                    Voleur voleur = new Voleur();
                    warrior.setMonstre(voleur);
                    CombatSimple combatSimple = new CombatSimple();
                    combatSimple.combattre(sc, warrior, voleur);
                    System.out.println("==================================================");
                    System.out.println("Une bonne chose de faite!" + "\n" +
                            "allez, pas besoin de s'attarder plus...");
                } else {
                    System.out.println("Bon, vous ne le rattraperez pas");
                    vole = true;
                }
            }

            this.horaire++;
            lieux(sc, warrior);


        } else {
//***********************************************************
        }
    }

    private void eglise(Scanner sc, Warrior warrior){
        if (!this.egliseVisite) {
            this.egliseVisite = true;


        } else {
//            ******************************************
        }
    }
}
