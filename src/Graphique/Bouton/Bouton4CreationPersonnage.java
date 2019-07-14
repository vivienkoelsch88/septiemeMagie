package Graphique.Bouton;

import CartesGuerrier.Techniques;
import Graphique.Tuto.CreationPersonnage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Bouton4CreationPersonnage extends AbstractAction {
    private CreationPersonnage pan;
    private int idTechnique;
    private ArrayList<Techniques> listeTechnique;

    public Bouton4CreationPersonnage(CreationPersonnage pan, int idTechnique, ArrayList<Techniques> listeTechnique, String name) {
        super(name);
        this.pan = pan;
        this.idTechnique = idTechnique;
        this.listeTechnique = listeTechnique;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
