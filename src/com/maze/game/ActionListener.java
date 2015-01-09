/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 *
 * @author Guido
 */
public class ActionListener implements KeyListener {

    private LevelManager manager;
    private ArrayList<Integer> keys;

    public ActionListener(LevelManager manager) {
        this.manager = manager;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.manager.getLevel().player.move(e.getKeyCode());
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            this.manager.getLevel().player.shoot();
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
