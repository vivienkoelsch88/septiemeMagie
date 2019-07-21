package Graphique.Bouton;

import Graphique.Fenetre;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ActiverCarteCombat  extends AbstractAction {
    private Fenetre fen;

    public ActiverCarteCombat(Fenetre fen) {
        super("Choisir");
        this.fen = fen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.fen.getPanCombat().activerCarteChoisie();
    }

}