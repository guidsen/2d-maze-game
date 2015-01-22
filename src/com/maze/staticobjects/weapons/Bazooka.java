/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.staticobjects.weapons;

import com.maze.game.Image;
import java.util.Random;

/**
 *
 * @author Guido
 */
public class Bazooka extends Weapon {

    public Bazooka() {
        super.image = new Image("bazooka.png");
        super.name = "Bazooka";
        super.range = Weapon.INFINITE;
        Random random = new Random();
        super.ammo = random.nextInt(3) + 2;
    }
}
