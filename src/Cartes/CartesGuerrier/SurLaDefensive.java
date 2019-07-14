package Cartes.CartesGuerrier;

import Cartes.Techniques;
import Graphique.PlateauDeCombat;
import Personnages.Warrior;

public class SurLaDefensive extends Techniques {
    private String MoveDesc = "Vous êtes à bout de souffle,";
    private String MoveDesc2 = "vous décidez de rester un peu sur la défensive";
    private String MoveDesc3 = "le temps de récupérer";

    public SurLaDefensive() {
        super();
        super.setName("Sur la défensive");
        super.setCout(5);
        super.setDesc("N'attaque pas mais vous rend de l'endurance contre de la concentration");
        super.setLevel(1);
        super.setType("Défense");
        super.setImage("/Cartes/CartesGuerrier/ImageCarteGuerrier/Brisecoude.png");
    }

    @Override
    public void utilisation(PlateauDeCombat plateauDeCombat, int invest) {
        plateauDeCombat.getWarrior().setRessource(plateauDeCombat.getWarrior().getRessource() + (invest * 2));
        plateauDeCombat.getWarrior().setConcentration(plateauDeCombat.getWarrior().getConcentration() - invest);
    }

//    **********************************************************************

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
