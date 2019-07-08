package Glob;

import java.util.Scanner;

public class Attaque extends Techniques{


    public Attaque() {
        super();
        super.setName("Attaque");
        super.setCout(0);
        super.setDesc("Une attaque toute bête...");
        super.setLevel(1);
        super.setType("Attaque");
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public int getCout() {
        return super.getCout();
    }

    @Override
    public void setCout(int cout) {
        super.setCout(cout);
    }

    @Override
    public String getDesc() {
        return super.getDesc();
    }

    @Override
    public void setDesc(String desc) {
        super.setDesc(desc);
    }

    @Override
    public int getLevel() {
        return super.getLevel();
    }

    @Override
    public void setLevel(int level) {
        super.setLevel(level);
    }

    @Override
    public String getType() {
        return super.getType();
    }

    @Override
    public void setType(String type) {
        super.setType(type);
    }

    @Override
    public void utilisation(Warrior guerrier, int invest) {
        System.out.println("Vous utilisez une attaque simple, basique...");
    }

    @Override
    public void effetFinDeTour(Scanner sc, Warrior warrior) {

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
