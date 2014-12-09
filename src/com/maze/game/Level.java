/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.game;

import com.maze.movableobjects.Player;
import com.maze.staticobjects.Ground;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import javax.swing.JComponent;

/**
 *
 * @author Guido
 */
public class Level extends JComponent {

    private static int HEIGHT = 15;
    private static int WIDTH = 15;
    private GameObject[][] gameObjects = new GameObject[HEIGHT][WIDTH];
    public Player player;
    private ArrayList<Map> maps;
    protected GameManager gameManager;
    private int difficulty;
    private int spawnY = 1;
    private int spawnX = 1;

    public Level() {
        this.player = new Player(this.spawnY, this.spawnX);
        this.setPreferredSize(new Dimension(WIDTH * GameObject.SIZE, HEIGHT * GameObject.SIZE));
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                paint(g, x, y);
            }
        }

        this.player.draw(g);
    }

    public void paintComponent(Graphics g, int x, int y) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        gameObjects[y][x].draw(g);
    }
   
    public void setSpawn(int spawnY, int spawnX) {
        this.spawnY = spawnY;
        this.spawnX = spawnX;
    }

    public void setGameObject(GameObject object, int posY, int posX) {
        gameObjects[posY][posX] = object;
        object.setPosition(posY, posX);
    }

    public GameObject getGameObject(int posY, int posX) {
        return gameObjects[posY][posX];
    }

    public void build() {

    }
}
