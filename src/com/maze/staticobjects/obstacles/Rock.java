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
 * @author Liam Hubers
 */
public class Rock extends Obstacle {
    public Rock() {
        super.image = new Image("rock.png");
        super.setHealth(250);
    }
}
