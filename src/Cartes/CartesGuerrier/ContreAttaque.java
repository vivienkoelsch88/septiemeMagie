package Cartes.CartesGuerrier;

import Cartes.Techniques;
import Graphique.Combat;
import Personnages.Warrior;

public class ContreAttaque extends Techniques {
    private String MoveDesc = "Vous esquivez l'attaque de votre adversaire,";
    private String MoveDesc2 = "profitant de son déséquilibre pour porter un coup imparable";
    private String MoveDesc3 = "";

    public ContreAttaque() {
        super();
        super.setName("Contre Attaque");
        super.setCout(5);
        super.setDesc(new String[]{"Esquive puis riposte", "", "Effet : ", "Défense + investissement X 2", "Si le monstre compte vous attaquer : Attaque + investissement", "", "Type : Défense", "Level : 1"});
        super.setLevel(1);
        super.setType("Défense");
        super.setImage("/Cartes/CartesGuerrier/ImageCarteGuerrier/Brisecoude.png");
        super.setCout2(5);
    }

    @Override
    public String[] affiche() {
        return new String[]{"Augmente la défense", "Concentration", "Recule", "Adresse", "Riposte si attaqué", "Endurance"};
    }

    @Override
    public void utilisation(Combat plateauDeCombat, int invest, int refAction) {
        plateauDeCombat.getWarrior().setDefenseBonus(invest * 2);
        if (plateauDeCombat.getMonstre().getNextMoveType().equals("Attaque")) {
            plateauDeCombat.getWarrior().setAttaqueBonus(invest);
        } else {
            this.MoveDesc = "Vous vous prépariez à esquiver,";
            this.MoveDesc2 = "Malheureusement, pas d'attaque, pas d'esquive...";
        }
        plateauDeCombat.getWarrior().perteRessource(invest);
    }

//    ********************************************************************************

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
