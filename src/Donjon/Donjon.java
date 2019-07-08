package Donjon;

import Glob.Warrior;

import java.util.ArrayList;
import java.util.Scanner;

public class Donjon {
    private ArrayList<Salle> listeSalle;
    private int nbrSalle;
    private int emplacement = 0;

    public Donjon(int nbrSalle) {
        this.nbrSalle = nbrSalle;
        listeSalle = new ArrayList<>();
        Salle salle;
        for(int i = 0; i < nbrSalle; i++){
            int random = (int)(Math.random() * 5);
            if(random == 0 || random == 4) {
                salle = new SalleMonstre();
                listeSalle.add(salle);
            } else if(random == 1 || random == 2){
                salle = new SallePiege();
                listeSalle.add(salle);
            } else if (random == 3){
                salle = new SalleVide();
                listeSalle.add(salle);
            }

        }
    }

    public void parcourire(Scanner sc, Warrior warrior){
        System.out.println("Bon, on fait un petit donjon vite fait pour tester tout ça?");
        while (warrior.getLife() > 0 && emplacement < nbrSalle) {
            System.out.println("Bon allez, il se fait tard, avançons...");
            warrior.showPerso();
            listeSalle.get(emplacement).parcourir(sc, warrior);
            sc.hasNext();
            sc.nextLine();
            warrior.setEndurance(warrior.getEndurance() + 10);
            emplacement++;
        }
    }
}
