package Cartes.CartesGuerrier;

import Cartes.Techniques;
import Graphique.Combat;
import Personnages.Warrior;

public class OuvreGarde extends Techniques {
    private String MoveDesc = "Vous frappez de votre arme,";
    private String MoveDesc2 = "et profitant d'un déséquilibre de votre adversaire,";
    private String MoveDesc3 = "vous enchaînez sur un puissant coup de pied";

    public OuvreGarde() {
        super();
        super.setName("Ouvre-garde");
        super.setCout(5);
        super.setDesc(new String[]{"Inflige fragile, les bonus de défense ne sont plus appliqués", "", "Effet : ", "Applique Faiblesse", "Attaque + investissement", "", "Type : Attaque", "Level : 1"});
        super.setLevel(1);
        super.setType("Attaque");
        super.setImage("/Cartes/CartesGuerrier/ImageCarteGuerrier/Brisecoude.png");
    }

    @Override
    public String[] affiche() {
        return new String[]{"Augmente la défense", "Endurance", "Frappe et applique faiblesse", "Adresse", "Augmente la défense", "Concentration"};
    }

    @Override
    public void utilisation(Combat plateauDeCombat, int invest, int refAction) {
        plateauDeCombat.getMonstre().setFragilite(true);
        plateauDeCombat.getWarrior().setAttaqueBonus(plateauDeCombat.getWarrior().getAttaqueBonus() + invest);
        plateauDeCombat.getWarrior().perteRessource(invest);
    }

    //    *******************************************************************************************
    @Override
    public void utilisationTuto(Warrior guerrier, int invest) {}

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
