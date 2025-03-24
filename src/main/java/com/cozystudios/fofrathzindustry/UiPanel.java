package com.cozystudios.fofrathzindustry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

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

        String[] buildingTypes = Building.getBuildingNames();

        for (String building : buildingTypes) {
            if(Objects.equals(building, "Empty") || Objects.equals(building, "Test"))
                continue;

            JButton buildingButton = new JButton(building);

            buildingButton.setPreferredSize(new Dimension(100, 40));
            buildingButton.setFont(new Font("Arial", Font.PLAIN, 14));
            buildingButton.setFocusPainted(false);
            buildingButton.setMargin(new Insets(1, 0, 1, 0));   // button padding
            buildingButton.setToolTipText("Place " + building); // tooltip TODO: replace with rates

            buildingButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println(building + " button pressed");
                    if(!gamePanel.placingBuilding.get())
                    {
                    gamePanel.PlacingBuilding(building);
                    }
                }
            });

            buildingPanel.add(buildingButton);
        }

        add(buildingPanel);

        // Set overall panel properties
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // padding
    }
}
