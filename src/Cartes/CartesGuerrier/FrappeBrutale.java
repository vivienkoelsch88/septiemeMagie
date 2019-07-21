package Cartes.CartesGuerrier;

import Cartes.Techniques;
import Graphique.Combat;
import Personnages.Warrior;

public class FrappeBrutale extends Techniques {
    private String MoveDesc = "";
    private String MoveDesc2 = "Allez, on ne fait pas dans la dentelle, on tape! Fort!";
    private String MoveDesc3 = "";

    public FrappeBrutale() {
        super();
        super.setName("Frappe Brutale");
        super.setCout(5);
        super.setDesc(new String[]{"Sacrifie vos points de force pour une attaque trés puissante", "", "Effet : ", "Force - investissement", "attaque + investissement X 8", "", "Type : Attaque", "Level : 1"});
        super.setLevel(1);
        super.setType("Attaque");
        super.setImage("/Cartes/CartesGuerrier/ImageCarteGuerrier/Brisecoude.png");
        super.setCout2(5);
    }

    @Override
    public String[] affiche() {
        return new String[]{"Augmentation de l'attaque", "Force", "Avance", "Adresse", "Augmentation de l'attaque", "Endurance"};
    }

    @Override
    public void utilisation(Combat plateauDeCombat, int invest, int refAction) {
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
