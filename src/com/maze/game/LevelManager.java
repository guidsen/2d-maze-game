/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.game;

import com.maze.movableobjects.Cheater;
import com.maze.staticobjects.Finish;
import com.maze.staticobjects.Ground;
import com.maze.staticobjects.gadgets.Helper;
import com.maze.staticobjects.obstacles.Wall;
import com.maze.staticobjects.weapons.Bazooka;
import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Guido
 */
public class LevelManager {

    private HashMap<String, GameObject> abbrs = new HashMap<>();

    private int difficulty = 0;
    private int current = 0;
    private JFrame frame;
    public TopBar topBar = new TopBar();
    public InfoBar infoBar = new InfoBar();

    public static Level level;
    private String basePath = "src/com/maze/levels/";
    private String[][] levels = new String[][]{
        new String[]{
            "level00.json",
            "level01.json"
        }
    };

    public LevelManager(JFrame frame) {
        abbrs.put("W", new Wall());
        abbrs.put("G", new Ground());
        abbrs.put("B", new Bazooka());
        abbrs.put("F", new Finish());
        abbrs.put("H", new Helper());
        abbrs.put("C", new Cheater());

        this.frame = frame;
    }

    public void load(int id) throws InstantiationException, IllegalAccessException {
        if (this.level != null) {
            this.frame.remove(this.level);
            this.frame.revalidate();
        }

        this.level = new Level();
        this.level.build(this.basePath + this.levels[this.difficulty][id], abbrs);

        this.frame.add(this.topBar, BorderLayout.NORTH);
        this.frame.add(this.level, BorderLayout.CENTER);
        this.frame.add(this.infoBar, BorderLayout.SOUTH);

        this.frame.pack();
        this.frame.revalidate();
        this.frame.repaint();
    }

    public void start() {
        try {
            this.load(this.current);
        } catch (InstantiationException ex) {
            Logger.getLogger(LevelManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(LevelManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public void next() {
        if (this.current < this.levels[this.difficulty].length - 1) {
            this.current++;
            try {
                this.load(this.current);
                this.topBar.reset();
                this.infoBar.reset();
            } catch (InstantiationException ex) {
                Logger.getLogger(LevelManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(LevelManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Einde spel");
        }
    }
    
    public void restart() {
        try {
            this.load(this.current);
            this.topBar.reset();
            this.infoBar.reset();
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
