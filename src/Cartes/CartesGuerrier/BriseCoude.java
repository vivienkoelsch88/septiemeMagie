package Cartes.CartesGuerrier;

import Cartes.Techniques;
import Graphique.Combat;
import Personnages.Warrior;

public class BriseCoude extends Techniques {
    private String MoveDesc = "Vous faîtes un bref pas en avant,";
    private String MoveDesc2 = "surprenant votre adversaire, vous profitez de ";
    private String MoveDesc3 = "sa surprise pour frapper de votre bouclier le coude de votre adversaire";

    public BriseCoude() {
        super();
        super.setName("Brise-coude");
        super.setCout(5);
        super.setDesc(new String[]{"Inflige faiblesse, les bonus d'attaque ne sont plus appliqués", "", "Effet : ", "avance", "Applique Faiblesse", "Attaque + investissement", "", "Type : Attaque", "Level : 1"});
        super.setLevel(1);
        super.setType("Attaque");
        super.setImage("/Cartes/CartesGuerrier/ImageCarteGuerrier/Brisecoude.png");
        super.setCout1(5);
    }

    @Override
    public String[] affiche() {
        return new String[]{"Avance", "Adresse", "Inflige faiblesse, Augmentation de l'attaque", "Endurance", "Augmente la défense", "Force"};
    }

    @Override
    public void utilisation(Combat plateauDeCombat, int invest, int refAction) {
        plateauDeCombat.getMonstre().setFaiblesse(true);
        plateauDeCombat.getWarrior().setAttaqueBonus(plateauDeCombat.getWarrior().getAttaqueBonus() + invest);
        plateauDeCombat.getWarrior().perteRessource(invest);
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

    @Override
    public void utilisationTuto(Warrior guerrier, int invest) {

    }
}
