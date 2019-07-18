package Graphique.Cinematique;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class Intro extends Frame {
    private CvStory canvas;


    public Intro () throws IOException
    {
        super ("Intro");
        addWindowListener (new WindowAdapter()
        {public void windowClosing (WindowEvent e){System.exit(0);}});
        setSize (1300, 700);
        canvas = new CvStory();
        add (canvas);
    }

    public void movePic ()
    {
        //for (int a = 0; a < 3600; a++)
        while (true)
        {

            try
            { Thread.sleep(10);}
            catch (InterruptedException e){}

            canvas.repaint();

        }
    }






    public static void readIntro() throws IOException {
        Intro Pic = new Intro();

        //try
        //{ Thread.sleep(500);}
        //catch (InterruptedException e){}

        Pic.show();
        Pic.movePic ();
    }





}
