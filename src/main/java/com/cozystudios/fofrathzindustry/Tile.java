package com.cozystudios.fofrathzindustry;

import java.awt.*;
import java.util.Random;

import static com.cozystudios.fofrathzindustry.ColorHelper.*;

public class Tile
{
    private TileType tileType;
    int ID;

    public void initialize(TileType type, Graphics2D g2, int gridPositionX, int gridPositionY)
    {
        tileType = type;
        System.out.println("tile initialized, I am " + tileType);
        drawTile(g2 ,gridPositionX ,gridPositionY);
    }

    protected void drawTile(Graphics2D g2, int positionX, int positionY)
    {

        switch(tileType)
        {
            case Grass -> g2.setColor(greenRandomizer());
            case Coal -> g2.setColor(blackRandomizer());
            default -> g2.setColor(Color.WHITE);
        }
        g2.fillRect((positionX - 1) * Grid.cellSize + 1, (positionY - 1) * Grid.cellSize + 1, Grid.cellSize - 1, Grid.cellSize - 1);
    }
}
