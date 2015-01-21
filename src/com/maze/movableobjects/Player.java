/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.movableobjects;

import com.maze.game.GameManager;
import com.maze.game.MazeGame;
import com.maze.staticobjects.weapons.Weapon;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Guido
 */
public class Player extends MovableObject {

    private ArrayList<Weapon> weapons = new ArrayList<>();
    private int currentWeapon = -1;

    public Player(Point spawn) {
        super.setPath("player_{direction}.png");
        super.index = 3;

        this.setPosition(spawn);
    }

    public void shoot() {
        if (this.weapons.get(currentWeapon) != null) {
            Direction dir = ((MovableObject) this).getDirection();
            this.weapons.get(currentWeapon).fire(dir, this.position);
        }
    }

    public void addWeapon(Weapon weapon) {
        this.weapons.add(weapon);
        this.currentWeapon = this.weapons.size() - 1;
        GameManager.update();
    }
    
    public ArrayList<Weapon> getWeapons() {
        return this.weapons;
    }
}
