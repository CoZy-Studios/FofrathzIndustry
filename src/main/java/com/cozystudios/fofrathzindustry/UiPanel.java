package com.cozystudios.fofrathzindustry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UiPanel extends JPanel {

    public UiPanel(GamePanel gamePanel){
        GridLayout layout = new GridLayout(0, 2, 30, 50);
        this.setLayout(layout);

        JLabel buildingMenuLabel = new JLabel("Building Menu");
        JLabel buildLabel = new JLabel("Build");

        JButton buildButton = new JButton("Build");
        buildButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buildButton.setText("haha rip L F lol");
                gamePanel.placingBuilding = true;
            }
        });

        this.add(buildingMenuLabel);
        this.add(new JPanel());     // White space
        this.add(buildLabel);
        this.add(buildButton);
    }
}
