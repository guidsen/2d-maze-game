/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.staticobjects.weapons;

import com.maze.game.Image;
import com.maze.staticobjects.Weapon;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Guido
 */
public class Bazooka extends Weapon {
    public Bazooka() {
        super.image = new Image("bazooka.png");
    }
}
