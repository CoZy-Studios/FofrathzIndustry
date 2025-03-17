package com.cozystudios.fofrathzindustry;
import javax.swing.*;

import java.awt.*;

import static com.cozystudios.fofrathzindustry.Grid.*;

public class Main
{
    public static void main(String[] args)
    {
        JFrame gameWindow = new JFrame();
        JFrame UiWindow = new JFrame();
        Grid grid = new Grid();
        GamePanel gamePanel = new GamePanel(grid);
        UiPanel uiPanel = new UiPanel(gamePanel);

        int width = grid.width + columns + 1 + 100;
        int height = grid.height + cellSize + 6;

        /*                      Game Window                       */
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setSize(width, height);  //final size / resize-ability is up to debate
        gameWindow.setTitle("FofrathzIndustry");
        gameWindow.setResizable(false); // Not resizeable for now, until we know how to stop it from stretching things
        gameWindow.setLocationRelativeTo(null);

        /*                      UI Sidebar Window                       */
        UiWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        UiWindow.setSize(300, height);
        UiWindow.setTitle("FofrathzIndustry Sidebar");
        UiWindow.setResizable(false);

        Point gameWindowPosition = gameWindow.getLocation();
        UiWindow.setLocation(gameWindowPosition.x + gameWindow.getWidth(), gameWindowPosition.y);

        gameWindow.add(gamePanel);
        UiWindow.add(uiPanel);
        gameWindow.setVisible(true);
        UiWindow.setVisible(true);

        Logger.activateLogger();

        gamePanel.startGameThread();
    }
}