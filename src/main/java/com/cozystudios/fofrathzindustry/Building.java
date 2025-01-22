package com.cozystudios.fofrathzindustry;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Building
{
    private final int cellSize = Grid.cellSize;
    private BufferedImage testBuildingNorth, testBuildingSouth, testBuildingEast, testBuildingWest, testBuilding;
    private BuildingType buildingType;
    public BuildingDirection direction;
    public int positionX;
    public int positionY;

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
                testBuilding = ImageIO.read(getClass().getResourceAsStream("/BuildingTest" + buildingType.toString() + ".png"));

                testBuildingNorth = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/BuildingTestNorth.png")));
                testBuildingEast = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/BuildingTestEast.png")));
                testBuildingSouth = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/BuildingTestSouth.png")));
                testBuildingWest = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/BuildingTestWest.png")));
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

        //switch (direction){
        //    case north:
        //        g2.drawImage(testBuildingNorth, Grid.GridToCoordinate(positionX), Grid.GridToCoordinate(positionY), cellSize, cellSize, null );
        //        break;
        //    case south:
        //        g2.drawImage(testBuildingSouth, Grid.GridToCoordinate(positionX), Grid.GridToCoordinate(positionY), cellSize, cellSize, null );
        //        break;
        //    case east:
        //        g2.drawImage(testBuildingEast, Grid.GridToCoordinate(positionX), Grid.GridToCoordinate(positionY), cellSize, cellSize, null );
        //        break;
        //    case west:
        //        g2.drawImage(testBuildingWest, Grid.GridToCoordinate(positionX), Grid.GridToCoordinate(positionY), cellSize, cellSize, null );
        //        break;
        //}
    }
}
