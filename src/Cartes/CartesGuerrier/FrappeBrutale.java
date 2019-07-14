package Cartes.CartesGuerrier;

import Cartes.Techniques;
import Graphique.PlateauDeCombat;
import Personnages.Warrior;

public class FrappeBrutale extends Techniques {
    private String MoveDesc = "";
    private String MoveDesc2 = "Allez, on ne fait pas dans la dentelle, on tape! Fort!";
    private String MoveDesc3 = "";

    public FrappeBrutale() {
        super();
        super.setName("Frappe Brutale");
        super.setCout(5);
        super.setDesc("Sacrifie vos points de force pour une attaque trés puissante");
        super.setLevel(1);
        super.setType("Attaque");
        super.setImage("/Cartes/CartesGuerrier/ImageCarteGuerrier/Brisecoude.png");
    }

    @Override
    public void utilisation(PlateauDeCombat plateauDeCombat, int invest) {
        plateauDeCombat.getWarrior().setForce(plateauDeCombat.getWarrior().getForce() - invest);
        plateauDeCombat.getWarrior().setAttaqueBonus(invest * 8);
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
