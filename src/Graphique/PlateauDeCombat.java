package Graphique;

import Monstre.Monstre;
import Personnages.Warrior;

public class PlateauDeCombat {
    private Monstre monstre;
    private Warrior warrior;
    private String fondEcran;
    private int nbrAttaque = 1;
    private int nbrAttaqueMonstre = 1;




    public void pioche(){

    }

//    ************************************************************************

    public Monstre getMonstre() {
        return monstre;
    }

    public void setMonstre(Monstre monstre) {
        this.monstre = monstre;
    }

    public Warrior getWarrior() {
        return warrior;
    }

    public void setWarrior(Warrior warrior) {
        this.warrior = warrior;
    }

    public void setFondEcran(String fondEcran) {
        this.fondEcran = fondEcran;
    }

    public int getNbrAttaque() {
        return nbrAttaque;
    }

    public void setNbrAttaque(int nbrAttaque) {
        this.nbrAttaque = nbrAttaque;
    }

    public int getNbrAttaqueMonstre() {
        return nbrAttaqueMonstre;
    }

    public void setNbrAttaqueMonstre(int nbrAttaqueMonstre) {
        this.nbrAttaqueMonstre = nbrAttaqueMonstre;
    }
}
