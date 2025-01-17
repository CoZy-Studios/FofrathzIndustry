package com.cozystudios.fofrathzindustry;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel
{
    Grid grid;

    public GamePanel(Grid pGrid)
    {
        grid = pGrid;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        //g2.drawString("Test",100,100); //Just for testing purposes

        // Draw horizontal lines
        /*for (int i = 0; i <= rows; i++) {
            int y = i * cellSize;
            System.out.println("y: " + y);
            g2.drawLine(0, y, width, y);
        }

        // Draw vertical lines
        for (int i = 0; i <= columns; i++) {
            int x = i * cellSize;
            System.out.println("x: "+ x);
            g2.drawLine(x, 0, x, height);
        }*/

        grid.drawGrid(g2);
    }
}
