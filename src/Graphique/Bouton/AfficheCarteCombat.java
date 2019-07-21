package Graphique.Bouton;

import Graphique.Fenetre;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AfficheCarteCombat extends AbstractAction {
    private Fenetre fen;
    private int numeroCarte;

    public AfficheCarteCombat(Fenetre fen, int numeroCarte, String name) {
        super(name);
        this.fen = fen;
        this.numeroCarte = numeroCarte;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.fen.getPanCombat().afficheCarte(numeroCarte);
    }

}
