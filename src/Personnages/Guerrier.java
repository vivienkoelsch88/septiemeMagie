package Personnages;

import CartesGuerrier.ArtMartiaux;
import CartesGuerrier.Techniques;

import java.util.ArrayList;
import java.util.Scanner;

public class Guerrier extends Warrior {
    private int endurance;
    private ArrayList<ArtMartiaux> arts;
    private ArrayList<ArtMartiaux> artsLearned = new ArrayList<>();

    public Guerrier() {
        super(50, 18, 6);
        this.endurance = 100;
        this.arts = new ArrayList<>();
        this.arts.add(new ArtMartiaux(1));
        this.arts.add(new ArtMartiaux(2));

    }

    @Override
    public ArrayList<Techniques> getDeck() {
        ArrayList<Techniques> deck = super.listCarte();

        deck.addAll(artsLearned);

        return deck;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public ArrayList<ArtMartiaux> getArts() {
        return arts;
    }

    public void setArts(ArrayList<ArtMartiaux> arts) {
        this.arts = arts;
    }

    public ArrayList<ArtMartiaux> getArtsLearned() {
        return artsLearned;
    }

    public void setArtsLearned(ArtMartiaux artsLearned) {
        this.artsLearned.add(artsLearned);
    }

    public void perteEndurance(int perte){
        this.endurance = this.endurance - perte;
        if(this.endurance < 0){
            System.out.println("Hélas votre endurance est trop basse, vous perdez à la place des points de vie");
            super.setLife(super.getLife() + this.endurance);
        }
    }

    public void showPerso() {
        System.out.println(
                " ______________________" + "\n"+
                "|  FORCE : " + super.getForce() + "\n"+
                "|  ADRESSE : " + super.getAdresse() + "\n"+
                "|  CONCENTRATION : " + super.getConcentration() + "\n"+
                "|  CHARISME : " + super.getCharisme() + "\n"+
                "|  ENDURANCE : " + endurance + "\n"+
                "|" + "\n"+
                "|    VIE : " + super.getLife() + "\n"+
                "|  Attaque : " + super.getAttaque() + "  Défense : " + super.getDefense() + "\n"+
                "|");

    }

    @Override
    public void combatre(Scanner sc) {
        ArrayList<Techniques> main  = new ArrayList<>();
        System.out.println(this.getMonstre().getName() + " vous fait face...");

//        ************** Main de départ ***************************
        for(int i = 0; i < this.getConcentration()/10; i++) {
            if(i < this.getDeck().size()) {
                int random = (int) (Math.random() * (this.getDeck().size() -1 ));
                if(main.contains(this.getDeck().get(random) )){
                    i--;
                } else {
                    main.add(this.getDeck().get(random));
                }
            }
        }

        while (this.getMonstre().getLife() > 0 && this.getLife() > 0) {
//            ************* Pioche si nécessaire **********************
            if(this.getPioche() > 0){
                for(int i = 0; i < this.getPioche(); i++) {
                    int random = (int) (Math.random() * (this.getDeck().size()));
                    if(main.contains(this.getDeck().get(random) )){
                        i--;
                    } else {
                        main.add(this.getDeck().get(random));
                    }
                }
                this.setPioche(0);
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
                    if(choix <= main.size() && choix > 0){
                        ok = true;
                    } else {
                        System.out.println("c'est pas une technique ça...");
                    }
                } catch (java.util.InputMismatchException e){
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
                    if(invest <= main.get(choix - 1).getLevel() * 10){
                        ok = true;
                    } else {
                        System.out.println("Et non, cette technique est de niveau " + main.get(choix - 1).getLevel());
                    }
                } catch (java.util.InputMismatchException e){
                } finally {
                    sc.nextLine();
                }
            }

            main.get(choix - 1).utilisation(this, invest);
            if (this.getAttaqueBonus() + this.getAttaque() > 0 && this.getLife() > 0) {
                if(this.isFaiblesse()){
                    this.getMonstre().prendreDommages(this.getAttaque());
                } else {
                    this.getMonstre().prendreDommages(this.getAttaqueBonus() + this.getAttaque());
                }
            }

            if(this.getMonstre().getLife() > 0 && this.getLife() > 0) {
                this.getMonstre().resetBonus();
                this.prendreDommages(this.getMonstre().patern(this));
            }

//            ************** Fin de tour **************************
            for (Techniques techniques : this.getEffetFinDeTour()) {
                techniques.effetFinDeTour(sc, this);
            }
            this.resetBonus();
        }
        if(this.getLife() > 0){
            System.out.println("Et voilà! votre dernière attaque achève votre adversaire!");
        }


    }
}
