package Graphique.Cinematique;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class CvStory extends Canvas
{
    private String [] storyTxt;
    private double [][] pixels, pixels3D;
    private int storySize, maxX;
    private int numPixels = 0;
    private int defilementText = 40;
    private Image image;

    CvStory () throws IOException
    {
        ReadFile f = new ReadFile ("src\\TextCinematique\\Intro");

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        image = toolkit.getImage("src\\img\\tuto.jpg");

        storyTxt = f.getStory ();
        storySize = f.getSize ();

        pixels = new double [30000][3];
        pixels3D = new double [30000][3];

        BufferedImage bufferImg = new BufferedImage (650, 900,
                Image.SCALE_DEFAULT);
        Graphics gBuffer = bufferImg.getGraphics ();

        Font g = new Font ("Arial", Font.PLAIN, 15);
        gBuffer.setFont(g);

        for (int i = 0; i < storySize; i++)
            gBuffer.drawString (storyTxt [i], 50, i * 20 + 30);

        for (int i = 0; i < 650 - 1; i++)
            for (int j = 0; j < 900 - 1; j++)
                if (bufferImg.getRGB (i, j) == -1)
                {
                    pixels[numPixels][0] = 0;
                    pixels[numPixels][1] = i - 135;
                    pixels[numPixels][2] = j + 410;

                    numPixels = numPixels + 1;

                }

    }

    public void paint (Graphics g) {
        Dimension d = getSize();

        maxX = d.width - 1;

        double t = 0.0, Eye = 635.0;

        int originX = maxX / 5;

        BufferedImage bufferImg = new BufferedImage (getWidth(), getHeight(),
                Image.SCALE_DEFAULT);
        Graphics gBuffer = bufferImg.getGraphics ();

        rotateY(-59);

        gBuffer.setColor(Color.white);

        for (int i = 0; i < numPixels; i++)
            for (int j = 0; j < 3; j++)
            {

                if (j == 0)
                    t = 1.0 / (1.0 - (pixels[i][j] / Eye));
                else
                    pixels3D[i][j - 1] = t * pixels[i][j];
            }

        for (int i = 0; i < numPixels; i++)
        {
            gBuffer.drawLine ((int) Math.round(originX + pixels3D[i][0]),
                    (int) Math.round(pixels3D[i][1])+ 1,
                    (int) Math.round(originX + pixels3D[i][0]),
                    (int) Math.round(pixels3D[i][1])- 1);
            gBuffer.drawLine ((int) Math.round(originX + pixels3D[i][0])+ 1,
                    (int) Math.round(pixels3D[i][1])+ 1,
                    (int) Math.round(originX + pixels3D[i][0])+ 1,
                    (int) Math.round(pixels3D[i][1])- 1);
            gBuffer.drawLine ((int) Math.round(originX + pixels3D[i][0])- 1,
                    (int) Math.round(pixels3D[i][1])+ 1,
                    (int) Math.round(originX + pixels3D[i][0])- 1,
                    (int) Math.round(pixels3D[i][1])- 1);
        }

        try
        { Thread.sleep(defilementText);}
        catch (InterruptedException e){}

        g.drawImage (bufferImg, 0, 0, this);
        rotateY(59);
        transPic (0, 0, -2);

//        Graphics2D g2d = (Graphics2D) g;
//        g2d.drawImage(image,0,0,this);

    }

    public void rotateY (double ry)
    {
        double radAngle = (ry * Math.PI) / 180,
                newX = 0,
                newY = 0,
                newZ = 0;

        for (int i = 0; i < numPixels; i++)
        {
            newX = (pixels[i][0] * Math.cos (radAngle)) +
                    (pixels[i][2] * (- Math.sin (radAngle)));
            newY = pixels[i][1];
            newZ = (pixels[i][0] * Math.sin (radAngle)) +
                    (pixels[i][2] * Math.cos (radAngle));

            pixels[i][0] = newX;
            pixels[i][1] = newY;
            pixels[i][2] = newZ;
        }

    }

    public void transPic (double sx, double sy, double sz)
    {

        for (int i = 0; i < numPixels; i++)
        {
            pixels[i][0] = pixels[i][0] + sx;
            pixels[i][1] = pixels[i][1] + sy;
            pixels[i][2] = pixels[i][2] + sz;
        }

    }

//    ****************************************************************************************

    public void update (Graphics g)
    {
        paint(g);
    }
}

class ReadFile
{

    private BufferedReader inFile;
    private String line;
    private int numLine = 0;
    private String story [] = new String [40];

    ReadFile (String file) throws IOException {

        inFile = new BufferedReader (new FileReader(file));

        line = inFile.readLine();

        while (line != null)
        {

            story [numLine] = line;
            ++numLine;
            line = inFile.readLine();
        }

        inFile.close();
    }

//    ****************************************************************************************

    public int getSize ()
    {
        return numLine;

    }

    public String [] getStory ()
    {
        return story;
    }
}