package Graphique.Bouton;

import Graphique.Tuto.CreationPersonnage;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Bouton3CreationPersonnage extends AbstractAction {
    private String attribut;
    private Boolean value;
    private Boolean validate;
    private CreationPersonnage pan;

    public Bouton3CreationPersonnage(String attribut, Boolean value, Boolean validate, CreationPersonnage pan) {
        super(" M ");
        this.attribut = attribut;
        this.value = value;
        this.validate = validate;
        this.pan = pan;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(validate && pan.getPointsRestant() == 0){
                pan.attributsChoix();
        } else if (!validate) {
            switch (attribut){
                case "Concentration" :
                    if(value && pan.getWarrior().getConcentration() < 50 && pan.getPointsRestant() > 0){
                        pan.getWarrior().setConcentration(pan.getWarrior().getConcentration() + 1);
                        pan.retirerPoint();
                    } else if (pan.getWarrior().getConcentration() > 30 && !value && pan.getPointsRestant() < 30){
                        pan.getWarrior().setConcentration(pan.getWarrior().getConcentration() - 1);
                        pan.ajouterPoint();
                    }
                    pan.repaint();
                    break;

                case "Force" :
                    if(value && pan.getWarrior().getForce() < 50 && pan.getPointsRestant() > 0){
                        pan.getWarrior().setForce(pan.getWarrior().getForce() + 1);
                        pan.retirerPoint();
                    } else if (pan.getWarrior().getForce() > 30 && !value && pan.getPointsRestant() < 30){
                        pan.getWarrior().setForce(pan.getWarrior().getForce() - 1);
                        pan.ajouterPoint();
                    }
                    pan.repaint();
                    break;

                case "Adresse" :
                    if(value && pan.getWarrior().getAdresse() < 50 && pan.getPointsRestant() > 0){
                        pan.getWarrior().setAdresse(pan.getWarrior().getAdresse() + 1);
                        pan.retirerPoint();
                    } else if (pan.getWarrior().getAdresse() > 30 && !value && pan.getPointsRestant() < 30){
                        pan.getWarrior().setAdresse(pan.getWarrior().getAdresse() - 1);
                        pan.ajouterPoint();
                    }
                    pan.repaint();
                    break;

                case "Charisme" :
                    if(value && pan.getWarrior().getCharisme() < 50 && pan.getPointsRestant() > 0){
                        pan.getWarrior().setCharisme(pan.getWarrior().getCharisme() + 1);
                        pan.retirerPoint();
                    } else if (pan.getWarrior().getCharisme() > 30 && !value && pan.getPointsRestant() < 30){
                        pan.getWarrior().setCharisme(pan.getWarrior().getCharisme() - 1);
                        pan.ajouterPoint();
                    }
                    pan.repaint();
                    break;
            }
        }
    }
}
