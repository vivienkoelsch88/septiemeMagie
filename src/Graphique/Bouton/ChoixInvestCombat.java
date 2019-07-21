package Graphique.Bouton;

import Graphique.Fenetre;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ChoixInvestCombat extends AbstractAction {
    private Fenetre fen;
    private int refAction;
    private int value;

    public ChoixInvestCombat(Fenetre fen, int value, int refAction) {
        super("" + value);
        this.fen = fen;
        this.value = value;
        this.refAction = refAction;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.fen.getPanCombat().modifierInvest(refAction, value);
    }

}