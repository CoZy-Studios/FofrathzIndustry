package com.cozystudios.fofrathzindustry;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel
{
    Grid grid;
    KeyHandler keyHandler = new KeyHandler();

    public GamePanel(Grid pGrid)
    {
        grid = pGrid;
        this.addKeyListener(keyHandler);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        grid.drawGrid(g2);

    }
}
