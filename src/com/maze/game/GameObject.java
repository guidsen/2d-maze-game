/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 *
 * @author Guido
 */
public abstract class GameObject {

    public static final int SIZE = 30;
    private String imagePath;
    public int posY;
    public int posX;
    public int index;
    protected Color color;
    protected Image image;

    public void draw(Graphics g) {
        if(this.image == null){
            g.setColor(color);
            g.fillRect(this.posX * SIZE, this.posY * SIZE, SIZE, SIZE);
        } else {
            g.drawImage(this.image.getImage(), this.posX * SIZE, this.posY * SIZE, null);
        }
    }

    public void setPosition(int posY, int posX) {
        this.posY = posY;
        this.posX = posX;
    }
    
    public void onStand() {
        
    }
}
