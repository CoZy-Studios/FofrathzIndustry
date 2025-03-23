package com.cozystudios.fofrathzindustry;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class GamePanel extends JPanel implements Runnable
{
    Grid grid;
    MouseHandler mouseHandler = new MouseHandler(this);
    KeyHandler keyHandler = new KeyHandler(this);

    Thread gameThread;

    int fps = 60;
    public int clicked = 0;
    public AtomicInteger rotateLeft = new AtomicInteger(0);
    public AtomicInteger rotateRight = new AtomicInteger(0);

    private final AtomicBoolean placingBuilding = new AtomicBoolean(false);
    private List<Building> buildingsToUpdate = new ArrayList<Building>();

    public GamePanel(Grid pGrid)
    {
        grid = pGrid;
        this.addMouseListener(mouseHandler);
        this.addKeyListener(keyHandler);

        this.setFocusable(true);
    }

    public void startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.run();
    }

    public void PlacingBuilding(String buildingName)
    {
        placingBuilding.set(true);
        clicked = 0;
        rotateLeft.set(0);
        rotateRight.set(0);

        Thread t = new Thread(new Runnable()
        {
            @Override
            public void run() {
                requestFocus();
                Point initialMousePos = Grid.PointToGrid(mouseHandler.getMousePos());
                System.out.println("Initial position relative to Grid: X: " + initialMousePos.x + " Y: " + initialMousePos.y + "\n placingBuilding bool: " + placingBuilding.get());
                Building buildingToPlace = new Building(BuildingType.valueOf(buildingName), initialMousePos.x, initialMousePos.y, Building.BuildingDirection.North);

                grid.AddBuilding(buildingToPlace);

                while(placingBuilding.get()){
                    Point mousePos = Grid.PointToGrid(mouseHandler.getMousePos());
                    buildingToPlace.setPosition(mousePos);

                    if(rotateLeft.get() > 0){
                        buildingToPlace.rotateLeft();
                        rotateLeft.set(0);
                    }

                    if(rotateRight.get() > 0){
                        buildingToPlace.rotateRight();
                        rotateRight.set(0);
                    }

                    repaint();

                    if(clicked > 0)
                    {
                        placingBuilding.set(false);
                        buildingToPlace.SetStandingOnTileType(grid.getGridTileType(mousePos.x, mousePos.y));
                        OnChange(mousePos.x, mousePos.y);
                        break;
                    }

                    try {
                        Thread.sleep(16);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        t.start();
    }

    public void Update(){}

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        grid.drawGrid(g2);
        for(Building building : grid.GetBuildings()){
            building.drawBuilding(g2);
        }
    }

    @Override
    public void run()
    {
        double drawInterval = (double) 1000000000 / fps;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while(gameThread != null){
            Update();   // Run update method

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 1000000;

                if(remainingTime < 0)
                    remainingTime = 0;

                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }

    public void OnChange(int PosX, int PosY)
    {
        SurroundingBuilding(PosX, PosY);
        ListIterator<Building> updateListIterator = buildingsToUpdate.listIterator();

        while (updateListIterator.hasNext())
        {
            Building building = updateListIterator.next();
            updateBuildingChain(building);
        }
        buildingsToUpdate.clear();
    }


    private void updateBuildingChain(Building currentBuilding)
    {
        Building nextBuilding = grid.DirectionToBuilding(currentBuilding.direction, currentBuilding.positionX, currentBuilding.positionY);

        if (nextBuilding != null)
        {
            nextBuilding.UpdateInput((Item) currentBuilding.getOutput(), currentBuilding.outputRate);
            Logger.log(this.getClass(), "Building: " + currentBuilding.buildingType.toString() + " transferred item to building: " + nextBuilding.buildingType.toString() + " | Item: " + (Item) currentBuilding.getOutput());
            updateBuildingChain(nextBuilding);
        }
    }

    public void SurroundingBuilding(int PosX, int PosY)
    {
        for(Building building : grid.GetBuildings())
        {
            //   0
            // 0 x 0
            //   0
            if(building.positionX == PosX && building.positionY == PosY)
            {
                building.AffectedByChange();
                if(building.getOutput() != null)
                {
                    buildingsToUpdate.add(building);
                }
            }

            //   0
            // x 0 0
            //   0
            else if(building.positionX -1 == PosX && building.positionY == PosY)
            {
                building.AffectedByChange();
                if(building.getOutput() != null)
                {
                    buildingsToUpdate.add(building);
                }
            }

            //   0
            // 0 0 x
            //   0
            else if(building.positionX +1 == PosX && building.positionY == PosY)
            {
                building.AffectedByChange();
                if(building.getOutput() != null)
                {
                    buildingsToUpdate.add(building);
                }
            }

            //   x
            // 0 0 0
            //   0
            else if(building.positionX == PosX && building.positionY -1 == PosY)
            {
                building.AffectedByChange();
                if(building.getOutput() != null)
                {
                    buildingsToUpdate.add(building);
                }
            }

            //   0
            // 0 0 0
            //   x
            else if(building.positionX == PosX && building.positionY +1 == PosY)
            {
                building.AffectedByChange();
                if(building.getOutput() != null)
                {
                    buildingsToUpdate.add(building);
                }
            }
        }
    }

}
