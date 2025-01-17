package com.cozystudios.fofrathzindustry;
import java.util.Random;
import java.awt.*;

public class Grid
{
    int columns =  16;
    int rows = 16;
    static int cellSize = 34;
    int width = columns * cellSize;
    int height = rows * cellSize;
    private Tile[][] LocalGrid;

    public static int GridToCoord(int tileInt){
        return (tileInt * cellSize) - cellSize;
    }

    public static int CoordToGrid(int coordinate){
        return (int)Math.floor(coordinate / cellSize) + 1;
    }

    public void drawGrid(Graphics2D g2)
    {
        populateGrid(g2);
        g2.setColor(Color.BLACK);
        for(int i= 0; i <= rows; i++)
        {
            for(int j = 0; j <= columns; j++)
            {
                g2.drawRect(j * cellSize, i * cellSize, cellSize, cellSize);
            }
        }
    }

    public void populateGrid(Graphics2D g2)
    {
        g2.setColor(Color.GREEN);
        for(int i= 0; i <= rows; i++)
        {
            for(int j = 0; j <= columns; j++)
            {
                //colorRandomizer(g2); // for experimentation purposes
                greenRandomizer(g2);
                g2.fillRect(j * cellSize + 1, i * cellSize + 1, cellSize - 1, cellSize - 1 );
            }
        }
    }

    private void colorRandomizer(Graphics2D g2)
    {
        Random randomize = new Random();
        float red = randomize.nextFloat();
        float green = randomize.nextFloat();
        float blue = randomize.nextFloat();

        Color randomColor = new Color(red, green, blue);

        g2.setColor(randomColor);
    }

    private void greenRandomizer(Graphics2D g2)
    {
        Random randomize = new Random();
        float red = randomize.nextFloat() / 10f;

        float green = randomize.nextFloat() + 0.25f ;
        if(green > 1f) green = 1f;

        float blue = randomize.nextFloat() / 10f;

        Color randomColor = new Color(red, green, blue);

        g2.setColor(randomColor);
    }

}
