package com.cozystudios.fofrathzindustry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UiPanel extends JPanel {

    public UiPanel(){
        GridLayout layout = new GridLayout(3, 2, 0, 0);
        this.setLayout(layout);

        JLabel buildingMenuLabel = new JLabel("Building Menu");
        JLabel buildLabel = new JLabel("Build");
        JPanel emptyPanel = new JPanel();

        JButton testButton = new JButton("Press");
        JButton buildButton = new JButton("Build");
        testButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                testButton.setText("blegh");
            }
        });

        this.add(buildingMenuLabel);
        this.add(emptyPanel);
        this.add(buildLabel);
        this.add(buildButton);
        this.add(emptyPanel);
        this.add(testButton);
    }
}
