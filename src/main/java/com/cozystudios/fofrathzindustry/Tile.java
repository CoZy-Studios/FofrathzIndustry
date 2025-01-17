package com.cozystudios.fofrathzindustry;

import java.awt.*;

//parent class to Local / Map tiles?
public class Tile
{
    //int groundTileTextureID;
    //int buildingTileTextureID;
    int ID;

    public void initialize(Graphics2D g2, Grid parentGrid, int gridPositionX, int gridPositionY)
    {
        System.out.println("tile initialized");

        parentGrid.drawTile(g2 ,gridPositionX ,gridPositionY);
    }

}
