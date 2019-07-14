package Cartes.CartesGuerrier;

import Cartes.Techniques;
import Graphique.PlateauDeCombat;
import Personnages.Warrior;

public class TransBerserk extends Techniques {
    private String MoveDesc = "La transe a des bon côtés...";
    private String MoveDesc2 = "Mais il vous fait aussi baver et rugir...";
    private String MoveDesc3 = "Il y a pire comme défaut";

    public TransBerserk() {
        super();
        super.setName("Transe du Berserker");
        super.setCout(10);
        super.setDesc("Augmente votre attaque proportionellement à votre force");
        super.setLevel(1);
        super.setType("Etat");
        super.setImage("/Cartes/CartesGuerrier/ImageCarteGuerrier/Brisecoude.png");
    }

    @Override
    public void utilisation(PlateauDeCombat plateauDeCombat, int invest) {
        int bonus = Math.round(plateauDeCombat.getWarrior().getForce()/10) * invest;
        plateauDeCombat.getWarrior().setAttaqueBonus2(bonus);
        plateauDeCombat.getWarrior().perteRessource(invest);
    }

    //    **************************************************************************************
    @Override
    public void utilisationTuto(Warrior guerrier, int invest) {
    }

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