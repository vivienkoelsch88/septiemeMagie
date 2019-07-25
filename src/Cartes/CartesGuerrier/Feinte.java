package Cartes.CartesGuerrier;

import Cartes.Techniques;
import Graphique.Combat;
import Personnages.Warrior;

public class Feinte extends Techniques {
    private String MoveDesc;
    private String MoveDesc2;
    private String MoveDesc3;

    public Feinte() {
        super();
        super.setName("Feinte");
        super.setCout(5);
        super.setDesc(new String[]{"Une attaque efficace si l'adversaire se défend", "", "Effet : ", "Attaque invest X 4 contre une défense, sinon, défense - invest", "", "Type : Attaque", "Level : 1"});
        super.setLevel(1);
        super.setType("Attaque");
        super.setImage("/Cartes/CartesGuerrier/ImageCarteGuerrier/Brisecoude.png");
        super.setCout3(5);
    }

    @Override
    public String[] affiche() {
        return new String[]{"Augmentation de l'attaque contre une défense", "Endurance", "Augmentation de l'attaque", "Endurance", "Recule", "Adresse"};
    }

    @Override
    public void utilisation(Combat plateauDeCombat, int invest, int refAction) {
        switch (refAction){
            case 1 :
                plateauDeCombat.getWarrior().setRessource(plateauDeCombat.getWarrior().getRessource() - invest);
                if (plateauDeCombat.getNextMoveType().equals("défense")) {
                    plateauDeCombat.attaquer(invest * 4);
                    plateauDeCombat.setMessage("Vous profitez que votre adversaire plein de rage vous attaque pour une riposte bien sentie");
                } else {
                    plateauDeCombat.attaquer(invest);
                    plateauDeCombat.defendre(invest * -1);
                    plateauDeCombat.setMessage("Vous tentez une feinte, malheureusement votre adversaire ne tombe pas dans le panneau...");
                }
                break;

            case 2 :
                plateauDeCombat.getWarrior().setRessource(plateauDeCombat.getWarrior().getRessource() - invest);
                plateauDeCombat.attaquer(invest);
                plateauDeCombat.setMessage("Vous attaquez votre adversaire");
                break;

            case 3 :
                plateauDeCombat.getWarrior().setAdresse(plateauDeCombat.getWarrior().getAdresse() - invest);
                plateauDeCombat.deplacement(invest / 5 * -1);
                plateauDeCombat.setMessage("Vous reculez");
                break;
        }

    }

    //    *************************************************************************************************
    @Override
    public void utilisationTuto(Warrior guerrier, int invest) {}

    @Override
    public String getMoveDesc() {
        return MoveDesc;
    }

    @Override
    public String getMoveDesc2() {
        return MoveDesc2;
    }

    @Override
    public String getMoveDesc3() {
        return MoveDesc3;
    }
}
