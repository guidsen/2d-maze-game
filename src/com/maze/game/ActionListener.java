/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.game;

import com.maze.levels.Level;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 *
 * @author Guido
 */
public class ActionListener implements KeyListener {

    private LevelManager manager;

    public ActionListener(LevelManager manager) {
        this.manager = manager;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //Level.clearQueue();
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            this.manager.restart();
        } else {
            this.manager.getLevel().player.move(e.getKeyCode());
            if(e.getKeyCode() == KeyEvent.VK_SPACE){
                this.manager.getLevel().player.useWeapon();
            } else if(e.getKeyCode() >= KeyEvent.VK_0 && e.getKeyCode() <= KeyEvent.VK_9) {
                this.manager.getLevel().player.setCurrentWeapon(Character.getNumericValue(e.getKeyChar()));
                MazeGame.manager.weaponInfo.update();
            }
        }
        
        Level.drawQueue();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
