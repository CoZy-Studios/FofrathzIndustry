package com.cozystudios.fofrathzindustry;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Building
{
    private final int cellSize = Grid.cellSize;

    private BufferedImage buildingImage;
    private BufferedImage copperOreItemImage;
    private BufferedImage  coalItemImage;
    private BufferedImage copperIngotItemImage;
    private BufferedImage copperWireItemImage;

    public BuildingType buildingType;
    public BuildingDirection direction;
    private TileType _standingOnTile;
    public int positionX;
    public int positionY;

    public List<Item> input = new ArrayList<Item>();


    public float inputRate = 0;
    public float outputRate = 0;


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

        getBuildingSprite();
    }

    public Item getOutput()
    {
        switch (buildingType) {
            case Test, Empty -> {return null;}
            case Extractor ->
            {
                if(Item.TileToItemType(_standingOnTile) != null)
                {
                    return new Item(Item.TileToItemType(_standingOnTile));
                }
                else return null;
            }
            case Manufacturer -> {
                if(input.size() > 1){
                    int found = 0;
                    for(Item item : input){
                        if(item.getItemType() == Item.ItemType.Iron || item.getItemType() == Item.ItemType.Coal)
                            found = 1;
                        if(item.getItemType() == Item.ItemType.Coal || item.getItemType() == Item.ItemType.Iron){
                            if(found == 1){
                                return new Item(Item.ItemType.Steel);
                            }
                        }
                    }
                }
                if(input.size() > 0){
                    switch(input.get(0).getItemType()){
                        case Copper -> { return new Item(Item.ItemType.CopperIngot); }
                        case CopperIngot -> {return new Item(Item.ItemType.CopperWire);}
                        default -> {return null;}
                    }
                }
            }
            default ->
            {
                if(!input.isEmpty()) return input.get(0);
                else return null;
            } //Belt is default
        }

        return null;
    }



    public void getBuildingSprite()
    {
        try
        {
            buildingImage = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Building_"+buildingType.toString()+ "_" + direction.toString() + ".png")));
            coalItemImage = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/coalItem.png")));
            copperOreItemImage = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/copperOreItem.png")));
            copperIngotItemImage = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/copperIngotItem.png")));
            copperWireItemImage = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/copperWireItem.png")));

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
        //g2.setColor(Color.white);
        //g2.drawString(buildingType.toString(), Grid.GridToCoordinate(positionX), Grid.GridToCoordinate(positionY) + cellSize);
        Logger.log(this.getClass(), "Drawing building: " + buildingType);


        g2.drawImage(buildingImage, Grid.GridToCoordinate(positionX), Grid.GridToCoordinate(positionY), cellSize, cellSize, null);

        if(!input.isEmpty())
        {
            switch (input.get(0)._itemType) {
                case None -> {}
                case Copper -> {g2.drawImage(copperOreItemImage, Grid.GridToCoordinate(positionX), Grid.GridToCoordinate(positionY), cellSize, cellSize, null);}
                case Iron -> {}
                case IronIngot -> {}
                case Coal -> {g2.drawImage(coalItemImage, Grid.GridToCoordinate(positionX), Grid.GridToCoordinate(positionY), cellSize, cellSize, null);}
                case CopperIngot -> {g2.drawImage(copperIngotItemImage, Grid.GridToCoordinate(positionX), Grid.GridToCoordinate(positionY), cellSize, cellSize, null);}
                case CopperWire -> {g2.drawImage(copperWireItemImage, Grid.GridToCoordinate(positionX), Grid.GridToCoordinate(positionY), cellSize, cellSize, null);}
                case Steel -> {}
            }

        }

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

        getBuildingSprite();
    }
    public void rotateLeft()
    {
        switch (direction) {
            case North -> direction = BuildingDirection.West;
            case East -> direction = BuildingDirection.North;
            case South -> direction = BuildingDirection.East;
            case West -> direction = BuildingDirection.South;
        }

        getBuildingSprite();
    }

    public static boolean isTargetInBounds(BuildingDirection direction, int PositionX, int PositionY)
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

    public void UpdateInput(Item item, float InputRate)
    {
        //TODO add version for when a building is removed
        //TODO add something to merge multiple inputs
        if(item != null){
            inputRate = InputRate;
            input.add(item);
        }
    }

    public void SetStandingOnTileType(TileType newType){
        _standingOnTile = newType;
    }
}
