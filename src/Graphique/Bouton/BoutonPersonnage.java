package Graphique.Bouton;

import Graphique.Fenetre;
import Personnages.ProfilPersonnage;
import Personnages.Warrior;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class BoutonPersonnage extends AbstractAction {
    private Fenetre fen;
    private Warrior warrior;

    public BoutonPersonnage(Fenetre fen, Warrior warrior) {
        this.fen = fen;
        this.warrior = warrior;
    }

    public void actionPerformed(ActionEvent e) {
        ProfilPersonnage afficherCarte = new ProfilPersonnage(this.fen, this.warrior);
        fen.setContentPane(afficherCarte);
        fen.setResizable(false);
        fen.addKeyListener(fen);

        fen.setVisible(true);
    }
}
