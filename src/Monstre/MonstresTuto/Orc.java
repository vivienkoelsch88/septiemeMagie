package Monstre.MonstresTuto;

import Graphique.Combat;
import Monstre.Monstre;
import Personnages.Warrior;

public class Orc extends Monstre{

    public Orc() {
        super("Un Orc", 80, 20, 0, "Attaque");
    }

    public int patern(Warrior warrior){
        if(super.getNextMove() == 0){
            System.out.println("Le gobelin fonce droit devant, une charge de la dernière chance?");
            this.setAttaqueBonus(12);
            this.setDefenseBonus(-2);
            this.setNextMoveType("Distance");
        } else if (this.getNextMove() == 1){
            System.out.println("Le gobelin, cette fois, semble plus prudent, il prend de la distance avec vous,");
            System.out.println("mais prend le temps de quand même vous envoyer sa dague à la figure... Une vielle lame rouillée qui dégouline de... \"truc\"");
            this.setAttaqueBonus(6);
            this.setDefenseBonus(10);
            this.setNextMoveType("Défense");
        } else if(this.getNextMove() == 2){
            System.out.println("Le gobelin, toujours la bave aux lèvres, renverse une table sur votre chemin ");
            System.out.println("pris par surprise, vous effectuez un bond en arrière et voyez le gobelin prendre quelque chose sur l'armoire en face de vous...");
            this.setAttaqueBonus(-15);
            this.setDefenseBonus(10);
            this.setNextMoveType("Distance");
        } else if (this.getNextMove() == 3){
            System.out.println("Vous vous demandiez ce que le gobelin avait ramassé?");
            System.out.println("En tout cas, vous voyez dans sa main une étonnante sculture de marbre...");
            System.out.println("Qui a l'air de faire mal si il lui prenait l'envie de vous la lancer à la tête... Et justement...");
            this.setAttaqueBonus(20);
            this.setDefenseBonus(0);
            this.setNextMoveType("Attaque");
        }
        this.setNextMove(this.getNextMove() + 1);

        if(this.getNextMove() > 3){
            this.setNextMove(0);
        }
        if(super.isFaiblesse()){
            return this.getAttaque();
        }
        return this.getAttaque() + this.getAttaqueBonus();
    }

    @Override
    public void tourDeJeuDuMonstre(Combat combat) {

    }
}
