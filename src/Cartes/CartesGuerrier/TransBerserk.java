package Cartes.CartesGuerrier;

import Cartes.Techniques;
import Graphique.Combat;
import Personnages.Warrior;

public class TransBerserk extends Techniques {
    private String MoveDesc = "La transe a des bon côtés...";
    private String MoveDesc2 = "Mais il vous fait aussi baver et rugir...";
    private String MoveDesc3 = "Il y a pire comme défaut";

    public TransBerserk() {
        super();
        super.setName("Transe du Berserker");
        super.setCout(10);
        super.setDesc(new String[]{"Augmente votre attaque proportionellement à votre force", "", "Effet : ", "Attaque = 0", "Pour ce combat : Attaque + Force/10 X investissement", "", "Type : Etat", "Level : 1"});
        super.setLevel(1);
        super.setType("Etat");
        super.setImage("/Cartes/CartesGuerrier/ImageCarteGuerrier/Brisecoude.png");
        super.setCout1(5);
        super.setCout3(5);
    }

    @Override
    public String[] affiche() {
        return new String[]{"Aumente votre attaque perma", "Endurance", "Augmente la défense", "Concentration", "Avance", "Force"};
    }

    @Override
    public void utilisation(Combat plateauDeCombat, int invest, int refAction) {
        plateauDeCombat.getWarrior().setAttaqueBonus(plateauDeCombat.getWarrior().getAttaque() * -1);
        int bonus = Math.round(plateauDeCombat.getWarrior().getForce()/10) * invest;
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