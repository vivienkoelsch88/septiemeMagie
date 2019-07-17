package Graphique.Tuto;

import Personnages.Warrior;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FenetreWarriors extends JFrame implements KeyListener, ActionListener {

    private PanWarriors pan;

    public FenetreWarriors(Warrior choixWarrior) throws HeadlessException {
        this.pan = new PanWarriors(choixWarrior);

        this.setTitle("Info Personnage");
        this.setSize(1200, 700);
        this.setLocationRelativeTo(null);
        this.setContentPane(pan);
        setResizable(false);
        addKeyListener(this);

        this.setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {

            pan.keyPressed(e);
    }

    //    ******************************************************************************************
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
