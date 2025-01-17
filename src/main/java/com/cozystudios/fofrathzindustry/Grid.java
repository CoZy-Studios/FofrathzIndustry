package com.cozystudios.fofrathzindustry;

public class Grid
{
    private Tile[][] LocalGrid;

    public static int GridToCoord(int tileInt){
        return (tileInt * 32) - 32;
    }

    public static int CoordToGrid(int coordinate){
        return (int)Math.floor(coordinate / 32) + 1;
    }
}
