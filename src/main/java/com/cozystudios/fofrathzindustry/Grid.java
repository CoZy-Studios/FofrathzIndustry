package com.cozystudios.fofrathzindustry;
import java.awt.*;
import java.util.Random;
import java.util.Vector;

public class Grid
{
    static int columns = 64;
    static int rows = 32;
    static int cellSize = 34;
    int width = columns * cellSize;
    int height = rows * cellSize;
    public Tile[][] localGrid = new Tile[columns + 1][rows + 1]; // +1, cos  +0 = 0-15, so +1 = 0-16 (we want it to go from 1-16)
    public Building[][] localBuildings = new Building[columns + 1][rows + 1];
    public Tile[][] currentlyVisibleLocalGrid = new Tile[16 + 1][16 + 1];
    public int currentlyVisibleLocalGridX = 1;
    public int currentlyVisibleLocalGridY = 1;
    boolean hasBeenGenerated;

    FastNoiseLite mapNoise = new FastNoiseLite();

    public static int GridToCoordinate(int tileInt)
    {
        return (tileInt * cellSize) - cellSize;
    }

    public static int CoordinateToGrid(int coordinate)
    {
        return (int)Math.floor((double) coordinate / cellSize) + 1;
    }

    public static int DirectionToNewCord(Building.BuildingDirection direction, int cordOnChangingAxis)
    {
        switch (direction) {
            case north, west -> {return cordOnChangingAxis - 1;}
            case east, south -> {return cordOnChangingAxis + 1;}
            default -> {throw new RuntimeException("Invalid direction to cord");}
        }
    }

    public Grid() {
        Random randomize = new Random();
        hasBeenGenerated = false;
        mapNoise.SetNoiseType(FastNoiseLite.NoiseType.Cellular);
        mapNoise.SetCellularReturnType(FastNoiseLite.CellularReturnType.CellValue);
        mapNoise.SetFrequency(0.005f);
        mapNoise.SetSeed(randomize.nextInt(20000));

        for(int i = 1; i <= rows; i++)
        {
            for (int j = 1; j <= columns; j++)
            {
                localGrid[j][i] = new Tile();
                localBuildings[j][i] = new Building();
                if(j < 17 && i < 17)
                {
                    currentlyVisibleLocalGrid[j][i] = localGrid[j][i];
                }
            }
        }
    }

    public void drawGrid(Graphics2D g2)
    {
        for(int i = 1; i <= rows; i++)
        {
            for(int j = 1; j <= columns; j++)
            {
                g2.setColor(Color.BLACK);
                g2.drawRect((j - 1) * cellSize, (i - 1) * cellSize, cellSize, cellSize);
                if(localGrid[j][i] != null && !localGrid[j][i].hasBeenGenerated)
                {
                    float noiseValue = mapNoise.GetNoise(j * 50, i * 50);
                    if(noiseValue > 0.95)
                        localGrid[j][i].initialize(TileType.Coal, j, i);
                    else if(noiseValue < -0.96)
                        localGrid[j][i].initialize(TileType.Copper, j, i);
                    else
                        localGrid[j][i].initialize(TileType.Grass, j, i);
                        localBuildings[j][i].initialize(BuildingType.Empty, g2, j, i, Building.BuildingDirection.north);
                }
                if()
                {
                    currentlyVisibleLocalGrid[j][i].drawTile(g2, j, i);
                }
            }
        }
    }

    public void MoveCurrentLocalGrid(Building.BuildingDirection direction)
    {
        switch (direction)
        {
            case north -> {}
            case east -> {}
            case south -> {}
            case west -> {}
        }

        for(int i = 1; i <= currentlyVisibleLocalGrid.length; i++)
        {
            for(int j = 1; j <= currentlyVisibleLocalGrid.length; j++)
            {
                currentlyVisibleLocalGrid[i][j] = localGrid[j][i];
            }
        }


    }
}
