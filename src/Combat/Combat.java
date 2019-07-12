package Combat;

import Personnages.Warrior;
import Monstre.Monstre;

import java.util.Scanner;

public abstract class Combat {
    public abstract void combattre(Scanner sc, Warrior warrior, Monstre monstre);
}
