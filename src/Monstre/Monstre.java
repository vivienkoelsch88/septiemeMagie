package Monstre;

import Glob.Warrior;

public abstract class Monstre {
    private String name;
    private int life;
    private int attaque;
    private int defense;

    private boolean faiblesse;

    private int lifeBonus = 0;
    private int attaqueBonus = 0;
    private int defenseBonus = 0;

    private int nextMove = 0;
    private String nextMoveType;
    private String MoveDesc;
    private String MoveDesc2;
    private String MoveDesc3;


    public Monstre(String name, int life, int attaque, int defense, String nextMoveType) {
        this.name = name;
        this.life = life;
        this.attaque = attaque;
        this.defense = defense;
        this.nextMoveType = nextMoveType;
    }

    public abstract int patern(Warrior warrior);

    public void resetBonus (){
        this.lifeBonus = 0;
        this.attaqueBonus = 0;
        this.defenseBonus = 0;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getAttaque() {
        return attaque;
    }

    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }

    public int getDefense() {
        return defense;
    }

    public boolean isFaiblesse() {
        return faiblesse;
    }

    public void setFaiblesse(boolean faiblesse) {
        this.faiblesse = faiblesse;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getLifeBonus() {
        return lifeBonus;
    }

    public void setLifeBonus(int lifeBonus) {
        this.lifeBonus = lifeBonus;
    }

    public int getAttaqueBonus() {
        return attaqueBonus;
    }

    public void setAttaqueBonus(int attaqueBonus) {
        this.attaqueBonus = attaqueBonus;
    }

    public int getDefenseBonus() {
        return defenseBonus;
    }

    public void setDefenseBonus(int defenseBonus) {
        this.defenseBonus = defenseBonus;
    }

    public int getNextMove() {
        return nextMove;
    }

    public void setNextMove(int nextMove) {
        this.nextMove = nextMove;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNextMoveType() {
        return nextMoveType;
    }

    public void setNextMoveType(String nextMoveType) {
        this.nextMoveType = nextMoveType;
    }

    public void prendreDommages(int dommages){
        int domm = dommages -defense - defenseBonus;

        domm =  domm < 0 ? 0: domm;

        System.out.println(this.name + " reçoit " + domm + "(" + dommages + ")" +" dommages");
        this.life = this.life - domm;

    }

    public String getMoveDesc() {
        return MoveDesc;
    }

    public void setMoveDesc(String moveDesc) {
        MoveDesc = moveDesc;
    }

    public String getMoveDesc2() {
        return MoveDesc2;
    }

    public void setMoveDesc2(String moveDesc2) {
        MoveDesc2 = moveDesc2;
    }

    public String getMoveDesc3() {
        return MoveDesc3;
    }

    public void setMoveDesc3(String moveDesc3) {
        MoveDesc3 = moveDesc3;
    }
}
