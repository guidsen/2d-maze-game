/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.game;

import com.maze.levels.Level;
import com.maze.menu.TopBar;
import com.maze.menu.WeaponInfo;
import com.maze.movableobjects.Cheater;
import com.maze.staticobjects.Finish;
import com.maze.staticobjects.Ground;
import com.maze.staticobjects.gadgets.*;
import com.maze.staticobjects.obstacles.*;
import com.maze.staticobjects.weapons.*;
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

    private int current = 0;
    private JFrame frame;
    public TopBar topBar = new TopBar();
    public WeaponInfo weaponInfo = new WeaponInfo();

    public static Level level;
    private String basePath = "src/com/maze/levels/";
    private String[] levels
            = new String[]{
                "level00.json",
                "level01.json"
            };

    public LevelManager(JFrame frame) {
        abbrs.put("T", new Tree());
        abbrs.put("R", new Rock());
        abbrs.put("G", new Ground());
        abbrs.put("B", new Bazooka());
        abbrs.put("A", new Axe());
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
        this.level.build(this.basePath + this.levels[id], abbrs);

        GameManager.reset(this.level.getPlayer());

        this.frame.add(this.topBar, BorderLayout.NORTH);
        this.frame.add(this.level, BorderLayout.CENTER);
        this.frame.add(this.weaponInfo, BorderLayout.SOUTH);

        this.frame.pack();
        this.frame.revalidate();
        this.frame.repaint();
    }

    public void loadTest() throws InstantiationException, IllegalAccessException {
        if (this.level != null) {
            this.frame.remove(this.level);
            this.frame.revalidate();
        }

        this.level = new Level();
        this.level.build(this.basePath + "testLevel.json", abbrs);

        this.frame.add(this.topBar, BorderLayout.NORTH);
        this.frame.add(this.level, BorderLayout.CENTER);
        this.frame.add(this.weaponInfo, BorderLayout.SOUTH);

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

    public void startTest() {
        try {
            this.loadTest();
        } catch (InstantiationException ex) {
            Logger.getLogger(LevelManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(LevelManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public void next() {
        if (this.current < this.levels.length - 1) {
            this.current++;
            try {
                this.load(this.current);
            } catch (InstantiationException ex) {
                Logger.getLogger(LevelManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(LevelManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        } else {
            int dialogResult = JOptionPane.showConfirmDialog(null, "Einde van het spel. Wilt u opnieuw beginnen?", "warning", 0);
            if (dialogResult == JOptionPane.YES_OPTION) {
                this.current = 0;
                this.start();
            } else {
                MazeGame.frame.dispose();
            }
        }
    }

    public void restart() {
        try {
            this.load(this.current);
        } catch (InstantiationException ex) {
            Logger.getLogger(LevelManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(LevelManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public Level getLevel() {
        return this.level;
    }
}
