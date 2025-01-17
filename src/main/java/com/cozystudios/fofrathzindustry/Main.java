package com.cozystudios.fofrathzindustry;
import java.awt.*;
import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        GamePanel gamePanel = new GamePanel();
        JFrame gameWindow = new JFrame();

        int width = gamePanel.width + gamePanel.columns + 1;
        int height = gamePanel.height + gamePanel.cellSize + 6;

        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setSize(width, height);  //final size / resize-ability is up to debate
        gameWindow.setTitle("FofrathzIndustry");
        gameWindow.setResizable(false); // Not resizeable for now, until we know how to stop it from stretching things
        gameWindow.setLocationRelativeTo(null);
        gameWindow.setVisible(true);
        gameWindow.add(gamePanel);
    }
}