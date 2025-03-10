package com.cozystudios.fofrathzindustry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel
{
    Grid grid;
    KeyHandler keyHandler;

    public GamePanel(Grid pGrid)
    {
        grid = pGrid;
        keyHandler = new KeyHandler(this);
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

    public void OnInput(KeyEvent e)
    {
        switch (e.getKeyCode())
        {
            case KeyEvent.VK_A:
                System.out.println("Key A Pressed");
                grid.MoveCurrentLocalGrid(Building.BuildingDirection.west);
                break;
            case KeyEvent.VK_D:
                System.out.println("Key D Pressed");
                grid.MoveCurrentLocalGrid(Building.BuildingDirection.east);
                break;
            case KeyEvent.VK_W:
                System.out.println("Key W Pressed");
                grid.MoveCurrentLocalGrid(Building.BuildingDirection.north);
                break;
            case KeyEvent.VK_S:
                System.out.println("Key S Pressed");
                grid.MoveCurrentLocalGrid(Building.BuildingDirection.south);
                break;
        }
    }
}
