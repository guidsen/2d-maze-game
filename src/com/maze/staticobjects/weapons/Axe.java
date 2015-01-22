/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.staticobjects.weapons;

import com.maze.game.Image;

/**
 *
 * @author Liam Hubers
 */
public class Axe extends Weapon {

    public Axe() {
        super.image = new Image("axe.png");
        super.name = "Hakbijl";
        super.range = 1;
        super.ammo = Weapon.INFINITE;
        super.damage = 50;
    }
}
