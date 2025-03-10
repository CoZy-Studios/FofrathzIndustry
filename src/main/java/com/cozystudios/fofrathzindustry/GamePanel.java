package com.cozystudios.fofrathzindustry;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable
{
    Grid grid;
    MouseHandler mouseHandler = new MouseHandler(this);

    Thread gameThread;

    int fps = 60;

    boolean placingBuilding = false;

    public GamePanel(Grid pGrid)
    {
        grid = pGrid;
        this.addMouseListener(mouseHandler);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.run();
    }

    public void PlacingBuilding(){
        Point mousePos = mouseHandler.getMousePos();
        //Building buildingToPlace = new Building();
    }

    public void Update(){
        if(placingBuilding)
            PlacingBuilding();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        grid.drawGrid(g2);
    }

    @Override
    public void run() {
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
}
