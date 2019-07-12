package Glob;

import CartesGuerrier.Techniques;
import Personnages.Guerrier;
import Personnages.Warrior;

import java.util.ArrayList;
import java.util.Scanner;

public class BattleGlo {
//    Attributs
    private Warrior player;
//    *************************** Choix de mettre la main là pour ajouter de la difficulté *******************
    private ArrayList<Techniques> main;
//    Constructeurs

    public BattleGlo( ) {
        this.player = createPlayer();
    }


//    Méthodes

    public void battle(Scanner sc){
        main  = new ArrayList<>();
        System.out.println(player.getAdversaires().getName() + " vous fait face...");

//        ************** Main de départ ***************************
        for(int i = 0; i < player.getConcentration()/10; i++) {
            if(i < player.getDeck().size()) {
                int random = (int) (Math.random() * (player.getDeck().size() -1 ));
                if(main.contains(player.getDeck().get(random) )){
                    i--;
                } else {
                    main.add(player.getDeck().get(random));
                }
            }
        }

        while (player.getAdversaires().getLife() > 0 && player.getLife() > 0) {
//            ************* Pioche si nécessaire **********************
            if(player.getPioche() > 0){
                for(int i = 0; i < player.getPioche(); i++) {
                    int random = (int) (Math.random() * (player.getDeck().size()));
                    if(main.contains(player.getDeck().get(random) )){
                        i--;
                    } else {
                        main.add(player.getDeck().get(random));
                    }
                }
                player.setPioche(0);
            }


            System.out.println("Liste de vos attaques : ");
            int id = 1;
            int invest;
            int choix;
            for (Techniques techniques : main) {
                System.out.println(id + " : " + techniques.getName());
                id++;
            }

            System.out.println("Alors? Laquelle on choisis?");

            boolean ok = false;
            choix = 0;
            while (!ok) {
                try {
                    choix = sc.nextInt();
                    if(choix <= main.size() && choix > 0){
                        ok = true;
                    } else {
                        System.out.println("C'est pas une technique ça?");
                    }
                } catch (java.util.InputMismatchException e){

                } finally {
                    sc.nextLine();
                }
            }

            System.out.println("Et on investie combien?");

            invest = 0;
            ok = false;
            while (!ok) {
                try {
                    invest = sc.nextInt();
                    if(invest < 11){
                        ok = true;
                    } else {
                        System.out.println("Et non, la technique est niveau 1, tu ne peux investir qu'au max 10 points");
                    }
                } catch (java.util.InputMismatchException e){

                } finally {
                    sc.nextLine();
                }
            }


            main.get(choix - 1).utilisation(player, invest);
            if (player.getAttaqueBonus() + player.getAttaque() > 0 && player.getLife() > 0) {
                player.getAdversaires().prendreDommages(player.getAttaqueBonus() + player.getAttaque());
            }

            if(player.getAdversaires().getLife() > 0 && player.getLife() > 0) {
                player.prendreDommages(player.getAdversaires().patern());

                player.getAdversaires().resetBonus();
            }

//            ************** Fin de tour **************************

                for (Techniques techniques : player.getEffetFinDeTour()) {
                    techniques.effetFinDeTour(sc, player);
                }

            player.resetBonus();
        }
        if(player.getLife() > 0){
            System.out.println("Et voilà! votre dernière attaque achève votre adversaire!");
        }


    }

    public Warrior getPlayer() {
        return player;
    }

    public void setPlayer(Warrior player) {
        this.player = player;
    }

    private Warrior createPlayer(){

        return new Guerrier();
    }
}
