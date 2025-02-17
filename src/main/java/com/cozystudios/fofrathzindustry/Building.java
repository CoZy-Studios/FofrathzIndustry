package com.cozystudios.fofrathzindustry;

import javax.imageio.ImageIO;
import javax.swing.text.Position;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class Building
{
    private final int cellSize = Grid.cellSize;
    private BufferedImage testBuilding;
    private BuildingType buildingType;
    private Grid grid;
    public BuildingDirection direction;
    public int positionX;
    public int positionY;

    public Building inputSource;
    public Building outputTarget;

    public List<Item> input = new ArrayList<Item>();
    public List<Item> output = new ArrayList<Item>();

    public float inputRate;
    public float outputRate;

    public enum BuildingDirection
    {
        north,
        east,
        south,
        west
    }

    public void initialize(BuildingType type, Graphics2D g2, int posX, int posY, BuildingDirection buildingDirection, Grid parentGrid)
    {
        buildingType = type;
        positionX = posX;
        positionY = posY;
        direction = buildingDirection;
        grid = parentGrid;

        if(buildingType == BuildingType.Empty)
        {
            System.out.println("I am " + buildingType + " inside");
        }
        else
        {
            System.out.println("I am " + buildingType);
            drawBuilding(g2);
        }
    }

    public void getBuildingSprite()
    {

        if(buildingType == BuildingType.Test)
        {
            try
            {
                testBuilding = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Building_"+buildingType.toString()+ "_" + direction.toString() + ".png")));
            }
            catch (IOException ignored)
            {
                System.out.println("could not get building sprite");
            }
        }
    }

    public void drawBuilding(Graphics2D g2)
    {
        //TEST
        g2.setColor(Color.white);
        g2.drawString(buildingType.toString(), Grid.GridToCoordinate(positionX), Grid.GridToCoordinate(positionY) + cellSize);
        System.out.println(buildingType + " got drawn at "+ positionX + ", " + positionY);
        getBuildingSprite();

        g2.drawImage(testBuilding, Grid.GridToCoordinate(positionX), Grid.GridToCoordinate(positionY), cellSize, cellSize, null);

    }

    public void rotateRight()
    {
        switch (direction)
        {
            case north -> direction = BuildingDirection.east;
            case east -> direction = BuildingDirection.south;
            case south -> direction = BuildingDirection.west;
            case west -> direction = BuildingDirection.north;
        }
    }
    public void rotateLeft()
    {
        switch (direction) {
            case north -> direction = BuildingDirection.west;
            case east -> direction = BuildingDirection.north;
            case south -> direction = BuildingDirection.east;
            case west -> direction = BuildingDirection.south;
        }
    }
    //TODO: implement a OnChange
    public void UpdateNextBuildingInput()
    {
        if(isTargetInBounds(direction, positionX, positionY))
        {
            switch (direction) {
                case north, south -> outputTarget = grid.GetBuildingFromCords(positionX, Grid.DirectionToNewCord(direction, positionY));
                case east, west -> outputTarget = grid.GetBuildingFromCords(Grid.DirectionToNewCord(direction, positionX), positionY);
            }
            if(outputTarget.buildingType != BuildingType.Empty)
            {
                outputTarget.input = output;
            }
        }
    }

    public boolean isTargetInBounds(BuildingDirection direction, int PositionX, int PositionY)
    {
        switch (direction) {
            case north -> {return !(0 >= PositionY - 1);}
            case east -> {return !(Grid.columns >= PositionX+1);}
            case south -> {return !(Grid.rows >= PositionY+1);}
            case west -> {return !(0 >= PositionX-1);}
            default -> {throw new RuntimeException("Invalid direction for In Bounds Check");}
        }
    }
    //TODO: Finish the other building Types
    private void SetOutput(BuildingType buildingType, Grid grid)
    {
        switch (buildingType) {
            case Test -> {}
            case Extractor ->
            {
                Item item = new Item();
                output.add(item);
                for(Item outputItem : output)
                {
                    TileType tileType = getTileType(positionX, positionY, grid);
                    switch (tileType) {
                        case Grass -> {item.Initialize(Item.ItemType.None, 0);}
                        case Copper -> {item.Initialize(Item.ItemType.Copper, 15);}
                        case Coal -> {item.Initialize(Item.ItemType.Coal, 15);}
                    }
                }
            }
            case Belt ->
            {output = input;}
            case Manufacturer -> {}
            case Empty -> {output.clear();}
            default -> throw new IllegalStateException("Unexpected value: " + buildingType);
        }
    }

    private TileType getTileType(int PosX, int PosY, Grid grid) {return grid.localGrid[PosX][PosY].getTileType();}
}
