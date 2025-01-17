package com.cozystudios.fofrathzindustry;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel
{
    int columns =  16;
    int rows = 16;
    int cellSize = 34;
    int width = columns * cellSize;
    int height = rows * cellSize;

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

        drawGrid(g2);
    }

    private void drawGrid(Graphics2D g2)
    {
        for(int i= 0; i <= rows; i++)
        {
            for(int j = 0; j <= columns; j++)
            {
                g2.drawRect(j * cellSize, i * cellSize, cellSize, cellSize);
            }
        }
    }
}
