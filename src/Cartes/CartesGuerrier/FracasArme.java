package Cartes.CartesGuerrier;

import Cartes.Techniques;
import Graphique.PlateauDeCombat;
import Personnages.Warrior;

public class FracasArme extends Techniques {
    private String MoveDesc = "Vous frappez de votre arme,";
    private String MoveDesc2 = "et profitant d'un déséquilibre de votre adversaire,";
    private String MoveDesc3 = "vous enchaînez sur un puissant coup de pied";

    public FracasArme() {
        super();
        super.setName("Fraca's Arme");
        super.setCout(10);
        super.setDesc(new String[]{"Si la cible est faible, réduit son attaque définitivement", "", "Effet : ", "Si l'adversaire est faible : attaque - 1 définitivement", "Attaque + investissement", "", "", "Type : Attaque", "Level : 1"});
        super.setLevel(1);
        super.setType("Attaque");
        super.setImage("/Cartes/CartesGuerrier/ImageCarteGuerrier/Brisecoude.png");
    }

    @Override
    public void utilisation(PlateauDeCombat plateauDeCombat, int invest) {
       if(plateauDeCombat.getMonstre().isFaiblesse()){
           plateauDeCombat.getMonstre().setAttaque(plateauDeCombat.getMonstre().getAttaque() - 1);
       }
       plateauDeCombat.getWarrior().setAttaqueBonus(invest);
       plateauDeCombat.getWarrior().perteRessource(invest);
    }

//    ***************************************************************************************

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
