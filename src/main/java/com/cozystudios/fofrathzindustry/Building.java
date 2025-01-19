package com.cozystudios.fofrathzindustry;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Building extends Tile
{
    private final int cellSize = Grid.cellSize;
    private BufferedImage testBuilding;
    private BuildingType buildingType;

    public void Initialize(BuildingType type)
    {
        buildingType = type;
    }

    public void getBuildingSprite()
    {
        try
        {
            testBuilding = ImageIO.read(getClass().getResourceAsStream("/BuildingTest.png"));
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void drawBuilding(Graphics2D g2, int gridPositionX, int gridPositionY)
    {
        int coordinatesX = gridPositionX * cellSize;
        int coordinatesY = gridPositionY * cellSize;
        g2.drawImage(testBuilding,coordinatesX, coordinatesY, cellSize, cellSize, null );
    }
}
