package com.cozystudios.fofrathzindustry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {

    public boolean mousePressed = false;
    @Override
    public void mouseClicked(MouseEvent e) {
        mousePressed = true;
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

    public static Point getMousePos(){
        return MouseInfo.getPointerInfo().getLocation();
    }
}
