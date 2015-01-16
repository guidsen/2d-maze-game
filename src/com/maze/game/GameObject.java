/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.game;

import com.maze.movableobjects.MovableObject;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 *
 * @author Guido
 */
public abstract class GameObject {

    public static final int SIZE = 50;
    private String imagePath;
    public Point position;
    protected int index = 0;
    protected Image image;
    protected String path;
    private boolean dot = false;

    public void draw(Graphics g) {
        g.drawImage(this.image.getImage(), (int)this.position.getX() * SIZE, (int)this.position.getY() * SIZE, null);
        if(this.dot) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(Color.YELLOW);
            g2d.fillOval((int)this.position.getX() * SIZE + ((SIZE - 10) /2), (int)this.position.getY() * SIZE + ((SIZE - 10) /2), 10, 10);
        }
    }
    
    public void dissapear() {
        MazeGame.manager.level.removeGameObject(this.position);
    }
    
    public void setDot(boolean dot) {
        this.dot = dot;
    }
    
    public boolean isDot() {
        return this.dot;
    }
    
    public void setImage(Image image) {
        this.image = image;
    }

    public void setPosition(Point point) {
        this.position = point;
    }
    
    public Point getPosition() {
        return this.position;
    }
    
    public int getIndex() {
        return this.index;
    }
    
    public void setIndex(int index) {
        this.index = index;
    }
    
    public void onStand() {
        // do nothing
    }
}
