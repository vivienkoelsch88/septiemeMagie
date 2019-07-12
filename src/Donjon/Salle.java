package Donjon;

import Personnages.Warrior;

import java.util.Scanner;

public abstract class Salle {
    private String type;

    public Salle(String type) {
        this.type = type;
    }


    public abstract void parcourir(Scanner sc, Warrior warrior);

    public String getType() {
        return type;
    }

}
