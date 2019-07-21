package Graphique.Bouton;

import Graphique.Fenetre;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class OrdreActionCombat   extends AbstractAction {
    private Fenetre fen;
    private int numAction;
    private int refAction;

    public OrdreActionCombat(Fenetre fen, int numAction, int refAction) {
        super("" + numAction);
        this.fen = fen;
        this.numAction = numAction;
        this.refAction = refAction;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.fen.getPanCombat().ordreAction(numAction, refAction);
    }

}