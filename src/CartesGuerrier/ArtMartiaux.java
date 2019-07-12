package CartesGuerrier;

import CartesGuerrier.Techniques;
import Personnages.Warrior;

import java.util.Scanner;

public class ArtMartiaux extends Techniques {
    private String MoveDesc = "";
    private String MoveDesc2 = "";
    private String MoveDesc3 = "";



    public ArtMartiaux(int choixTec) {
        super();
        if(choixTec == 1){
            super.setName("Attaque furieuse");
            super.setCout(5);
            super.setDesc("une attaque puissante, mais au détriment de vos points de vie...");
            super.setLevel(1);
            super.setType("Attaque");

        } else if (choixTec == 2){
            super.setName("Attaque prudente");
            super.setCout(5);
            super.setDesc("une attaque un peu moins puissante mais qui vous expose moins");
            super.setLevel(1);
            super.setType("Attaque");

        } else if (choixTec == 3){
            super.setName("Riposte");
            super.setCout(5);
            super.setDesc("une attaque puissante si l'adversaire comptait vous attaquer ce tour... Sinon moins");
            super.setLevel(1);
            super.setType("Attaque");

        } else if (choixTec == 4) {
            super.setName("Esquive");
            super.setCout(5);
            super.setDesc("Se concentrer sur l'esquive, sans penser à frapper... Parfois ça sauve la vie...");
            super.setLevel(1);
            super.setType("Défense");

        } else if (choixTec == 5){
            super.setName("Esquive");
            super.setCout(5);
            super.setDesc("Se concentrer sur l'esquive, sans penser à frapper... Parfois ça sauve la vie...");
            super.setLevel(1);
            super.setType("Défense");
        }

    }

    public void utilisation (Warrior guerrier, int invest){

        if(super.getName().equals("Attaque furieuse")){
            attaqueFurieuse(guerrier, invest);

        } else if (super.getName().equals("Attaque prudente")){
            attaquePrudente(guerrier, invest);

        } else if (super.getName().equals("Riposte")){
            riposte(guerrier, invest);

        }else if (super.getName().equals("Esquive")){
            esquive(guerrier, invest);

        }


    }
//    ******************************************************************************************************
    private void attaqueFurieuse(Warrior guerrier, int invest){
        System.out.println("Vous vous ruez donc sur votre adversaire, les yeux rouges et une envie de meurtre dans les yeux...");
        this.MoveDesc2 = "Vous vous ruez donc sur votre adversaire, les yeux rouges et une envie de meurtre dans les yeux...";
        guerrier.setAttaqueBonus(invest *2);
        guerrier.setDefenseBonus(invest);
        guerrier.perteEndurance(invest);
        this.MoveDesc = "";
        this.MoveDesc3 = "";
    }

    private void attaquePrudente(Warrior guerrier, int invest){
        System.out.println("Qui veut voyager loin ménage sa monture hein?");
        this.MoveDesc2 = "Qui veut voyager loin ménage sa monture hein?";
        guerrier.setAttaqueBonus(invest * -1);
        guerrier.setDefenseBonus(invest);
        guerrier.perteEndurance(invest);
        this.MoveDesc = "";
        this.MoveDesc3 = "";
    }

    private void riposte(Warrior guerrier, int invest){
        System.out.println("Bien, vous vous campez sur vos jambes, prêt à contrattaquer...");
        this.MoveDesc = "Bien, vous vous campez sur vos jambes, prêt à contrattaquer...";
        if(
//                guerrier.getAdversaires().getNextMoveType().equals("Attaque") ||
                        guerrier.getMonstre().getNextMoveType().equals("Attaque")){
            System.out.println("et d'une fente magistrale, vous surprenez votre adversaire au moment où celui-ci vous attaque");
            this.MoveDesc2 = "et d'une fente magistrale, vous surprenez votre adversaire au moment où celui-ci vous attaque";
            guerrier.setAttaqueBonus(invest * 3);
            guerrier.setDefenseBonus(invest);

        } else {
            System.out.println("Mais l'attaque se fait attendre... dommage");
            this.MoveDesc2 = "Mais l'attaque se fait attendre... dommage";
            guerrier.setAttaqueBonus(invest * -1);
            guerrier.setDefenseBonus(invest);
        }
        guerrier.perteEndurance(invest);
        this.MoveDesc3 = "";
    }

    private void esquive(Warrior guerrier, int invest){
        System.out.println("Oui vous portez une armure, mais une esquive ce n'est pas obligatoirement un salto arrière vous savez?");
        this.MoveDesc2 = "Oui vous portez une armure, mais une esquive ce n'est pas obligatoirement un salto arrière vous savez?";
        guerrier.setAttaqueBonus(guerrier.getAttaque() * -1);
        guerrier.setDefenseBonus(invest + guerrier.getDefense());
        guerrier.perteEndurance(invest);
        if(
//                guerrier.getAdversaires().getNextMoveType().equals("Distance") ||
                        guerrier.getMonstre().getNextMoveType().equals("Distance")){
            guerrier.setDefenseBonus(invest);
        }
        this.MoveDesc = "";
        this.MoveDesc3 = "";
    }

    @Override
    public void effetFinDeTour(Scanner sc, Warrior warrior) {

    }

    public String getMoveDesc() {
        return MoveDesc;
    }

    public void setMoveDesc(String moveDesc) {
        MoveDesc = moveDesc;
    }

    public String getMoveDesc2() {
        return MoveDesc2;
    }

    public void setMoveDesc2(String moveDesc2) {
        MoveDesc2 = moveDesc2;
    }

    public String getMoveDesc3() {
        return MoveDesc3;
    }

    public void setMoveDesc3(String moveDesc3) {
        MoveDesc3 = moveDesc3;
    }
}
