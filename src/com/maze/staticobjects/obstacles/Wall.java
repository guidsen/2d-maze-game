/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.staticobjects.obstacles;

import static com.maze.game.GameObject.SIZE;
import com.maze.staticobjects.Obstacle;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Guido
 */
public class Wall extends Obstacle {

    private String imagePath = "hodor.jpg";

    public Wall() {
        super.color = Color.ORANGE;
    }
}
