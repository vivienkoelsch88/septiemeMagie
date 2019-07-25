package Graphique.Tuto;

import javax.swing.*;
import java.awt.*;

public class EcranDeMort extends JComponent {

    public void paintComponent(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRoundRect(0 , 0, this.getWidth(), this.getHeight(), 0, 0);
        g.setColor(Color.RED);
        Font font = new Font("desc", Font.BOLD, 40);
        g.setFont(font);
        g.drawString("Vous êtes morts...", this.getWidth()/8, this.getHeight()/3);
    }
}
