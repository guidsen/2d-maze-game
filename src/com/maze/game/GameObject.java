/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.util.Random;

/**
 *
 * @author Guido
 */
public abstract class GameObject {

    public static final int SIZE = 30;
    private String imagePath;
    public Point position;
    public int index;
    protected Color color;

    public void draw(Graphics g) {
        if (color == null) {
            Random r = new Random();
            //color = new Color(r.nextFloat(), r.nextFloat(), r.nextFloat());
            color = Color.PINK;
        }
        g.setColor(color);
        g.fillRect((int)this.position.getX() * SIZE, (int)this.position.getY() * SIZE, SIZE, SIZE);
    }

    public void setPosition(Point point) {
        this.position = new Point((int)point.getX(), (int)point.getY());
    }
    
    public void onStand() {
        
    }
    
    public Color getColor() {
        return this.color;
    }
}
