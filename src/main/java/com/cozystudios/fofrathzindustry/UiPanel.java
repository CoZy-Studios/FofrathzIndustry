package com.cozystudios.fofrathzindustry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UiPanel extends JPanel {
    private GamePanel gamePanel;

    public UiPanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

        setLayout(new GridLayout(3, 1, 0, 10)); // divide in 3, gap of 10

        /*      TOP THIRD       */
        JPanel topPanel = new JPanel();
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(topPanel);

        /*      MIDDLE THIRD        */
        JPanel middlePanel = new JPanel();
        middlePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(middlePanel);

        /*      BOTTOM THIRD        */
        JPanel buildingPanel = new JPanel();
        buildingPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10)); // center buttons, add spacing
        buildingPanel.setBorder(BorderFactory.createTitledBorder("Building Menu"));

        String[] buildingTypes = {"Belt", "Manufacturer", "Extractor", "Test"};

        for (String building : buildingTypes) {
            JButton buildingButton = new JButton(building);

            buildingButton.setPreferredSize(new Dimension(100, 40));
            buildingButton.setFont(new Font("Arial", Font.PLAIN, 14));
            buildingButton.setFocusPainted(false);
            buildingButton.setToolTipText("Click to place a " + building); // tooltip

            buildingButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println(building + " button pressed");
                    //gamePanel.PlacingBuilding(building);
                }
            });

            buildingPanel.add(buildingButton);
        }

        add(buildingPanel);

        // Set overall panel properties
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // padding
    }
}
