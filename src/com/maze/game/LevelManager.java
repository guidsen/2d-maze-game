/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.game;

import com.maze.staticobjects.gadgets.Helper;
import com.maze.staticobjects.obstacles.Wall;
import java.util.HashMap;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Guido
 */
public class LevelManager {

    private HashMap<String, GameObject> abbrs = new HashMap<>();
    private int difficulty = 1;
    private Level level;
    private String basePath = "blabla/";
    private JFrame frame;

    public LevelManager(JFrame frame) {
        abbrs.put("O", new Wall());
        abbrs.put("H", new Helper());

        this.frame = frame;
    }

    public void load() throws InstantiationException, IllegalAccessException {
        this.level = new Level();
        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < 15; y++) {
                for (String key : abbrs.keySet()) {
                    this.level.setGameObject(abbrs.get(key).getClass().newInstance(), x, y);
                }
            }
        }
        this.frame.add(this.level);
    }

    public void start() {
        try {
            this.load();
        } catch (InstantiationException ex) {
            Logger.getLogger(LevelManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(LevelManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public static GameObject getObject() {
        return null;
    }
    
    public Level getLevel() {
        return this.level;
    }
}
