package Graphique.Bouton;

import Graphique.Fenetre;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class RetourChoixCarteCombat extends AbstractAction {
    private Fenetre fen;

    public RetourChoixCarteCombat(Fenetre fen) {
        super("Retour");
        this.fen = fen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.fen.getPanCombat().retourChoixCarte();
    }

}