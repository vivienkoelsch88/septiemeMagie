package Graphique.Tuto.ListDial;

import Personnages.Warrior;

public class ListDialCreationDePersonnage {
    public String dial1(int avancement, Warrior warrior){
        switch (avancement){
            case 1 :
                return "Voici la liste des personnages disponibles";

            case 5 :
                return "Pour commencer, la Concentration,";

            case 7 :
                return "Ensuite, la Force,";

            case 9 :
                return "L'Adresse,";

            case 11 :
                return "Et enfin le charisme,";

            case 13 :
                return "Nous allons donc y répartir 30 points";

            case 15 :
                return "";

            default:
                return "";
        }

    }
    public String dial2(int avancement, Warrior warrior){
        switch (avancement){
            case 1 :
                return "Ils ont tous leurs particularitées,";

            case 5 :
                return "La Concentration représente votre capacité à vous investir,";

            case 7 :
                return "Je vous laisse deviner...";

            case 9 :
                return "Qui représente votre agilité et votre dextérité";

            case 11 :
                return "Qui représente votre capacité à intéragir avec votre entourage";

            case 13 :
                return "Tout les attributs commencent à 30 points,";

            case 15 :
                return "Parfait, voila un choix intéressant...";

            default:
                return "";
        }

    }
    public String dial3(int avancement, Warrior warrior){
        switch (avancement){
            case 1 :
                return "prenez le temps de les lire";

            case 5 :
                return "Elle influence par exemple la taille de votre main de départ";

            case 7 :
                return "elle représente votre force physique";

            case 11 :
                return "et votre aise sociale de manière générale";

            case 13 :
                return "et vous ne pouvez pas commencer la partie avec un attribut supérieur à 50";

            case 15 :
                return "";

            default:
                return "";
        }

    }

}
