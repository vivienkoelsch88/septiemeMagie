package Graphique.Bouton;

import Personnages.ProfilPersonnage;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Bouton2Personnage extends AbstractAction {
    private ProfilPersonnage profil;

    public Bouton2Personnage(ProfilPersonnage profil) {
        this.profil = profil;
    }

    public void actionPerformed(ActionEvent e) {
        profil.removeAll();
        profil.changeVue();
        profil.repaint();
    }
}
