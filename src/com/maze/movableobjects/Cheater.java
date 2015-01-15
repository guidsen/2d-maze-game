/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.movableobjects;

import com.maze.game.GameManager;
import com.maze.game.Image;
import com.maze.game.MazeGame;

/**
 *
 * @author Guido
 */
public class Cheater extends MovableObject {

    private int fallback = 5;

    public Cheater() {
        super.image = new Image("guard.png");
    }

    public void onStand() {
        GameManager.addSteps(5);
        this.dissapear();
    }

    public void onCollision() {

    }
}
