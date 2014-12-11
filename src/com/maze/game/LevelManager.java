/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.game;

import com.maze.staticobjects.Ground;
import com.maze.staticobjects.gadgets.Helper;
import com.maze.staticobjects.obstacles.Wall;
import com.maze.staticobjects.weapons.Bazooka;
import java.util.HashMap;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Guido
 */
public class LevelManager {

    private HashMap<String, GameObject> abbrs = new HashMap<>();
    private int difficulty = 0;
    public static Level level;
    private String basePath = "src/com/maze/levels/";
    private JFrame frame;
    private String[][] levels = new String[][]{
        new String[] {
            "level00.json",
            "level01.json"
        }
    };

    public LevelManager(JFrame frame) {
        abbrs.put("W", new Wall());
        abbrs.put("G", new Ground());
        abbrs.put("B", new Bazooka());

        this.frame = frame;
    }

    public void load(int id) throws InstantiationException, IllegalAccessException {
        this.level = new Level();
        this.level.build(this.basePath + levels[this.difficulty][id], abbrs);
        
        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < 15; y++) {
                
                //this.level.setGameObject(new Ground(), x, y);
//                for (String key : abbrs.keySet()) {
//                    this.level.setGameObject(abbrs.get(key).getClass().newInstance(), x, y);
//                }
            }
        }
        this.frame.add(this.level);
    }

    public void start() {
        try {
            this.load(0);
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
