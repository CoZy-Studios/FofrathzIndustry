package com.cozystudios.fofrathzindustry;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    private GamePanel gamePanel;

    public KeyHandler(GamePanel gp){
        gamePanel = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        Logger.log(this.getClass(), "Key pressed");
        if(e.getKeyCode() == KeyEvent.VK_Q){
            gamePanel.rotateLeft.set(1);
        }

        if(e.getKeyCode() == KeyEvent.VK_E){
            gamePanel.rotateRight.set(1);
        }

        if(e.getKeyCode() == KeyEvent.VK_D){
            gamePanel.deletePressed++;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
