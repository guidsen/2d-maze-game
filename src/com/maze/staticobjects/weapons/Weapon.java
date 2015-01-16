/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.staticobjects.weapons;

import com.maze.movableobjects.Direction;
import com.maze.game.GameObject;
import com.maze.game.Image;
import com.maze.game.MazeGame;
import com.maze.staticobjects.obstacles.Obstacle;
import com.maze.staticobjects.StaticObject;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Guido
 */
public abstract class Weapon extends StaticObject {

    public String name;
    public int ammo;

    public void fire(Direction direction, Point bulletPosition) {
        if(this.ammo > 0) {
            boolean hit = false;
            while(!hit) {
                GameObject next = direction.getNext(bulletPosition);
                if(next == null) {
                    hit = true;
                } else if(next instanceof Obstacle) {
                    Obstacle obstacle = ((Obstacle)next);
                    if(obstacle.isDestroyable()) {
                        obstacle.dissapear();
                    }
                    hit = true;
                } else {
                    bulletPosition = next.getPosition();
                }
            }
            this.ammo -= 1;
        }
        
        MazeGame.manager.weaponInfo.setText();
    }
     
    @Override
    public void onStand() {
        MazeGame.manager.level.player.addWeapon(this);
        
        this.dissapear();
    }
    
    public String getName() {
        return this.name;
    }
}
