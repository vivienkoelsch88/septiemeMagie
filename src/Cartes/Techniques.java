package Cartes;

import Graphique.Combat;
import Personnages.Warrior;

public abstract class Techniques {
    private String name;
    private int cout;
    private String[] desc;
    private int level;
    private String type;
    private String image;
    private int cout1 = 1;
    private int cout2 = 1;
    private int cout3 = 1;



    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCout() {
        return cout;
    }

    public void setCout(int cout) {
        this.cout = cout;
    }

    public String[] getDesc() {
        return desc;
    }

    public void setDesc(String[] desc) {
        this.desc = desc;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCout1() {
        return cout1;
    }

    public void setCout1(int cout1) {
        this.cout1 = cout1;
    }

    public int getCout2() {
        return cout2;
    }

    public void setCout2(int cout2) {
        this.cout2 = cout2;
    }

    public int getCout3() {
        return cout3;
    }

    public void setCout3(int cout3) {
        this.cout3 = cout3;
    }

    public abstract void utilisationTuto(Warrior guerrier, int invest);
    public abstract void utilisation(Combat plateauDeCombat, int invest, int refAction);

    public abstract  String getMoveDesc();
    public abstract  String getMoveDesc2();
    public abstract  String getMoveDesc3();
    public abstract String[] affiche();



}
