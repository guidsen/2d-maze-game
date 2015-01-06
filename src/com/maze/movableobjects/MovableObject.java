/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.movableobjects;

import com.maze.game.Direction;
import com.maze.game.GameObject;
import static com.maze.game.GameObject.SIZE;
import com.maze.game.Level;
import com.maze.game.MazeGame;
import com.maze.staticobjects.StaticObject;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;

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
            
            if(this.position.getX() != old.position.getX() || this.position.getY() != old.position.getY()) {
                Graphics g = MazeGame.manager.level.getGraphics();
                this.draw(g);
                
                old.draw(g);
                
                GameObject obj = Level.getGameObject(this.position);
                obj.onStand();
            }
        } catch (IndexOutOfBoundsException e) { }
    }
    
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
            
        MovableObject obj = (MovableObject) this;

        AffineTransform at = new AffineTransform();
        at.translate((int)this.position.getX() * SIZE + SIZE / 2, (int)this.position.getY() * SIZE + SIZE / 2);
        at.rotate(Math.toRadians(obj.getDirection().getAngle()));
        at.translate(-SIZE / 2, -SIZE / 2);

        g2d.drawImage(this.image.getImage(), at, null);
    }
    
    public Direction getDirection() {
        return this.direction;
    }

    public void left() {
        moveObject(-1, 0);
        this.direction.setDirection(KeyEvent.VK_LEFT);
    }

    public void right() {
        moveObject(1, 0);
        this.direction.setDirection(KeyEvent.VK_RIGHT);
    }

    public void up() {
        moveObject(0, -1);
        this.direction.setDirection(KeyEvent.VK_UP);
    }

    public void down() {
        moveObject(0, 1);
        this.direction.setDirection(KeyEvent.VK_DOWN);
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
}
