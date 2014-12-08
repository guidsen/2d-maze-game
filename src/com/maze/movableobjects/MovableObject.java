/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.movableobjects;

import com.maze.game.Direction;
import com.maze.game.GameObject;
import com.maze.game.Level;
import java.awt.event.KeyEvent;

/**
 *
 * @author Guido
 */
public abstract class MovableObject extends GameObject {

    private int speed;

    public void move(int direction) {
        if (direction == KeyEvent.VK_LEFT) {
        }
    }

    public void left(Level level) {
        level.player.posY -= 1;
    }

    public void right() {

    }

    public void up() {

    }

    public void down() {

    }
}
