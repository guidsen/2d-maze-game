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
    protected Color color;
    protected Image image;
    protected String path;
    private boolean lit = false;

    public void draw(Graphics g) {
        if(!this.lit) {
            g.drawImage(this.image.getImage(), (int)this.position.getX() * SIZE, (int)this.position.getY() * SIZE, null);
        } else {
            g.fillRect((int)this.position.getX() * SIZE, (int)this.position.getY() * SIZE, 50, 50);
        }
    }
    
    public void setLit() {
        this.lit = true;
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
    
    public void onStand() {
        // do nothing
    }

    public Color getColor() {
        return this.color;
    }
}
