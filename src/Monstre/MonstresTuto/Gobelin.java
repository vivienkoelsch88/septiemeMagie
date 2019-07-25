package Monstre.MonstresTuto;

import Graphique.Combat;
import Monstre.Monstre;
import Personnages.Warrior;

public class Gobelin extends  Monstre {
    public Gobelin() {
        super("Un gobelin", 80, 20, 0, "Attaque");
    }

    public int tourDeJeu = 1;

    public int patern(Warrior warrior) {
        if (super.getNextMove() == 0) {
            this.setMoveDesc("");
            this.setMoveDesc2("Le gobelin fonce droit devant, une charge de la dernière chance?");
            this.setMoveDesc3("");
            this.setAttaqueBonus(12);
            this.setDefenseBonus(-2);
            this.setNextMoveType("Défense");
        } else if (this.getNextMove() == 1) {
            this.setMoveDesc("Le gobelin, cette fois, semble plus prudent, il prend de la distance avec vous,");
            this.setMoveDesc2("mais prend le temps de quand même vous envoyer sa dague à la figure... Une vielle lame rouillée qui dégouline de... \"trucs\"");
            this.setMoveDesc3("");
            this.setAttaqueBonus(6);
            this.setDefenseBonus(10);
            this.setNextMoveType("Défense");
        } else if (this.getNextMove() == 2) {
            this.setMoveDesc("Le gobelin, toujours la bave aux lèvres, renverse une table sur votre chemin ");
            this.setMoveDesc2("pris par surprise, vous effectuez un bond en arrière et voyez le gobelin prendre quelque chose sur l'armoire en face de vous...");
            this.setMoveDesc3("");
            this.setAttaqueBonus(-15);
            this.setDefenseBonus(10);
            this.setNextMoveType("Distance");
        } else if (this.getNextMove() == 3) {
            this.setMoveDesc("Vous vous demandiez ce que le gobelin avait ramassé?");
            this.setMoveDesc2("En tout cas, vous voyez dans sa main une étonnante sculture de marbre...");
            this.setMoveDesc3("Qui a l'air de faire mal si il lui prenait l'envie de vous la lancer à la tête... Et justement...");
            this.setAttaqueBonus(20);
            this.setDefenseBonus(0);
            this.setNextMoveType("Attaque");
        }
        this.setNextMove(this.getNextMove() + 1);

        if (this.getNextMove() > 3) {
            this.setNextMove(0);
        }
        if (super.isFaiblesse()) {
            return this.getAttaque();
        }
        return this.getAttaque() + this.getAttaqueBonus();
    }

    @Override
    public void tourDeJeuDuMonstre(Combat combat) {
        switch (this.tourDeJeu) {
            case 1:
                combat.setMessage("Le gobelin fonce droit devant, une charge de la dernière chance?");
                combat.deplacerMonstre(2);
                combat.getWarrior().prendreDommages(20);
                this.tourDeJeu++;
                super.setNextMoveType("défense");
                break;

            case 2:
                combat.setMessage("Le gobelin, cette fois, semble plus prudent, il prend de la distance avec vous mais prend le temps de quand même vous envoyer sa dague à la figure...");
                combat.deplacerMonstre(-1);
                combat.getWarrior().prendreDommages(20);
                this.tourDeJeu++;
                super.setNextMoveType("défense");
                break;

            case 3:
                combat.setMessage("Le gobelin, toujours la bave aux lèvres, renverse une table sur votre chemin et voyez le gobelin prendre quelque chose sur l'armoire en face de vous...");
                super.setDefenseBonus(12);
                this.tourDeJeu++;
                super.setNextMoveType("distance");
                break;

            case 4:
                combat.setMessage("Vous vous demandiez ce que le gobelin avait ramassé? Une étonnante sculture de marbre qui a l'air de faire mal si il lui prenait l'envie de vous la lancer à la tête...");
                super.setDefenseBonus(12);
                this.tourDeJeu = 1;
                super.setNextMoveType("attaque");
                break;
        }
    }
}
