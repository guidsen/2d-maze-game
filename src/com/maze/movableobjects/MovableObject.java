/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.movableobjects;

import com.maze.game.Direction;
import com.maze.game.GameObject;
import com.maze.game.Level;
import com.maze.game.MazeGame;
import com.maze.staticobjects.StaticObject;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

/**
 *
 * @author Guido
 */
public abstract class MovableObject extends GameObject {

    private int speed;

    public void move(int direction) {
        try {
            GameObject old = Level.getGameObject(this.posY, this.posX);

            switch (direction) {
                case KeyEvent.VK_LEFT:
                    this.left();
                    break;
                case KeyEvent.VK_UP:
                    this.up();
                    break;
                case KeyEvent.VK_RIGHT:
                    this.right();
                    break;
                case KeyEvent.VK_DOWN:
                    this.down();
                    break;
            }
            
            if(this.posX != old.posX || this.posY != old.posY) {
                Graphics g = MazeGame.manager.level.getGraphics();
                this.draw(g);
                
                old.draw(g);
                
                GameObject obj = Level.getGameObject(this.posY, this.posX);
                obj.onStand();
            }
        } catch (IndexOutOfBoundsException e) { }
    }

    public void left() {
        moveObject(-1, 0);
    }

    public void right() {
        moveObject(1, 0);
    }

    public void up() {
        moveObject(0, -1);
    }

    public void down() {
        moveObject(0, 1);
    }
    
    public void moveObject(int x, int y) {
        GameObject obj = Level.getGameObject(this.posY + y, this.posX + x);
        if (obj instanceof StaticObject) {
            StaticObject staticObj = (StaticObject) obj;
            if (staticObj.onCollision()) {
                this.posY += y;
                this.posX += x;
            }
        } else {
            this.posY += y;
            this.posX += x;
        }
    }
}
