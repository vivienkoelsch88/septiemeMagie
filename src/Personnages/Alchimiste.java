package Personnages;

import Cartes.CartesGuerrier.ListeCarteGuerrier;
import Cartes.Techniques;

import java.util.ArrayList;

public class Alchimiste extends Warrior {
    private String classe = "Alchimiste";
    private ArrayList<Techniques> artsLearned = new ArrayList<>();
    private String fondEcran = "/img/fondEcranAlchimiste.jpg";
    private String[] desc;
    private String typeRessource = "";

    public Alchimiste() {
        super(50, 12, 5);
        super.setIcon("/img/iconAlchimiste.png");

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

    //    ********************************************************
    @Override
    public void setArtsLearned(Techniques artsLearned) {
        this.artsLearned.add(artsLearned);
    }

    @Override
    public ArrayList<Techniques> getArtsLearned() {
        return this.artsLearned;
    }

    @Override
    public String getTypeRessource() {
        return null;
    }

    @Override
    public int getRessource() {
        return 0;
    }

    @Override
    public void setRessource(int endurance) {

    }

    @Override
    public void perteRessource(int perte) {

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

    @Override
    public Techniques[] getListTechnique() {
        return ListeCarteGuerrier.getListeTechnique();
    }

}
