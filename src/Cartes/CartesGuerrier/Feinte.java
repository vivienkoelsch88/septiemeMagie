package Cartes.CartesGuerrier;

import Cartes.Techniques;
import Graphique.PlateauDeCombat;
import Personnages.Warrior;

public class Feinte extends Techniques {
    private String MoveDesc = "Une passe d'arme classique,";
    private String MoveDesc2 = "votre adversaire, acculé, se laisse submerger";
    private String MoveDesc3 = "";

    public Feinte() {
        super();
        super.setName("Feinte");
        super.setCout(5);
        super.setDesc(new String[]{"Une attaque efficace si l'adversaire se défend", "", "Effet : ", "Attaque invest X 4 contre une défense, sinon, défense - invest", "", "Type : Attaque", "Level : 1"});
        super.setLevel(1);
        super.setType("Attaque");
        super.setImage("/Cartes/CartesGuerrier/ImageCarteGuerrier/Brisecoude.png");
    }

    @Override
    public String[] affiche() {
        return new String[]{"Augmentation de l'attaque", "Endurance", "Augmentation de l'attaque", "Endurance", "Recule", "Adresse"};
    }

    @Override
    public void utilisation(PlateauDeCombat plateauDeCombat, int invest) {
        if(plateauDeCombat.getMonstre().getNextMoveType().equals("Défense")){
            plateauDeCombat.getWarrior().setAttaqueBonus(invest * 4);
        } else {
            plateauDeCombat.getWarrior().setDefenseBonus(invest * -1);
            this.MoveDesc2 = "mais votre adversaire ne se laisse pas surprendre,";
            this.MoveDesc3 = "sans chercher à esquiver, il vous attaque...";
        }
        plateauDeCombat.getWarrior().perteRessource(invest);
    }

    //    *************************************************************************************************
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
