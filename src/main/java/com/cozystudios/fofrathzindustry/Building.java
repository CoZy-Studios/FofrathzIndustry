package com.cozystudios.fofrathzindustry;

import javax.imageio.ImageIO;
import javax.swing.text.Position;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Building
{
    private final int cellSize = Grid.cellSize;
    private BufferedImage testBuilding;
    private BuildingType buildingType;
    public BuildingDirection direction;
    public int positionX;
    public int positionY;

    public Building inputSource;
    public Building OutputTarget;

    public Item input[];
    public Item output[];

    public float inputRate;
    public float outputRate;

    public enum BuildingDirection
    {
        north,
        east,
        south,
        west
    }

    public void initialize(BuildingType type, Graphics2D g2, int posX, int posY, BuildingDirection buildingDirection)
    {
        buildingType = type;
        positionX = posX;
        positionY = posY;
        direction = buildingDirection;
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
}
