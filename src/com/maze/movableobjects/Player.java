/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.movableobjects;

import com.maze.game.Direction;
import com.maze.game.MazeGame;
import com.maze.staticobjects.Weapon;
import java.awt.Point;

/**
 *
 * @author Guido
 */
public class Player extends MovableObject {

    private Weapon weapon;

    public Player(Point spawn) {
        super.setPath("player_{direction}.png");
        super.index = 3;

        this.setPosition(spawn);
    }

    public void shoot() {
        if (this.weapon != null) {
            Direction dir = ((MovableObject) this).getDirection();
            this.weapon.fire(dir, this.position);
        }
    }

    public void addWeapon(Weapon weapon) {
        this.weapon = weapon;
        MazeGame.manager.infoBar.weapon.setWeapon(weapon);
    }
}
