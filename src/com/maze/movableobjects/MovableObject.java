/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.movableobjects;

import com.maze.game.Direction;
import com.maze.game.GameObject;
import com.maze.game.Image;
import com.maze.game.Level;
import com.maze.game.MazeGame;
import com.maze.staticobjects.StaticObject;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;

/**
 *
 * @author Guido
 */
public abstract class MovableObject extends GameObject {

    private int speed;
    private Direction direction = new Direction();

    public void move(int direction) {
        try {
            GameObject old = Level.getGameObject(this.position);
            int oldAngle = this.direction.getAngle();
            
            this.direction.setDirection(direction);

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
            
            GameObject obj = Level.getGameObject(this.position);
            
            if(this.position.getX() != old.position.getX() || this.position.getY() != old.position.getY()) {
                obj.onStand();
            }
            
            Level.queue(this);
            Level.queue(old);
            Level.queue(obj);
        } catch (IndexOutOfBoundsException e) { }
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void left() {
        moveObject(-1, 0);
        super.image = new Image(super.path.replace("{direction}", "left"));
    }

    public void right() {
        moveObject(1, 0);
        super.image = new Image(super.path.replace("{direction}", "right"));
    }

    public void up() {
        moveObject(0, -1);
        super.image = new Image(super.path.replace("{direction}", "up"));
    }

    public void down() {
        moveObject(0, 1);
        super.image = new Image(super.path.replace("{direction}", "down"));
    }
    
    public void moveObject(int x, int y) {
        GameObject obj = Level.getGameObject(new Point(this.position.x + x, this.position.y + y));
        
        if (obj instanceof StaticObject) {
            StaticObject staticObj = (StaticObject) obj;
            if (staticObj.onCollision()) {
                this.position.y += y;
                this.position.x += x;
            }
        } else {
            this.position.y += y;
            this.position.x += x;
        }
    }
    
    public void setPath(String path) {
        super.path = path;
        
        new Image(super.path.replace("{direction}", "up"));
        new Image(super.path.replace("{direction}", "right"));
        new Image(super.path.replace("{direction}", "down"));
        new Image(super.path.replace("{direction}", "left"));
        
        super.image = new Image(super.path.replace("{direction}", "down"));
    }
}
