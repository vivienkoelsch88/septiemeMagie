package Glob;

public class Adversaire {
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


    public Adversaire() {
            this.name = "Un petit gobelin";
            this.life = 45;
            this.attaque = 15;
            this.defense = 5;
            this.nextMoveType = "Attaque";
    }

    public int patern(){
        if(nextMove == 0){
            System.out.println("Le gobelin fonce droit devant, une charge de la dernière chance?");
            this.attaqueBonus = 12;
            this.defenseBonus = -2;
            nextMoveType = "Distance";
        } else if (nextMove == 1){
            System.out.println("Le gobelin, cette fois, semble plus prudent, il prend de la distance avec vous,");
            System.out.println("mais prend le temps de quand même vous envoyer sa dague à la figure... Une vielle lame rouillée qui dégouline de... \"truc\"");
            this.attaqueBonus = 6;
            this.defenseBonus = 10;
            nextMoveType = "Défense";
        } else if(nextMove == 2){
            System.out.println("Le gobelin, toujours la bave aux lèvres, renverse une table sur votre chemin ");
            System.out.println("pris par surprise, vous effectuez un bond en arrière et voyez le gobelin prendre quelque chose sur l'armoire en face de vous...");
            this.attaqueBonus = -15;
            this.defenseBonus = 10;
            nextMoveType = "Distance";
        } else if (nextMove == 3){
            System.out.println("Vous vous demandiez ce que le gobelin avait ramassé?");
            System.out.println("En tout cas, vous voyez dans sa main une étonnante sculture de marbre...");
            System.out.println("Qui a l'air de faire mal si il lui prenait l'envie de vous la lancer à la tête... Et justement...");
            this.attaqueBonus = 20;
            this.defenseBonus = 0;
            nextMoveType = "Attaque";
        }
        nextMove ++;
        if(nextMove > 3){
            nextMove = 0;
        }
        if(this.faiblesse){
            return attaque;
        }
        return attaque + attaqueBonus;
    }

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
        System.out.println(this.name + " reçoit " + (dommages -defense - defenseBonus) + "(" + dommages + ")" +" dommages");
        this.life = this.life - (dommages -defense - defenseBonus);

    }
}
