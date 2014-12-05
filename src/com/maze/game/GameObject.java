/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.game;

/**
 *
 * @author Guido
 */
public abstract class GameObject {

    private final int SIZE = 30;
    private String imagePath;
    private int posX;
    private int posY;

    public void draw() {

    }

    public void setPosition(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

}
