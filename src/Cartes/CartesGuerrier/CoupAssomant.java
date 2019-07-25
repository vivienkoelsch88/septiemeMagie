package Cartes.CartesGuerrier;

import Cartes.Techniques;
import Graphique.Combat;
import Personnages.Warrior;

public class CoupAssomant extends Techniques {
    private String MoveDesc = "Vous vous élancez, et d'un bond,";
    private String MoveDesc2 = "vous abattez votre bouclier sur le crâne de votre adversaire";
    private String MoveDesc3 = "";

    public CoupAssomant() {
        super();
        super.setName("Coup assomant");
        super.setCout(5);
        super.setDesc(new String[]{"Sacrifie vos points de force pour une attaque qui" ,"réduit définitivement l'attaque de l'adversaire", "", "Effet : ", "Force - investissement", "Attaque et défense + investissement", "", "Type : Attaque", "Level : 1"});
        super.setLevel(1);
        super.setType("Attaque");
        super.setImage("/Cartes/CartesGuerrier/ImageCarteGuerrier/Brisecoude.png");
        super.setCout3(5);
    }

    @Override
    public String[] affiche() {
        return new String[]{"Augmente la défense", "Endurance", "Augmentation de l'attaque", "Force", "Réduit l'attaque de l'adversaire", "Force"};
    }

    @Override
    public void utilisation(Combat plateauDeCombat, int invest, int refAction) {
        switch (refAction){
            case 1 :
                plateauDeCombat.getWarrior().setRessource(plateauDeCombat.getWarrior().getRessource() - invest);
                plateauDeCombat.defendre(invest);
                plateauDeCombat.setMessage("Vous vous défendez");
                break;

            case 2 :
                plateauDeCombat.getWarrior().setForce(plateauDeCombat.getWarrior().getForce() - invest);
                plateauDeCombat.attaquer(invest);
                plateauDeCombat.setMessage("Vous attaquez");
                break;

            case 3 :
                plateauDeCombat.getWarrior().setForce(plateauDeCombat.getWarrior().getForce() - invest);
                plateauDeCombat.getMonstre().setAttaqueBonus(plateauDeCombat.getMonstre().getAttaqueBonus() - invest/5);
                plateauDeCombat.setMessage("Vous réduisez l'attaque de l'adversaire de " + invest/5);
                break;
        }
    }

//    ***********************************************************************

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
