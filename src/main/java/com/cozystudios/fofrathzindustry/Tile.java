package com.cozystudios.fofrathzindustry;

import java.awt.*;

import static com.cozystudios.fofrathzindustry.ColorHelper.*;

public class Tile
{
    private TileType tileType;
    private Color tileColor = Color.white;

    public void initialize(TileType type, Graphics2D g2, int gridPositionX, int gridPositionY)
    {
        tileType = type;
        if(tileColor == Color.white)
        {
            switch(tileType)
            {
                case Grass -> tileColor = grassRandomizer();
                case Coal -> tileColor = coalRandomizer();
                case Copper -> tileColor = copperRandomizer();
                default -> g2.setColor(Color.WHITE);
            }
        }

        Logger.log(this.getClass(), "Initializing tile: " + tileType );
        drawTile(g2 ,gridPositionX ,gridPositionY);
    }

    protected void drawTile(Graphics2D g2, int positionX, int positionY)
    {
        g2.setColor(tileColor);
        g2.fillRect((positionX - 1) * Grid.cellSize + 1, (positionY - 1) * Grid.cellSize + 1, Grid.cellSize - 1, Grid.cellSize - 1);
        Logger.log(this.getClass(), "Drawing tile: " + tileType );
    }

    public TileType GetTileType(){
        return tileType;
    }
}
