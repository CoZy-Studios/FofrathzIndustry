package com.cozystudios.fofrathzindustry;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    GamePanel gp;

    public KeyHandler()
    {
        //this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_ENTER){
            System.out.println("testingt");
        }
        if(key == KeyEvent.VK_ESCAPE)
        {

        }
    }

    @Override
    public void keyPressed(KeyEvent e)
    {

    }

    @Override
    public void keyReleased(KeyEvent e)
    {

    }


}