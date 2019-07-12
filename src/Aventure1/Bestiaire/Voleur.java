package Aventure1.Bestiaire;

import Personnages.Warrior;
import Monstre.Monstre;

public class Voleur extends Monstre {
    public Voleur() {
        super("Voleur", 40, 17, 6, "Attaque");
    }

    @Override
    public int patern(Warrior warrior) {
        if(super.getNextMove() == 0){
            System.out.println("Le voleur vous jette une sorte de poudre bleue au visage, la suite est violente...");
            this.setAttaqueBonus(20);
            this.setDefenseBonus(10);
            this.setNextMoveType("Défense");

        } else if (this.getNextMove() == 1){
            System.out.println("Le voleur profite de votre aveuglement pour se placer dans votre dos, attention");
            if(warrior.getAdresse() < 50) {
                this.setAttaqueBonus(5);
                this.setDefenseBonus(30);
            } else {
                this.setAttaqueBonus(5);
                this.setDefenseBonus(5);
                warrior.setFaiblesse(true);
            }
            this.setNextMoveType("Défense");

        } else if(this.getNextMove() == 2){
            System.out.println("Ca alors quelle agilité!" + "\n" +
                    "Il virevolte dans tout les sens... ça tient en forme de voler...");
            this.setAttaqueBonus(-5);
            this.setDefenseBonus(20);
            this.setNextMoveType("Distance");
        } else if (this.getNextMove() == 3){
            System.out.println("Au moment où il s'apprête de bondir dans tous les sens," + "\n" +
                    "Vous en profitez pour lui foncer dessus mais... il vous stop d'une pierre lancée dans votre direction");
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
}
