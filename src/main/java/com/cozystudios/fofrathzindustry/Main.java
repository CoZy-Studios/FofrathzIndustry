package com.cozystudios.fofrathzindustry;
import java.awt.*;
import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        JFrame gameWindow = new JFrame();
        JFrame UiWindow = new JFrame();
        Grid grid = new Grid();
        GamePanel gamePanel = new GamePanel(grid);

        int width = grid.width + grid.columns + 1 + 100;
        int height = grid.height + Grid.cellSize + 6;

        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setSize(width, height);  //final size / resize-ability is up to debate
        gameWindow.setTitle("FofrathzIndustry");
        gameWindow.setResizable(false); // Not resizeable for now, until we know how to stop it from stretching things
        gameWindow.setLocationRelativeTo(null);

        UiWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        UiWindow.setSize(300, height);
        UiWindow.setTitle("FofrathzIndustry Sidebar");
        UiWindow.setResizable(false);

        Point gameWindowPosition = gameWindow.getLocation();
        UiWindow.setLocation(gameWindowPosition.x + gameWindow.getWidth(), gameWindowPosition.y);

        gameWindow.add(gamePanel);
        gameWindow.setVisible(true);
        UiWindow.setVisible(true);
    }
}