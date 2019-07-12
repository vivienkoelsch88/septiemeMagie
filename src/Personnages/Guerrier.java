package Personnages;

import CartesGuerrier.ArtMartiaux;
import CartesGuerrier.Techniques;

import java.util.ArrayList;
import java.util.Scanner;

public class Guerrier extends Warrior {
    private int endurance;
    private ArrayList<ArtMartiaux> artsLearned = new ArrayList<>();

    public Guerrier() {
        super(50, 18, 6);
        this.endurance = 100;

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

    public ArrayList<ArtMartiaux> getArtsLearned() {
        return artsLearned;
    }

    public void setArtsLearned(ArtMartiaux artsLearned) {
        this.artsLearned.add(artsLearned);
    }

    public void perteEndurance(int perte){
        this.endurance = this.endurance - perte;
        if(this.endurance < 0){
            super.setLife(super.getLife() + this.endurance);
        }
    }


}
