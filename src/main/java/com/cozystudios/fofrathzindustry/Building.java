package com.cozystudios.fofrathzindustry;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class Building
{
    private final int cellSize = Grid.cellSize;
    private BufferedImage buildingImage;
    public BuildingType buildingType;
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
        North,
        East,
        South,
        West
    }

    public static String[] getBuildingNames(){
        return Arrays.toString(BuildingType.values()).replaceAll("^.|.$", "").split(", ");
    }

    public Building(BuildingType type, int posX, int posY, BuildingDirection buildingDirection)
    {
        buildingType = type;
        positionX = posX;
        positionY = posY;
        direction = buildingDirection;
        if(buildingType == BuildingType.Empty)
        {
           Logger.log(this.getClass(), "Building type is Empty");
        }
        else
        {
            Logger.log(this.getClass(), "Building type is: " + buildingType);
        }
    }

    public void getBuildingSprite()
    {
            try
            {
                buildingImage = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Building_"+buildingType.toString()+ "_" + direction.toString() + ".png")));
            }
            catch (IOException ignored)
            {
                Logger.log(this.getClass(), "Could not load Building_"+ buildingType.toString() + ".png");
            }
    }

    public void setPosition(Point newPosition){
        positionX = newPosition.x;
        positionY = newPosition.y;
    }

    public void drawBuilding(Graphics2D g2)
    {
        //TEST
        g2.setColor(Color.white);
        g2.drawString(buildingType.toString(), Grid.GridToCoordinate(positionX), Grid.GridToCoordinate(positionY) + cellSize);
        Logger.log(this.getClass(), "Drawing building: " + buildingType);
        getBuildingSprite();

        g2.drawImage(buildingImage, Grid.GridToCoordinate(positionX), Grid.GridToCoordinate(positionY), cellSize, cellSize, null);

    }

    public void rotateRight()
    {
        switch (direction)
        {
            case North -> direction = BuildingDirection.East;
            case East -> direction = BuildingDirection.South;
            case South -> direction = BuildingDirection.West;
            case West -> direction = BuildingDirection.North;
        }
    }
    public void rotateLeft()
    {
        switch (direction) {
            case North -> direction = BuildingDirection.West;
            case East -> direction = BuildingDirection.North;
            case South -> direction = BuildingDirection.East;
            case West -> direction = BuildingDirection.South;
        }
    }

    public boolean isTargetInBounds(BuildingDirection direction, int PositionX, int PositionY)
    {
        switch (direction) {
            case North -> {return !(0 >= PositionY - 1);}
            case East -> {return !(Grid.columns >= PositionX+1);}
            case South -> {return !(Grid.rows >= PositionY+1);}
            case West -> {return !(0 >= PositionX-1);}
            default -> {throw new RuntimeException("Invalid direction for In Bounds Check");}
        }
    }

    public void AffectedByChange()
    {
        Logger.log(this.getClass(), "AffectedByChange");
    }
}
