package Cartes.CartesGuerrier;

import Cartes.Techniques;
import Graphique.Combat;
import Personnages.Warrior;

public class AttaqueDouble extends Techniques {
    private String MoveDesc = "Trés simple en fait,";
    private String MoveDesc2 = "un coup à droite, un coup à gauche...";
    private String MoveDesc3 = "";

    public AttaqueDouble() {
        super();
        super.setName("Attaque double");
        super.setCout(5);
        super.setDesc(new String[]{"Frappe deux fois", "", "Effet : ","Avance", "Attaque X 2 + investissement", "", "Type : Attaque", "Level : 1"});
        super.setLevel(1);
        super.setType("Attaque");
        super.setImage("/Cartes/CartesGuerrier/ImageCarteGuerrier/Brisecoude.png");
        super.setCout1(5);
        super.setCout3(5);
    }

    @Override
    public String[] affiche() {
        return new String[]{"Avance", "Adresse", "Frappe 2 fois", "Endurance", "Recule", "Adresse"};
    }

    @Override
    public void utilisation(Combat plateauDeCombat, int invest, int refAction) {
        switch (refAction){
            case 1 :
                plateauDeCombat.getWarrior().setAdresse(plateauDeCombat.getWarrior().getAdresse() - invest);
                plateauDeCombat.deplacement(invest / 5);
                break;

            case 2 :
                plateauDeCombat.getWarrior().setRessource(plateauDeCombat.getWarrior().getRessource() - invest);
                plateauDeCombat.attaquer(invest);
                plateauDeCombat.attaquer(invest);
                break;

            case 3 :
                plateauDeCombat.getWarrior().setAdresse(plateauDeCombat.getWarrior().getAdresse() - invest);
                plateauDeCombat.deplacement(invest / 5 * -1);
                break;
        }
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
