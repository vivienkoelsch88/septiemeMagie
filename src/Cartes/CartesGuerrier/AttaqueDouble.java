package Cartes.CartesGuerrier;

import Cartes.Techniques;
import Graphique.PlateauDeCombat;
import Personnages.Warrior;

public class AttaqueDouble extends Techniques {
    private String MoveDesc = "Trés simple en fait,";
    private String MoveDesc2 = "un coup à droite, un coup à gauche...";
    private String MoveDesc3 = "";

    public AttaqueDouble() {
        super();
        super.setName("Attaque double");
        super.setCout(5);
        super.setDesc(new String[]{"Frappe deux fois", "", "Effet : ", "Attaque X 2 + investissement", "", "Type : Attaque", "Level : 1"});
        super.setLevel(1);
        super.setType("Attaque");
        super.setImage("/Cartes/CartesGuerrier/ImageCarteGuerrier/Brisecoude.png");
    }

    @Override
    public void utilisation(PlateauDeCombat plateauDeCombat, int invest) {

        plateauDeCombat.getWarrior().setAttaqueBonus(invest + plateauDeCombat.getWarrior().getAttaque());
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
