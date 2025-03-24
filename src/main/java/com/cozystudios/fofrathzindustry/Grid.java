package com.cozystudios.fofrathzindustry;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Grid
{
    static int columns = 38;
    static int rows = 24;
    static int cellSize = 34;
    int width = columns * cellSize;
    int height = rows * cellSize;
    public Tile[][] localGrid = new Tile[columns + 1][rows + 1]; // +1, cos  +0 = 0-15, so +1 = 0-16 (we want it to go from 1-16)
    private List<Building> _buildings;

    FastNoiseLite mapNoise = new FastNoiseLite();

    public static int GridToCoordinate(int tileInt)
    {
        return (tileInt * cellSize) - cellSize;
    }

    public static int CoordinateToGrid(int coordinate)
    {
        return (int)Math.floor(coordinate / cellSize) + 1;
    }

    public Building DirectionToBuilding(Building.BuildingDirection direction, int thisPosX , int thisPosY)
    {
        if(Building.isTargetInBounds(direction, thisPosX, thisPosY))
        {
            int targetPosX = thisPosX;
            int targetPosY = thisPosY;

            switch (direction) {
                case North -> { targetPosY -= 1;}
                case East -> { targetPosX += 1;}
                case South -> {targetPosY += 1;}
                case West -> {targetPosX -= 1;}
            }

            for(Building building : GetBuildings())
            {
                if(building.positionX == targetPosX && building.positionY == targetPosY)
                {
                    return building;
                }
            }

        }
        return null;
    }

    public static Point PointToGrid(Point point){
        return new Point(CoordinateToGrid(point.x), CoordinateToGrid(point.y));
    }

    public Grid() {
        _buildings = new ArrayList<>();
        Random randomize = new Random();

        mapNoise.SetNoiseType(FastNoiseLite.NoiseType.Cellular);
        mapNoise.SetCellularReturnType(FastNoiseLite.CellularReturnType.CellValue);
        mapNoise.SetFrequency(0.005f);
        mapNoise.SetSeed(randomize.nextInt(20000));

        for(int i = 1; i <= rows; i++)
        {
            for (int j = 1; j <= columns; j++)
            {
                localGrid[j][i] = new Tile();
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
                g2.drawRect((j - 1) * cellSize, (i - 1) * cellSize, cellSize, cellSize);

                if(0 < i && i <= rows && 0 < j && j <= columns)
                {
                    float noiseValue = mapNoise.GetNoise(j * 50, i * 50);
                    if(noiseValue > 0.95)
                        localGrid[j][i].initialize(TileType.Coal, g2, j, i);
                    else if(noiseValue < -0.96)
                        localGrid[j][i].initialize(TileType.Copper, g2, j, i);
                    else
                        localGrid[j][i].initialize(TileType.Grass, g2, j, i);
                }
            }
        }
    }

    public List<Building> GetBuildings(){
        return _buildings;
    }

    public void AddBuilding(Building building){
        _buildings.add(building);
        System.out.println("Added building to building List: " + building.buildingType);
    }

    public void removeBuildingAt(Point point){
        Building toRemove = null;
        for(Building building : _buildings){
            if(building.positionX == point.x && building.positionY == point.y){
                toRemove = building;
            }
        }

        if(toRemove != null){
            _buildings.remove(toRemove);
            Logger.log(this.getClass(), "Tried removing building at: " + toRemove.positionX + "X, " + toRemove.positionY + "Y");
        }
    }

    public TileType getGridTileType(int posX, int posY){
        return localGrid[posX][posY].GetTileType();
    }
}