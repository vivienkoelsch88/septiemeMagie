package Personnages;

import Cartes.Techniques;
import Monstre.Monstre;
import Monstre.MonstresTuto.Orc;

import java.util.ArrayList;

public abstract class Warrior {
    //    Attributs
    private int life;
    private int attaque;
    private int defense;
    private String icon;

    private int concentration = 30;
    private int force;
    private int adresse;
    private int charisme;

    private Monstre monstre;
    private boolean faiblesse = false;

    private ArrayList<Techniques> deck = new ArrayList<>();
    private ArrayList<Techniques> effetFinDeTour = new ArrayList<>();

    private int attaqueBonus = 0;
    private int defenseBonus = 0;
    private int pioche = 0;

    //    Constructeurs

    public Warrior() {
    }

    public Warrior(int life, int attaque, int defense) {
        this.life = life;
        this.attaque = attaque;
        this.defense = defense;
        this.monstre = new Orc();
    }

    //    Méthodes
    public void ajouterEffetFinDeTour(Techniques techniques) {
        effetFinDeTour.add(techniques);
    }

    public void resetEffetFinDeTour() {
        this.effetFinDeTour = new ArrayList<>();
    }

    public ArrayList<Techniques> getEffetFinDeTour() {
        return effetFinDeTour;
    }


    public Monstre getMonstre() {
        return monstre;
    }

    public void setMonstre(Monstre monstre) {
        this.monstre = monstre;
    }

    public boolean isFaiblesse() {
        return faiblesse;
    }

    public void setFaiblesse(boolean faiblesse) {
        this.faiblesse = faiblesse;
    }

    public int getPioche() {
        return pioche;
    }

    public void setPioche(int pioche) {
        this.pioche = pioche;
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

    public void setDefense(int defense) {
        this.defense = defense;
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

    public ArrayList<Techniques> listCarte() {
        return this.deck;
    }

    public void setDeck(ArrayList<Techniques> deck) {
        this.deck = deck;
    }

    public void ajouterCarteDeck(Techniques techniques) {
        this.deck.add(techniques);
    }

    public int getConcentration() {
        return concentration;
    }

    public void setConcentration(int concentration) {
        this.concentration = concentration;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public int getAdresse() {
        return adresse;
    }

    public void setAdresse(int adresse) {
        this.adresse = adresse;
    }

    public int getCharisme() {
        return charisme;
    }

    public void setCharisme(int charisme) {
        this.charisme = charisme;
    }

    public void setCarte(Techniques techniques) {
        deck.add(techniques);
    }

    public void prendreDommages(int dommages) {
        if (dommages - defense - defenseBonus > 0) {
            this.life = this.life - (dommages - defense - defenseBonus);
        }
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }


    public abstract void setArtsLearned(Techniques artsLearned);

    public abstract ArrayList<Techniques> getArtsLearned();

    public abstract int getRessource();

    public abstract void setRessource(int endurance);

    public abstract void perteRessource(int perte);

    public abstract ArrayList<Techniques> getDeck();

    public abstract String getFondEcran();

    public abstract String getClasse();

    public abstract String[] getDesc();

    public abstract Techniques[] getListTechnique();

    public abstract String getTypeRessource();

    public void resetBonus() {
        this.attaqueBonus = 0;
        this.defenseBonus = 0;
    }

}
