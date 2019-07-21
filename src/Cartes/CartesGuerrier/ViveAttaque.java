package Cartes.CartesGuerrier;

import Cartes.Techniques;
import Graphique.PlateauDeCombat;
import Personnages.Warrior;

public class ViveAttaque extends Techniques {
    private String MoveDesc = "Vous savez comment surprendre votre adversaire,";
    private String MoveDesc2 = "Par une brusque accélération, ";
    private String MoveDesc3 = "vous foncez sur votre adversaire surpris par votre action";

    public ViveAttaque() {
        super();
        super.setName("Vive attaque");
        super.setCout(5);
        super.setDesc(new String[]{"Sacrifie vos points d'adresse pour une attaque trés puissante", "", "Effet : ", "Attaque + investissement X 6", "Défense + investissement X 2", "Adresse - investissement", "", "Type : Attaque", "Level : 1"});
        super.setLevel(1);
        super.setType("Attaque");
        super.setImage("/Cartes/CartesGuerrier/ImageCarteGuerrier/Brisecoude.png");
    }

    @Override
    public String[] affiche() {
        return new String[]{"Avance", "Adresse", "Augmentation de l'attaque", "Adresse", "Augmentation de l'attaque", "Adresse"};
    }

    @Override
    public void utilisation(PlateauDeCombat plateauDeCombat, int invest) {
        plateauDeCombat.getWarrior().setAdresse(plateauDeCombat.getWarrior().getAdresse() - invest);
        plateauDeCombat.getWarrior().setAttaqueBonus(invest * 6);
        plateauDeCombat.getWarrior().setDefenseBonus(invest * 2);
        plateauDeCombat.getWarrior().perteRessource(invest);
    }

//    *************************************************************************

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
