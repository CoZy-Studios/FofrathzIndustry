package com.cozystudios.fofrathzindustry;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    GamePanel gp;

    public KeyHandler()
    {
        //this.gp = gp;
        System.out.println("KeyHandler created");
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
        System.out.println("KeyTyped");
        int key = e.getKeyChar();
        System.out.println(key);
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        System.out.println("KeyPressed");
        int key = e.getKeyChar();
        System.out.println(key);
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        System.out.println("KeyReleased");
        int key = e.getKeyChar();
        System.out.println(key);
    }
}