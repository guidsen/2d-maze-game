/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.staticobjects;

import com.maze.game.GameObject;
import com.maze.game.Image;
import java.awt.Color;

/**
 *
 * @author Guido
 */
public class Ground extends GameObject {

    public Ground() {
        super.image = new Image("grond.jpg");
    }
}
