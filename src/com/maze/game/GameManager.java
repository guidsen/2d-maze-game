/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.game;

import com.maze.staticobjects.weapons.Weapon;

/**
 *
 * @author Guido
 */
public class GameManager {

    public static int steps;
    public static int seconds = 0;
    public static int minutes = 0;
    public static Weapon weapon;
    
    public static void addStep() {
        steps++;
        MazeGame.manager.topBar.update();
    }
    
    public static void addSteps(int steps) {
        steps += steps;
        MazeGame.manager.topBar.update();
    }
    
    public static void addSecond() {
        if(GameManager.seconds == 59) {
            GameManager.minutes++;
            GameManager.seconds = 0;
        } else {
            GameManager.seconds++;
        }
        MazeGame.manager.topBar.update();
    }
    
    public static void setWeapon(Weapon currentWeapon) {
        weapon = currentWeapon;
        MazeGame.manager.weaponInfo.setText();
    }

    public static void reset() {
        steps = 0;
        seconds = 0;
        minutes = 0;
        MazeGame.manager.topBar.update();
    }
}
