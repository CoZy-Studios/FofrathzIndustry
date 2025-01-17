package com.cozystudios.fofrathzindustry;

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
        //populateGrid(g2);
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
        for(int i= 0; i <= rows; i++)
        {
            for(int j = 0; j <= columns; j++)
            {
                g2.setColor(Color.GREEN);
                g2.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
            }
        }
    }
}
