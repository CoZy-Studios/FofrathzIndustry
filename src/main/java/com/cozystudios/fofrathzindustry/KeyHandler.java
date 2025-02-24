package com.cozystudios.fofrathzindustry;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    GamePanel gp;

    public KeyHandler(GamePanel gp)
    {
        this.gp = gp;
        System.out.println("KeyHandler created");
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
        //System.out.println("Key Typed");
        //gp.OnInput(e);
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        System.out.println("Key pressed");
        gp.OnInput(e);
    }

    @Override
    public void keyReleased(KeyEvent e)
    {

    }
}