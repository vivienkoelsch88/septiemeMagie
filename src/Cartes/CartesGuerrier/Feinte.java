package Cartes.CartesGuerrier;

import Personnages.Warrior;

public class Feinte extends Techniques{
    public Feinte() {
        super();
        super.setName("Feinte");
        super.setCout(5);
        super.setDesc("Attaque invest X 4 contre une défense, sinon, défense - invest");
        super.setLevel(1);
        super.setType("Attaque");
    }

    @Override
    public void utilisation(Warrior guerrier, int invest) {
        System.out.println("J'attaque de gauche à droite... ou pas :p");
        if(guerrier.getMonstre().getNextMoveType().equals("Défense")){
            guerrier.setAttaqueBonus(invest * 4);
        } else {
            guerrier.setDefenseBonus(invest * -1);
        }
        guerrier.perteRessource(invest);
    }

    @Override
    public void effetFinDeTour(Warrior warrior) {

    }
    @Override
    public String getMoveDesc() {
        return null;
    }

    @Override
    public String getMoveDesc2() {
        return null;
    }

    @Override
    public String getMoveDesc3() {
        return null;
    }
}
