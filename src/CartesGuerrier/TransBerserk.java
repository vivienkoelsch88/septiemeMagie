package CartesGuerrier;

import Glob.Techniques;
import Glob.Warrior;

import java.util.Scanner;

public class TransBerserk extends Techniques{
    public TransBerserk() {
        super();
        super.setName("Transe du Berserker");
        super.setCout(10);
        super.setDesc("A la fin de chaque tour, récupère de l'endurance");
        super.setLevel(1);
        super.setType("Etat");
    }

    @Override
    public void utilisation(Warrior guerrier, int invest) {
        System.out.println("Tu... euh tu bave...");
        guerrier.setAttaqueBonus(invest * 2);
        guerrier.setDefense(invest * -1);
        guerrier.ajouterEffetFinDeTour(new TransBerserk());
    }

    @Override
    public void effetFinDeTour(Scanner sc, Warrior warrior) {
        warrior.setEndurance(warrior.getEndurance() + 5);
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