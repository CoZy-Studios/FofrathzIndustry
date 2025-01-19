package com.cozystudios.fofrathzindustry;
import java.awt.*;

public class Grid
{
    int columns = 16;
    int rows = 16;
    static int cellSize = 34;
    int width = columns * cellSize;
    int height = rows * cellSize;
    public Tile[][] localGrid = new Tile[rows + 1][columns + 1]; // +1, cos  +0 = 0-15, so +1 = 0-16 (we want it to go from 1-16)

    FastNoiseLite mapNoise = new FastNoiseLite();

    public Grid() {
        for(int i = 1; i <= rows; i++)
        {
            for (int j = 1; j <= columns; j++)
            {
                localGrid[i][j] = new Tile();
            }
        }
    }

    public static int GridToCoord(int tileInt)
    {
        return (tileInt * cellSize) - cellSize;
    }

    public static int CoordToGrid(int coordinate)
    {
        return (int)Math.floor(coordinate / cellSize) + 1;
    }

    public void drawGrid(Graphics2D g2)
    {
        for(int i= 0; i <= rows; i++)
        {
            for(int j = 0; j <= columns; j++)
            {
                g2.setColor(Color.BLACK);
                g2.drawRect(j * cellSize, i * cellSize, cellSize, cellSize);

                if(0 < i && i < rows + 1 && 0 < j && j < columns + 1)
                {
                    localGrid[i][j].initialize(TileType.Grass, g2, i, j);
                }
            }
        }
    }
}
