package CartesGuerrier;

import Personnages.Warrior;

public class OuvreGarde extends Techniques{
    public OuvreGarde() {
        super();
        super.setName("Ouvre-garde");
        super.setCout(5);
        super.setDesc("Attaque simple + pioche");
        super.setLevel(1);
        super.setType("Attaque");
    }

    @Override
    public void utilisation(Warrior guerrier, int invest) {
        System.out.println("Tient? Si je frappe trés fort dans son casque il n'aime pas... Bon, moi oui");
        guerrier.perteEndurance(invest);
        guerrier.setAttaqueBonus(invest);
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
