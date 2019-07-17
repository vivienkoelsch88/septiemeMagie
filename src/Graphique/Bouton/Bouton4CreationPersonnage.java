package Graphique.Bouton;

import Cartes.AfficherCarte;
import Cartes.Techniques;
import Graphique.Tuto.CreationPersonnage;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Bouton4CreationPersonnage extends AbstractAction {
    private CreationPersonnage pan;
    private int idTechnique;
    private Techniques[] listeTechnique;

    public Bouton4CreationPersonnage(CreationPersonnage pan, int idTechnique, Techniques[] listeTechnique, String name) {
        super(name);
        this.pan = pan;
        this.idTechnique = idTechnique;
        this.listeTechnique = listeTechnique;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            AfficherCarte afficherCarte = new AfficherCarte(pan.getFen(), this.pan.getWarrior(), this.listeTechnique[idTechnique], pan);
            pan.getFen().setContentPane(afficherCarte);
            pan.getFen().setResizable(false);
            pan.getFen().addKeyListener(pan.getFen());

            this.pan.getFen().setVisible(true);
    }
}
