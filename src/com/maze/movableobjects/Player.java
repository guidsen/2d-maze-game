/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.movableobjects;

import com.maze.game.GameManager;
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

    public void useWeapon() {
        if(this.currentWeapon != -1 && this.weapons.get(currentWeapon) != null) {
            Direction dir = ((MovableObject) this).getDirection();
            this.weapons.get(currentWeapon).use(dir, this.position);
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

    public void setCurrentWeapon(int weapon) {
        this.currentWeapon = weapon - 1;
    }

    public boolean isCurrentWeapon(Weapon weapon) {
        try {
            return weapon == this.weapons.get(this.currentWeapon);
        } catch (Exception e) {
            return false;
        }
    }
}
