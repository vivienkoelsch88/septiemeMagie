package Personnages;

import CartesGuerrier.ArtMartiaux;
import CartesGuerrier.Techniques;
import Glob.Adversaire;
import Monstre.Monstre;
import Monstre.Orc;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Warrior {
    //    Attributs
    private int life;
    private int attaque;
    private int defense;
    private int concentration = 30;
    private int force;
    private int adresse;
    private int charisme;
    private Adversaire adversaires;
    private Monstre monstre;
    private boolean faiblesse = false;

    private ArrayList<Techniques> deck = new ArrayList<>();
    private ArrayList<Techniques> effetFinDeTour = new ArrayList<>();

    private int lifeBonus = 0;
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
    public void ajouterEffetFinDeTour(Techniques techniques){
        effetFinDeTour.add(techniques);
    }


    public ArrayList<Techniques> getEffetFinDeTour() {
        return effetFinDeTour;
    }

    public void setEffetFinDeTour(ArrayList<Techniques> effetFinDeTour) {
        this.effetFinDeTour = effetFinDeTour;
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

    public void pioche(){
        this.pioche++;
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

    public Adversaire getAdversaires() {
        return adversaires;
    }

    public void setAdversaires(Adversaire adversaires) {
        this.adversaires = adversaires;
    }

    public ArrayList<Techniques> listCarte(){
        return this.deck;
    }

    public void setDeck(ArrayList<Techniques> deck) {
        this.deck = deck;
    }

    public void ajouterCarte(Techniques techniques){
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

    public void setCarte(Techniques techniques){
        deck.add(techniques);
    }

    public void prendreDommages(int dommages){
        if(dommages -defense - defenseBonus > 0) {
            System.out.println("Vous recevez " + (dommages - defense - defenseBonus) + "(" + dommages + ")" + " dommages");
            this.life = this.life - (dommages - defense - defenseBonus);
        } else {
            System.out.println("Bon, l'attaque ne traverse pas votre armure, c'est toujours ça de pris");
        }
        if(this.life <1){
            System.out.println("Aïe, ça fait beaucoup de dommages tout ça, mis bout à bout... Ca suffit même à vous tuer...");
        }
    }

    public abstract ArrayList<ArtMartiaux> getArts();
    public abstract void setArtsLearned(ArtMartiaux artsLearned);
    public abstract ArrayList<ArtMartiaux> getArtsLearned();
    public abstract int getEndurance();
    public abstract void setEndurance(int endurance);
    public abstract void perteEndurance(int perte);
    public abstract void showPerso();
    public abstract ArrayList<Techniques> getDeck();
    public abstract void combatre(Scanner sc);

    public void resetBonus (){
        this.lifeBonus = 0;
        this.attaqueBonus = 0;
        this.defenseBonus = 0;
    }
}
