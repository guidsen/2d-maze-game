/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.staticobjects.obstacles;

import com.maze.game.Image;
import java.util.Random;

/**
 *
 * @author Guido
 */
public class Wall extends Obstacle {

    public Wall() {
        Random r = new Random();
        int tree = r.nextInt(6) + 1;
        super.image = new Image("tree" + tree + ".png");
    }
}
