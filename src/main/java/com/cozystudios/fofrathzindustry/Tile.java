package com.cozystudios.fofrathzindustry;

import java.awt.*;
import java.util.Random;

import static com.cozystudios.fofrathzindustry.ColorHelper.*;

public class Tile
{
    private TileType tileType;
    int ID;

    public Tile(TileType type)
    {
        tileType = type;
    }

    public void initialize(Graphics2D g2, Grid grid, int gridPositionX, int gridPositionY)
    {
        randomizeTileType();
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

    private void randomizeTileType()
    {
        Random random = new Random();
        int tileRandomizerValue = random.nextInt(1,100);

        if (tileRandomizerValue <= 75)
        {
            tileType = TileType.Grass;
        }
        else if(tileRandomizerValue > 75 && tileRandomizerValue <= 85)
        {
            tileType = TileType.Coal;
        }
        else if(tileRandomizerValue > 85)
        {
            tileType = TileType.Copper;
        }
        else
        {
            throw new IllegalStateException("Unexpected value in tileType randomizer: " + tileRandomizerValue);
        }
    }
}
