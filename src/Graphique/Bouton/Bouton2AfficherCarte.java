package Graphique.Bouton;

import Graphique.Fenetre;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Bouton2AfficherCarte extends AbstractAction {
    private Fenetre fen;

    public Bouton2AfficherCarte(Fenetre fen) {
        super("Choisir");
        this.fen = fen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.fen.setContentPane(this.fen.getPanelEnCour());
    }
}
