package Graphique.Tuto.ListDial;

import Personnages.Warrior;

public class ListDialTuto {

    public String dial1(int avancement, Warrior warrior){
        if(avancement == 1){
            return " ";
        } else if( avancement == 2){
            return "============================ Liste techniques ===========================";
        } else if( avancement == 3){
            return "Parfait, vous avez choisis :";
        } else if( avancement == 4){
            return "";
        } else if( avancement == 5){
            return "Bon, le principe est simple, chaque technique demande un investissement pour être utilisée";
        } else if( avancement == 6){
            return "";
        }  else if( avancement == 7){
            return "";
        } else if( avancement == 8){
            return "Elles passent de : " + warrior.getAttaque() + " et " + warrior.getDefense();
        }  else if( avancement == 9){
            return "";
        } else if( avancement == 10){
            return "Voilà 2 nouvelles techniques :";
        } else if( avancement == 11){
            return "";
        }
        return "";
    }

    public String dial2(int avancement, Warrior warrior){
        if(avancement == 1){
            return "Par contre nous allons choisir sa technique de départ";
        } else if( avancement == 2){
            return "Choix 1 : " + warrior.getArts().get(0).getName();
        } else if( avancement == 3){
            return warrior.getArtsLearned().get(0).getName();
        }else if( avancement == 4){
            return "Bon, on va essayer de l'utiliser";
        } else if( avancement == 5){
            return "Les arts martiaux demandent un investissement en endurance, vous pouvez investir jusqu'à 10 fois le level de la technique";
        } else if( avancement == 6){
            return "On fait un essai? Combien investissez vous de point d'endurance?";
        } else if( avancement == 7){
            return warrior.getArtsLearned().get(0).getName() + " modifie votre attaque et votre défense";
        }  else if( avancement == 8){
            return "à " + (warrior.getAttaque() + warrior.getAttaqueBonus()) + " et " + (warrior.getDefense() + warrior.getDefenseBonus());
        } else if( avancement == 9){
            return "Bon, on va étoffer un peu votre arsenal";
        }  else if( avancement == 10){
            return warrior.getArtsLearned().get(1).getName();
        } else if( avancement == 11){
            return "On test ça?";
        }

        return "";
    }

    public String dial3(int avancement, Warrior warrior){
        if(avancement == 1){
            return " ";
        } else if( avancement == 2){
            return "Choix 2 : " + warrior.getArts().get(1).getName();
        } else if( avancement == 3){
            return " ";
        }else if( avancement == 4){
            return "";
        } else if( avancement == 5){
            return "Les guerrier possèdent " + warrior.getEndurance() + " points d'endurance";
        } else if( avancement == 6){
            return "";
        }  else if( avancement == 7){
            return "";
        }  else if( avancement == 8){
            return "Pratique non?";
        } else if( avancement == 9){
            return "";
        } else if( avancement == 10){
            return warrior.getArtsLearned().get(2).getName();
        } else if( avancement == 12){
            return "";
        }
        return "";
    }
}