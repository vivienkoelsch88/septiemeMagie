package Cartes.CartesGuerrier;


import Personnages.Warrior;

public class ChangementDePosition extends Techniques {

    public ChangementDePosition() {
        super();
        super.setName("Changement de position");
        super.setCout(0);
        super.setDesc("Pas d'attaque, mais un bonus de défense de Concentration/5 et une pioche");
        super.setLevel(1);
        super.setType("Défense");
    }

    @Override
    public void utilisation(Warrior guerrier, int invest) {
        System.out.println("Vous annalisez la situation... Oui ça vous arrive!" + "\n" +
                "Mmmh... c'est dangereux, vous relevez votre bouclier et levez votre arme");
        guerrier.setAttaqueBonus(guerrier.getAttaque() * -1);
        guerrier.setDefenseBonus(guerrier.getConcentration()/5);
        guerrier.perteRessource(invest);
        guerrier.pioche();
    }

    @Override
    public void effetFinDeTour(Warrior warrior) {

    }

    @Override
    public String getMoveDesc() {
        return null;
    }

    @Override
    public String getMoveDesc2() {
        return null;
    }

    @Override
    public String getMoveDesc3() {
        return null;
    }
}
