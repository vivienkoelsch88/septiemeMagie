package Graphique.Bouton;

import Cartes.Techniques;
import Graphique.Fenetre;
import Graphique.Tuto.CreationPersonnage;
import Personnages.Warrior;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Bouton2AfficherCarte extends AbstractAction {
    private Fenetre fen;
    private Warrior warrior;
    private Techniques techniques;
    private CreationPersonnage creationPersonnage;

    public Bouton2AfficherCarte(Fenetre fen, Warrior warrior, Techniques techniques, CreationPersonnage creationPersonnage) {
        super("Choisir");
        this.fen = fen;
        this.warrior = warrior;
        this.techniques = techniques;
        this.creationPersonnage = creationPersonnage;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean verif = false;
        for (Techniques techniques : this.warrior.getDeck()) {
            if(techniques.equals(this.techniques)){
                verif = true;
            }
        }
        if(!verif) {
            this.warrior.ajouterCarteDeck(this.techniques);
        }
        this.fen.setContentPane(this.fen.getPanelEnCour());
        if(warrior.getDeck().size() > 4){
            creationPersonnage.finChoixCarte();
        }
    }
}
