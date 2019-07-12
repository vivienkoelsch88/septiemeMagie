package CartesGuerrier;

import Personnages.Warrior;

public class BriseCoude extends Techniques{

    public BriseCoude() {
        super();
        super.setName("Brise-coude");
        super.setCout(5);
        super.setDesc("Inflige faiblesse, les bonus d'attaque ne sont plus appliqués");
        super.setLevel(1);
        super.setType("Attaque");
    }

    @Override
    public void utilisation(Warrior guerrier, int invest) {
        System.out.println("Bon, pour une fois, on ne vise pas la tête..." + "\n" +
                "Si si c'est bien aussi");
        guerrier.getMonstre().setFaiblesse(true);
        guerrier.perteEndurance(invest);
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
