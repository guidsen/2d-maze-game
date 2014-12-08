/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.game;

import java.awt.Color;
import java.awt.Graphics;
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

    public void draw(Graphics g) {
        g.setColor(Color.PINK);
        g.fillRect(this.posY * SIZE, this.posX * SIZE, SIZE, SIZE);
    }

    public void setPosition(int posY, int posX) {
        this.posY = posY;
        this.posX = posX;
    }

}
