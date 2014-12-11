/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.staticobjects;

import com.maze.game.Direction;
import java.util.ArrayList;

/**
 *
 * @author Guido
 */
public abstract class Weapon extends StaticObject {

    private ArrayList<Projectile> projectiles;

    public void fire(Direction direction) {

    }
    
    public boolean onCollision() {
        return true;
    }
    
    @Override
    public void onStand() {
        this.dissapear();
    }
}
