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
import java.awt.event.KeyEvent;

/**
 *
 * @author Guido
 */
public abstract class MovableObject extends GameObject {

    private int speed;

    public void move(int direction) {
        Level.paintGameObject(this.posX, this.posY);

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

        Level.paintGameObject(this.posX, this.posY);
        this.draw(MazeGame.manager.level.getGraphics());
    }

    public void left() {
        GameObject obj = Level.getGameObject(this.posY, this.posX - 1);
        if (obj instanceof StaticObject) {
            StaticObject staticObj = (StaticObject) obj;
            if (staticObj.onCollision()) {
                this.posX -= 1;
            }
        } else {
            this.posX -= 1;
        }
    }

    public void right() {
        GameObject obj = Level.getGameObject(this.posY, this.posX + 1);
        if (obj instanceof StaticObject) {
            StaticObject staticObj = (StaticObject) obj;
            if (staticObj.onCollision()) {
                this.posX += 1;
            }
        } else {
            this.posX += 1;
        }
    }

    public void up() {
        GameObject obj = Level.getGameObject(this.posY - 1, this.posX);
        if (obj instanceof StaticObject) {
            StaticObject staticObj = (StaticObject) obj;
            if (staticObj.onCollision()) {
                this.posY -= 1;
            }
        } else {
            this.posY -= 1;
        }
    }

    public void down() {
        GameObject obj = Level.getGameObject(this.posY + 1, this.posX);
        if (obj instanceof StaticObject) {
            StaticObject staticObj = (StaticObject) obj;
            if (staticObj.onCollision()) {
                this.posY += 1;
            }
        } else {
            this.posY += 1;
        }
    }
}
