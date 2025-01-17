package com.cozystudios.fofrathzindustry;

import java.awt.*;
import java.util.Random;

//parent class to Local /
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
            case Grass -> greenRandomizer(g2);
            case Coal -> blackRandomizer(g2);
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
            tileType = tileType.Copper;
        }
        else
        {
            throw new IllegalStateException("Unexpected value: " + tileRandomizerValue);
        }
    }

    private void greenRandomizer(Graphics2D g2)
    {
        Random randomize = new Random();
        float red = randomize.nextFloat() / 10f;

        float green = randomize.nextFloat() + 0.25f ;
        if(green > 1f) green = 1f;

        float blue = randomize.nextFloat() / 10f;

        Color randomColor = new Color(red, green, blue);

        g2.setColor(randomColor);
    }
    private void blackRandomizer(Graphics2D g2)
    {
        Random randomize = new Random();
        float red = randomize.nextFloat() / 20f;

        float green = randomize.nextFloat() /20f ;

        float blue = randomize.nextFloat() / 20f;

        Color randomColor = new Color(red, green, blue);

        g2.setColor(randomColor);
    }



}
