package com.cozystudios.fofrathzindustry;
import java.awt.*;
import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        GamePanel gamePanel = new GamePanel();
        JFrame gameWindow = new JFrame();

        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setSize(1920,1080);  //final size / resize-ability is up to debate
        gameWindow.setTitle("FofrathzIndustry");
        gameWindow.setResizable(false); // Not resizeable for now, until we know how to stop it from stretching things
        gameWindow.setLocationRelativeTo(null);
        gameWindow.setVisible(true);
        gameWindow.add(gamePanel);
    }
}