package com.cozystudios.fofrathzindustry;
import java.awt.*;
import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        JFrame gameWindow = new JFrame();
        Grid grid = new Grid();
        GamePanel gamePanel = new GamePanel(grid);

        int width = grid.width + grid.columns + 1;
        int height = grid.height + Grid.cellSize + 6;

        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setSize(width, height);  //final size / resize-ability is up to debate
        gameWindow.setTitle("FofrathzIndustry");
        gameWindow.setResizable(false); // Not resizeable for now, until we know how to stop it from stretching things
        gameWindow.setLocationRelativeTo(null);
        gameWindow.setVisible(true);

        gameWindow.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gameWindow.add(gamePanel, gbc);
    }
}