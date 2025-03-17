package com.cozystudios.fofrathzindustry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {

    public boolean mousePressed = false;
    private GamePanel _gamepanel;

    public MouseHandler(GamePanel gamePanel){
        _gamepanel = gamePanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        mousePressed = true;
        _gamepanel.clicked++;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("mouse pressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mousePressed = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public Point getMousePos(){
        Point mousePos = MouseInfo.getPointerInfo().getLocation();
        SwingUtilities.convertPointFromScreen(mousePos, _gamepanel);
        return mousePos;
    }
}
