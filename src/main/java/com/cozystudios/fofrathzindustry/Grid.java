package com.cozystudios.fofrathzindustry;

import java.awt.*;

public class Grid
{
    int columns =  16;
    int rows = 16;
    int cellSize = 34;
    int width = columns * cellSize;
    int height = rows * cellSize;
    private Tile[][] LocalGrid;

    public static int GridToCoord(int tileInt){
        return (tileInt * 32) - 32;
    }

    public static int CoordToGrid(int coordinate){
        return (int)Math.floor(coordinate / 32) + 1;
    }

    public void drawGrid(Graphics2D g2)
    {
        for(int i= 0; i <= rows; i++)
        {
            for(int j = 0; j <= columns; j++)
            {
                g2.drawRect(j * cellSize, i * cellSize, cellSize, cellSize);
            }
        }
    }
}
