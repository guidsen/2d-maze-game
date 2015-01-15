/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.movableobjects;

import com.maze.game.GameObject;
import com.maze.levels.Level;
import java.awt.Point;
import java.awt.event.KeyEvent;

/**
 *
 * @author Guido
 */
public class Direction {

    private int direction = KeyEvent.VK_DOWN;
    private int angle = 180;
    private int x = 0;
    private int y = 0;

    public void setDirection(int keyCode) {
        this.direction = keyCode;
        switch (this.direction) {
            case KeyEvent.VK_LEFT:
                this.angle = 270;
                this.x = -1;
                this.y = 0;
                break;
            case KeyEvent.VK_UP:
                this.angle = 0;
                this.x = 0;
                this.y = -1;
                break;
            case KeyEvent.VK_RIGHT:
                this.angle = 90;
                this.x = 1;
                this.y = 0;
                break;
            case KeyEvent.VK_DOWN:
                this.angle = 180;
                this.x = 0;
                this.y = 1;
                break;
        }
    }

    public GameObject getNext(Point position) {
        try {
            GameObject obj = Level.getGameObject(new Point(position.x + x, position.y + y));
            return obj;
        } catch (Exception e) {
            return null;
        }
    }

    public GameObject getNext(Point position, int keyCode) {
        this.setDirection(keyCode);
        return this.getNext(position);
    }

    public int getAngle() {
        return this.angle;
    }
}
