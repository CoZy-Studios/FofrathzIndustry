package com.cozystudios.fofrathzindustry;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel
{
    Grid grid;
    KeyHandler keyHandler;

    public GamePanel(Grid pGrid)
    {
        grid = pGrid;
        keyHandler = new KeyHandler();
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
        this.requestFocusInWindow();
        System.out.println("key handler added");
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        grid.drawGrid(g2);

    }
}
