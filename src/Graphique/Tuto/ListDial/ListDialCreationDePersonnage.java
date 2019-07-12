package Graphique.Tuto.ListDial;

import Personnages.Warrior;

public class ListDialCreationDePersonnage {
    public String dial1(int avancement, Warrior warrior){
        switch (avancement){
            case 1 :
                return "Voici la liste des personnages disponibles";

            default:
                return "";
        }

    }
    public String dial2(int avancement, Warrior warrior){
        switch (avancement){
            case 1 :
                return "Ils ont tous leurs particularitées,";

            default:
                return "";
        }

    }
    public String dial3(int avancement, Warrior warrior){
        switch (avancement){
            case 1 :
                return "prenez le temps de les lire";

            default:
                return "";
        }

    }

}
