/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.staticobjects;

import com.maze.game.Direction;
import com.maze.game.Image;
import com.maze.game.MazeGame;
import java.util.ArrayList;

/**
 *
 * @author Guido
 */
public abstract class Weapon extends StaticObject {

    private ArrayList<Projectile> projectiles;
    public Image playerImage;

    public void fire(Direction direction) {

    }
    
    @Override
    public boolean onCollision() {
        return true;
    }
     
    @Override
    public void onStand() {
        MazeGame.manager.level.player.addWeapon(this);
        
        this.dissapear();
    }
}
