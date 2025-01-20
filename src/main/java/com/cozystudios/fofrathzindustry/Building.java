package com.cozystudios.fofrathzindustry;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Building
{
    private final int cellSize = Grid.cellSize;
    private BufferedImage testBuilding;
    private BuildingType buildingType;
    public int positionX;
    public int positionY;

    public void initialize(BuildingType type, Graphics2D g2, int posX, int posY)
    {
        buildingType = type;
        positionX = posX;
        positionY = posY;
        if(buildingType == BuildingType.Empty)
        {
            System.out.println("I am " + buildingType + " inside");
        }
        else
        {
            System.out.println("I am " + buildingType);
        }
        drawBuilding(g2);
    }

    public void getBuildingSprite()
    {
        try
        {
            testBuilding = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/BuildingTest.png")));
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void drawBuilding(Graphics2D g2)
    {
        //TEST
        g2.setColor(Color.white);
        //g2.fillRect(Grid.GridToCoord(positionX), Grid.GridToCoord(positionY), cellSize - 2, cellSize - 2);
        g2.drawString(buildingType.toString(), Grid.GridToCoord(positionX), Grid.GridToCoord(positionY));
        System.out.println("i got drawn at " + positionX + ", " + positionY);

        //g2.drawImage(testBuilding,coordinatesX, coordinatesY, cellSize, cellSize, null );
    }
}
