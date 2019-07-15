package Graphique.Bouton;

import Personnages.ProfilPersonnage;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Bouton3Personnage extends AbstractAction {
      private ProfilPersonnage profilPersonnage;
      private int placement;

    public Bouton3Personnage(ProfilPersonnage profilPersonnage, int placement) {
        super("" + placement);
        this.profilPersonnage = profilPersonnage;
        this.placement = placement;
    }

    public void actionPerformed(ActionEvent e) {
        if(profilPersonnage.getEmplacementTechniqueADeplacer() == 1000) {
            profilPersonnage.setTechniquesADeplacer(profilPersonnage.getWarrior().getDeck().get(placement - 1));
            profilPersonnage.setEmplacementTechniqueADeplacer(placement - 1);
        } else {
            profilPersonnage.getWarrior().getDeck().set(profilPersonnage.getEmplacementTechniqueADeplacer(), profilPersonnage.getWarrior().getDeck().get(placement - 1));
            profilPersonnage.getWarrior().getDeck().set(placement - 1, profilPersonnage.getTechniquesADeplacer());
            profilPersonnage.setEmplacementTechniqueADeplacer(1000);
        }
        profilPersonnage.repaint();
    }

}
