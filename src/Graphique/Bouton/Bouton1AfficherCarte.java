package Graphique.Bouton;

import Graphique.Fenetre;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Bouton1AfficherCarte extends AbstractAction {
    private Fenetre fen;

    public Bouton1AfficherCarte(Fenetre fen) {
        super("Retour");
        this.fen = fen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.fen.setContentPane(this.fen.getPanelEnCour());
    }
}
