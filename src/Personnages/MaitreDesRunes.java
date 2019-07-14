package Personnages;

import Cartes.CartesGuerrier.Techniques;

import java.util.ArrayList;

public class MaitreDesRunes extends Warrior {
    private int harmonie;
    private String classe = "Maitre des runes";
    private ArrayList<Techniques> artsLearned = new ArrayList<>();
    private String fondEcran = "/img/fondEcranRunique.jpg";
    private String[] desc;

    public MaitreDesRunes() {
        super(60, 14, 7);
        this.harmonie = 100;

        this.desc = new String[]{
                "Le Lorem Ipsum est simplement du faux texte employé ",
                "dans la composition et la mise en page avant impression. ",
                "Le Lorem Ipsum est le faux texte standard de l'imprimerie",
                "depuis les années 1500, quand un imprimeur anonyme",
                "assembla ensemble des morceaux de texte pour réaliser",
                "un livre spécimen de polices de texte. Il n'a pas fait",
                "que survivre cinq siècles, mais s'est aussi adapté à",
                "la bureautique informatique, sans que son contenu ",
                "n'en soit modifié. Il a été popularisé dans les ",
                "années 1960 grâce à la vente de feuilles Letraset",
                "contenant des passages du Lorem Ipsum, et, plus",
                "récemment, par son inclusion dans des applications",
                "de mise en page de texte, comme Aldus PageMaker."
        };
    }

//    ************************ Getter and setter **************************


    @Override
    public void setArtsLearned(Techniques artsLearned) {
    }

    @Override
    public ArrayList<Techniques> getArtsLearned() {
        return artsLearned;
    }

    @Override
    public int getRessource() {
        return harmonie;
    }

    @Override
    public void setRessource(int endurance) {
        this.harmonie = endurance;
    }

    @Override
    public void perteRessource(int perte) {
        this.harmonie = this.harmonie - perte;
        if(this.harmonie < 0){
            super.setLife(super.getLife() + this.harmonie);
            this.harmonie = 0;
        }
    }

    @Override
    public ArrayList<Techniques> getDeck() {
        ArrayList<Techniques> deck = super.listCarte();

        deck.addAll(artsLearned);

        return deck;
    }

    @Override
    public String getFondEcran() {
        return fondEcran;
    }

    @Override
    public String getClasse() {
        return classe;
    }

    @Override
    public String[] getDesc() {
        return desc;
    }

}
