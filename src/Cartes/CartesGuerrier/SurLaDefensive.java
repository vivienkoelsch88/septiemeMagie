package Cartes.CartesGuerrier;

import Cartes.Techniques;
import Graphique.Combat;
import Personnages.Warrior;

public class SurLaDefensive extends Techniques {
    private String MoveDesc = "Vous êtes à bout de souffle,";
    private String MoveDesc2 = "vous décidez de rester un peu sur la défensive";
    private String MoveDesc3 = "le temps de récupérer";

    public SurLaDefensive() {
        super();
        super.setName("Sur la défensive");
        super.setCout(5);
        super.setDesc(new String[]{"N'attaque pas mais vous rend de l'endurance contre de la concentration", "", "Effet : ", "Attaque = 0", "Endurance + investissement X 2", "Concentration - investissement", "", "Type : Défense", "Level : 1"});
        super.setLevel(1);
        super.setType("Défense");
        super.setImage("/Cartes/CartesGuerrier/ImageCarteGuerrier/Brisecoude.png");
    }

    @Override
    public String[] affiche() {
        return new String[]{"Augmente la défense", "Endurance", "Récupère de l'endurance", "Concentration", "Augmente la défense", "Charisme"};
    }

    @Override
    public void utilisation(Combat plateauDeCombat, int invest, int refAction) {
        plateauDeCombat.getWarrior().setAttaqueBonus(plateauDeCombat.getWarrior().getAttaque() * -1);
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
