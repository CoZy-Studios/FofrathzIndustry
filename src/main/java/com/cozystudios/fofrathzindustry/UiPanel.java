package com.cozystudios.fofrathzindustry;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UiPanel extends JPanel {

    public UiPanel(){
        JButton testButton = new JButton("Press for free cookies");
        testButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                testButton.setText("blegh");
            }
        });
    }
}
