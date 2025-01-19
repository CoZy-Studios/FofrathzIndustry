package com.cozystudios.fofrathzindustry;
import java.awt.*;
import java.util.Random;

public class Grid
{
    int columns = 64;
    int rows = 32;
    static int cellSize = 34;
    int width = columns * cellSize;
    int height = rows * cellSize;
    public Tile[][] localGrid = new Tile[rows + 1][columns + 1]; // +1, cos  +0 = 0-15, so +1 = 0-16 (we want it to go from 1-16)

    FastNoiseLite mapNoise = new FastNoiseLite();

    public static int GridToCoord(int tileInt)
    {
        return (tileInt * cellSize) - cellSize;
    }

    public static int CoordToGrid(int coordinate)
    {
        return (int)Math.floor(coordinate / cellSize) + 1;
    }

    public Grid() {
        Random randomize = new Random();

        mapNoise.SetNoiseType(FastNoiseLite.NoiseType.Cellular);
        mapNoise.SetCellularReturnType(FastNoiseLite.CellularReturnType.CellValue);
        mapNoise.SetFrequency(0.005f);
        mapNoise.SetSeed(randomize.nextInt(20000));

        for(int i = 1; i <= rows; i++)
        {
            for (int j = 1; j <= columns; j++)
            {
                localGrid[i][j] = new Tile();
            }
        }
    }

    public void drawGrid(Graphics2D g2)
    {
        for(int i = 0; i <= rows; i++)
        {
            for(int j = 0; j <= columns; j++)
            {
                g2.setColor(Color.BLACK);
                g2.drawRect(j * cellSize, i * cellSize, cellSize, cellSize);

                if(0 < i && i <= rows && 0 < j && j <= columns)
                {
                    float noiseValue = mapNoise.GetNoise(i * 50, j * 50);
                    if(noiseValue > 0.95)
                        localGrid[i][j].initialize(TileType.Coal, g2, i, j);
                    else if(noiseValue < 0.95 && noiseValue > 0.85)
                        localGrid[i][j].initialize(TileType.Copper, g2, i, j);
                    else
                        localGrid[i][j].initialize(TileType.Grass, g2, i, j);
                }
            }
        }
    }
}
