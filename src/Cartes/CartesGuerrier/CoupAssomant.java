package Cartes.CartesGuerrier;

import Cartes.Techniques;
import Graphique.PlateauDeCombat;
import Personnages.Warrior;

public class CoupAssomant extends Techniques {
    private String MoveDesc = "Vous vous élancez, et d'un bond,";
    private String MoveDesc2 = "vous abattez votre bouclier sur le crâne de votre adversaire";
    private String MoveDesc3 = "";

    public CoupAssomant() {
        super();
        super.setName("Coup assomant");
        super.setCout(5);
        super.setDesc(new String[]{"Sacrifie vos points de force pour une attaque qui" ,"réduit définitivement l'attaque et la défense de l'adversaire", "", "Effet : ", "Force - investissement", "Attaque et défense + investissement", "", "Type : Attaque", "Level : 1"});
        super.setLevel(1);
        super.setType("Attaque");
        super.setImage("/Cartes/CartesGuerrier/ImageCarteGuerrier/Brisecoude.png");
    }

    @Override
    public void utilisation(PlateauDeCombat plateauDeCombat, int invest) {
        plateauDeCombat.getWarrior().setForce(plateauDeCombat.getWarrior().getForce() - invest);
        plateauDeCombat.getMonstre().setAttaque(plateauDeCombat.getMonstre().getAttaque() - invest);
        plateauDeCombat.getMonstre().setDefense(plateauDeCombat.getMonstre().getDefense() - invest);
        plateauDeCombat.getWarrior().perteRessource(invest);
    }

//    ***********************************************************************

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
