package Glob;

import CartesGuerrier.*;
import CartesGuerrier.ArtMartiaux;
import CartesGuerrier.Attaque;
import CartesGuerrier.Techniques;
import Graphique.Fenetre;
import Personnages.Warrior;

import java.util.ArrayList;
import java.util.Scanner;

public class RunGame{


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Fenetre fen = new Fenetre();

        BattleGlo battle = new BattleGlo();

        fen.tuto();
//        premierPas(sc, battle, fen);
//
//
//        System.out.println("=========================================================");
//        System.out.println(" ");
//
//        Donjon donjon = new Donjon(10);
//        donjon.parcourire(sc, battle.getPlayer());
//
//        System.out.println("=========================================================");
//        System.out.println(" ");
//
//        System.out.println("Pas facile hein? Fait pas genre, j'ai testé des 10ène de fois je n'ai jamais réussi");
//        System.out.println("On va essayer d'améliorer le deck ok?");
//
//        ameliorerDeck(sc, battle.getPlayer());
//
//        System.out.println("=========================================================");
//        System.out.println(" ");
//
//        System.out.println("Bon on a assez bidouiller, essayons d'entamer une aventure basique...");
//        Aventure aventure = new Aventure();
//        aventure.debutDeLAventure(sc, battle.getPlayer());

    }

    private static int techChoice(Scanner sc, BattleGlo battle) {
        int id = 1;
        System.out.println();
        System.out.println("================== Liste techniques ==================");
        for (ArtMartiaux arts : battle.getPlayer().getArts()) {
            System.out.println(id + " : " + arts.getName());
            id++;
        }
        System.out.println("=======================================================");
        int choice = 0;
        boolean ok = false;

        while (!ok) {
            try {
                choice = sc.nextInt();
                if(choice == 1 || choice == 2){
                    ok = true;
                } else {
                    System.out.println("Euh... 1 ou 2, pas d'autre choix");
                }
            } catch (java.util.InputMismatchException e){
                System.out.println("Euh... 1 ou 2, pas d'autre choix");
            } finally {
                sc.nextLine();
            }
        }


            return choice;

    }

    private static void premierPas(Scanner sc, BattleGlo battle, Fenetre fen){

        int choice = techChoice(sc, battle);

        battle.getPlayer().setArtsLearned(new ArtMartiaux(choice));

        System.out.println("Parfait, vous avez choisis " + battle.getPlayer().getArtsLearned().get(0).getName() + ", " + battle.getPlayer().getArtsLearned().get(0).getDesc());

        System.out.println("Bon, on va essayer de l'utiliser");

//        **************************** Première attaque *********************************
        premiereAttaque(sc, battle);
        sc.hasNext();
        sc.nextLine();

//        ***************************** Plus de techniques ******************************

        System.out.println(("Bon, on va étoffer un peu votre arsenal,"));
        plusDeChoix(sc, battle);
        sc.hasNext();
        sc.nextLine();

//        ******************************* Premier combat ********************************

        System.out.println("Bon, on test ça?");
        battle.getPlayer().setAdversaires(new Adversaire());
        battle.battle(sc);
        sc.hasNext();
        sc.nextLine();

//        ********************************* Création de personnage *********************

        System.out.println("Bon, ça c'est fait, mais c'est un peu simpliste je trouve");
        System.out.println("Et si on construisait maintenant votre personnage de façon plus complète?");
        sc.hasNext();
        sc.nextLine();
        creationDuPersonnageFinal(sc, battle);
        sc.hasNext();
        sc.nextLine();

//        ************************************* Création du deck ************************

        System.out.println(" ");
        System.out.println("Ca avance, maintenant nous allons un peu étoffer vos techniques de combat");
        System.out.println("L'idée est simple, vous possédez 3 techniques, stockées sous forme de carte dans votre deck");
        System.out.println("A celles-ci j'ajoute 7 cartes d'attaque de base, qui ne modifient pas vos statistiques");

        for(int i = 0; i < 7; i++) {
            battle.getPlayer().setCarte(new Attaque());
        }

        System.out.println("Au début du combat vous piochez un nombre de carte égal à votre charisme divisé par 10");
        System.out.println("C'est tout, bon courage...");
        battle.getPlayer().setAdversaires(new Adversaire());
        battle.battle(sc);
    }



    private static void premiereAttaque(Scanner sc, BattleGlo battle){
        System.out.println("Bon, le principe est simple, chaque technique demande un investissement pour être utilisée");
        System.out.println("Les arts martiaux demandent un investissement en endurance, vous pouvez investir jusqu'à 10 fois le level de la technique");
        System.out.println("Les guerrier possèdent " + battle.getPlayer().getEndurance() + " points d'endurance");

        System.out.println("On fait un essai? Combien investissez vous de point d'endurance?");
        boolean verif = false;
        int choix = 0;
        while (!verif){
            boolean ok = false;

            while (!ok) {
                try {
                    choix = sc.nextInt();
                    if(choix < 11 && choix >= 0){
                        ok = true;
                    } else {
                        System.out.println("Euh... de 1 à 10, la technique est de niveau 1");
                    }
                } catch (java.util.InputMismatchException e){
                    System.out.println("Euh... de 1 à 10, la technique est de niveau 1");
                } finally {
                    sc.nextLine();
                }
            }
                verif = true;
                System.out.println("Alors on investie " + choix + "points dedans");
                System.out.println(battle.getPlayer().getArtsLearned().get(0).getName() + " modifie votre attaque et votre défense,");

                battle.getPlayer().getArtsLearned().get(0).utilisation(battle.getPlayer(), choix);

                System.out.println("Elles passent de : " + battle.getPlayer().getAttaque() + " et " + battle.getPlayer().getDefense() + " à "
                        + (battle.getPlayer().getAttaque() + battle.getPlayer().getAttaqueBonus()) + " et " + (battle.getPlayer().getDefense() + battle.getPlayer().getDefenseBonus()));
                System.out.println("Pratique non?");

        }
    }

    private static void plusDeChoix(Scanner sc, BattleGlo battle){
        battle.getPlayer().setArtsLearned(new ArtMartiaux(3));
        battle.getPlayer().setArtsLearned(new ArtMartiaux(4));

        System.out.println("Voilà 2 nouvelles techniques :");
        int id = 0;
        for (ArtMartiaux arts : battle.getPlayer().getArtsLearned()) {
            if(id > 0) {
                System.out.println(arts.getName());
                System.out.println(arts.getDesc());
            }
            id++;
        }
    }

    private static void creationDuPersonnageFinal(Scanner sc, BattleGlo battle){
        int ptnDistr = 100;
        boolean verif = false;
        System.out.println("Bon, il existe 4 autres attributs dont nous n'avons pas encore parlé");
        System.out.println("la concentration, la force, l'adresse et le charisme;");
        System.out.println("Nous partirons du principe que vous voyez à peu prés à quoi ils correspondent");
        System.out.println("Pour votre premier personnage nous n'allons pas rentrer dans les détails");
        System.out.println("Nous allons distribuer des points dans ces différents attributs, soit, 200 en tout");
        System.out.println("Mais chacun de ces attributs commencent à 25, reste donc 100 points à distribuer");

        System.out.println("C'est partis, combien en force? En plus des 25 de base?");
        int choix;
        boolean ok = false;
        while (!ok) {
            try {
                choix = sc.nextInt();
                if(choix <= ptnDistr && choix >= 0){
                    System.out.println("Plus 25 donc, ça nous donne une force de : " + (25 +choix));
                    battle.getPlayer().setForce(25 + choix);
                    ptnDistr = ptnDistr - choix;
                    ok = true;
                } else {
                    System.out.println("Non, un nombre de 0 à " + ptnDistr + " à distribuer");
                }
            } catch (java.util.InputMismatchException e){
            } finally {
                sc.nextLine();
            }
        }

        System.out.println("Bon, maintenant combien en adresse?");
        ok = false;
        while (!ok) {
            try {
                choix = sc.nextInt();
                if(choix <= ptnDistr){
                    System.out.println("Plus 25 donc, ça nous donne une adresse de : " + (25 +choix));
                    battle.getPlayer().setAdresse(25 + choix);
                    ptnDistr = ptnDistr - choix;
                    ok = true;
                } else {
                    System.out.println("Vous ne possédez que " + ptnDistr + " à distribuer");
                }
            } catch (java.util.InputMismatchException e){
            } finally {
                sc.nextLine();
            }
        }

        System.out.println("En concentration?");
        ok = false;
        while (!ok) {
            try {
                choix = sc.nextInt();
                if(choix <= ptnDistr){
                    System.out.println("Plus 25 donc, ça nous donne une concentration de : " + (25 +choix));
                    battle.getPlayer().setConcentration(25 + choix);
                    ptnDistr = ptnDistr - choix;
                    ok = true;
                } else {
                    System.out.println("Vous ne possédez que " + ptnDistr + " à distribuer");
                }
            } catch (java.util.InputMismatchException e){
            } finally {
                sc.nextLine();
            }
        }

        System.out.println("Et du coup, il reste " + (25 +ptnDistr) + " points pour le charisme");
        battle.getPlayer().setCharisme(25 + ptnDistr);
        System.out.println("Oui je sais, mais c'est une première version donc pas le droit à l'erreur");

        System.out.println("Voilà à quoi ressemble votre personnage : ");
        battle.getPlayer().showPerso();
    }

    private static void ameliorerDeck(Scanner sc, Warrior warrior){
        warrior.setDeck(new ArrayList<>());
        System.out.println();
        sc.hasNext();
        sc.nextLine();

        System.out.println("Aller on vide ce deck et on ve le remplir de carte plus intéressantes");
        for (int i = 0; i <5; i++){
            if(i == 0) {
                Techniques techniques = new BriseCoude();
                warrior.ajouterCarte(techniques);
            } else if (i == 1){
                Techniques techniques = new ChangementDePosition();
                warrior.ajouterCarte(techniques);
            } else if (i == 2){
                Techniques techniques = new Feinte();
                warrior.ajouterCarte(techniques);
            } else if (i == 3){
                Techniques techniques = new OuvreGarde();
                warrior.ajouterCarte(techniques);
            } else if (i == 4){
                Techniques techniques = new TransBerserk();
                warrior.ajouterCarte(techniques);
            }
        }

        System.out.println("Et voici ton nouveau deck : ");
        System.out.println("________________________");
        for(int i = 0; i <5; i++){
            System.out.println("|  " + warrior.getDeck().get(i).getName());
            System.out.println("|  " + warrior.getDeck().get(i).getDesc());
            System.out.println("|");
        }
    }


}
