/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.staticobjects;

import com.maze.game.GameObject;

/**
 *
 * @author Guido
 */
public abstract class StaticObject extends GameObject {

    public StaticObject() {
        super.index = 1;
    }

    public boolean onCollision() {
        return true;
    }
}
