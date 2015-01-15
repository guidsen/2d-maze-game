/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.staticobjects.obstacles;

import com.maze.staticobjects.StaticObject;

/**
 *
 * @author Guido
 */
public abstract class Obstacle extends StaticObject {

    private boolean destroyable = true;
    private int damaged;
    private boolean blocked = true;

    public boolean onCollision() {
        return !this.blocked;
    }
    
    public boolean isDestroyable() {
        return this.destroyable;
    }
}
