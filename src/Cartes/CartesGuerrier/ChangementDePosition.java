package Cartes.CartesGuerrier;


import Cartes.Techniques;
import Graphique.Combat;
import Personnages.Warrior;

public class ChangementDePosition extends Techniques {
    private String MoveDesc = "Prenant appui sur votre bouclier";
    private String MoveDesc2 = "vous pivoter sur vous même, vous retrouvant dans le dos ";
    private String MoveDesc3 = "de votre adversaire.";

    public ChangementDePosition() {
        super();
        super.setName("Changement de position");
        super.setCout(0);
        super.setDesc(new String[]{"Pas d'attaque, mais un bonus de défense de Concentration et une pioche", "", "Effet : ", "Attaque = 0", "Défense + investissement", "pioche", "", "Type : Défense", "Level : 1"});
        super.setLevel(1);
        super.setType("Défense");
        super.setImage("/Cartes/CartesGuerrier/ImageCarteGuerrier/Brisecoude.png");
        super.setCout1(0);
    }

    @Override
    public String[] affiche() {
        return new String[]{"Pioche", "", "Augmente la défense", "Endurance", "Augmente la défense", "Endurance"};
    }

    @Override
    public void utilisation(Combat plateauDeCombat, int invest, int refAction) {
        plateauDeCombat.getWarrior().setAttaqueBonus(plateauDeCombat.getWarrior().getAttaque() * -1);
        plateauDeCombat.getWarrior().setDefenseBonus(invest);
        plateauDeCombat.pioche(1);
        plateauDeCombat.getWarrior().perteRessource(invest);
    }

    //    *************************************************************************************
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
