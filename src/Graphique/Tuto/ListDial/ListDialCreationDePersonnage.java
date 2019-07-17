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

            case 17 :
                return "Allez, une petite dernière chose,";

            case 20 :
                return "Parfait, ";

            case 22 :
                return "Ha si une dernière chose,";

            case 24 :
                return "Déterminer l'ordre des carte de votre deck est donc primordial,";

            case 27 :
                return "Une fois que c'est fait, on va pouvoir continuer,";

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

            case 17 :
                return "le choix des cartes de votre deck bien sûr!";

            case 20 :
                return "Vous venez de choisir vos 5 cartes, ";

            case 22 :
                return "Comme vous le savez au début d'une phase d'action,";

            case 24 :
                return "prenez donc le temps de les ranger dans l'ordre le plus pertinent";

            case 27 :
                return "Cliquez sur ******************** pour lancer l'aventure";

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

            case 9 :
                return "Elle augmente par exemple le nombre d'action que vous effectuez à chaque tour";

            case 11 :
                return "et votre aise sociale de manière générale";

            case 13 :
                return "et vous ne pouvez pas commencer la partie avec un attribut supérieur à 50";

            case 17 :
                return "choisissez les 5 cartes qui constituront votre deck";

            case 20 :
                return "Nous allons pouvoir y aller non? ";

            case 22 :
                return "vous piochez un nombre de cartes égal à votre concentration / 10";

            case 24 :
                return "en cliquant sur le portrait de votre personnage";


            default:
                return "";
        }

    }

}
