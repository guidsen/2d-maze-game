/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.game;

import com.maze.movableobjects.Player;
import com.maze.staticobjects.weapons.Weapon;

/**
 *
 * @author Guido
 */
public class GameManager {

    public static int steps;
    public static int seconds = 0;
    public static int minutes = 0;
    public static Player player;
    
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
    
    public static void reset(Player newPlayer) {
        steps = 0;
        seconds = 0;
        minutes = 0;
        player = newPlayer;
        update();
    }
    
    public static void update() {
        MazeGame.manager.topBar.update();
        MazeGame.manager.weaponInfo.reset();
    }
}
