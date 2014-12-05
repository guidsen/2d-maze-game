/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.game;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JComponent;
import objects.Player;

/**
 *
 * @author Guido
 */
public abstract class Level extends JComponent {

    private GameObject[][] gameObjects;
    public Player player;
    private ArrayList<Map> maps;
    protected GameManager gameManager;
    private int height;
    private int width;
    private int difficulty;

    @Override
    public void paintComponent(Graphics g) {

    }

    public void setSpawn(int posX, int posY) {

    }

    public void setGameObject(GameObject object, int posX, int posY) {

    }

    public GameObject getGameObject() {
        return null;
    }

    public void build() {

    }
}
