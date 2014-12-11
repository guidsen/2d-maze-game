/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.game;

import com.maze.movableobjects.Player;
import com.maze.staticobjects.Finish;
import com.maze.staticobjects.obstacles.Wall;
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
    private static GameObject[][] gameObjects = new GameObject[HEIGHT][WIDTH];
    public Player player;
    public Finish finish;
    private ArrayList<Map> maps;
    protected GameManager gameManager;
    private int difficulty;
    private int spawnY = 0;
    private int spawnX = 0;
    private int finishY = 13;
    private int finishX = 12;

    public Level() {
        this.player = new Player(this.spawnY, this.spawnX);
        this.finish = new Finish(this.finishY, this.finishX);
        this.setPreferredSize(new Dimension(WIDTH * GameObject.SIZE, HEIGHT * GameObject.SIZE));
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        build();

        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                this.gameObjects[y][x].draw(g);                
            }
        }

        this.player.draw(g);
        this.finish.draw(g);
    }

    public static void paintGameObject(int x, int y) {
        gameObjects[y][x].draw(MazeGame.manager.level.getGraphics());
    }

    public void setSpawn(int spawnY, int spawnX) {
        this.spawnY = spawnY;
        this.spawnX = spawnX;
    }

    public void setFinish(int finishY, int finishX) {
        this.finishY = finishY;
        this.finishX = finishX;
    }

    public void setGameObject(GameObject object, int posY, int posX) {
        gameObjects[posY][posX] = object;
        object.setPosition(posY, posX);
    }

    public static GameObject getGameObject(int posY, int posX) {
        return gameObjects[posY][posX];
    }

    public void build() {
        setGameObject(new Wall(), 0, 1);
        setGameObject(new Wall(), 0, 2);
        setGameObject(new Wall(), 0, 3);
        setGameObject(new Wall(), 0, 5);
        setGameObject(new Wall(), 0, 6);
        setGameObject(new Wall(), 0, 7);
        setGameObject(new Wall(), 0, 8);
        setGameObject(new Wall(), 0, 9);
        setGameObject(new Wall(), 0, 10);
        setGameObject(new Wall(), 0, 11);
        setGameObject(new Wall(), 0, 12);
        setGameObject(new Wall(), 0, 13);
        setGameObject(new Wall(), 1, 3);
        setGameObject(new Wall(), 1, 7);
        setGameObject(new Wall(), 1, 9);
        setGameObject(new Wall(), 1, 11);
        setGameObject(new Wall(), 1, 12);
        setGameObject(new Wall(), 1, 13);
        setGameObject(new Wall(), 2, 1);
        setGameObject(new Wall(), 2, 3);
        setGameObject(new Wall(), 2, 5);
        setGameObject(new Wall(), 2, 7);
        setGameObject(new Wall(), 2, 9);
        setGameObject(new Wall(), 2, 11);
        setGameObject(new Wall(), 2, 12);
        setGameObject(new Wall(), 3, 1);
        setGameObject(new Wall(), 5, 4);
        setGameObject(new Wall(), 5, 5);
        setGameObject(new Wall(), 5, 13);
        setGameObject(new Wall(), 5, 14);
        setGameObject(new Wall(), 6, 4);
        setGameObject(new Wall(), 6, 13);
        setGameObject(new Wall(), 6, 14);
        setGameObject(new Wall(), 7, 14);
        setGameObject(new Wall(), 8, 0);
        setGameObject(new Wall(), 8, 1);
        setGameObject(new Wall(), 8, 8);
        setGameObject(new Wall(), 8, 9);
        setGameObject(new Wall(), 8, 10);
        setGameObject(new Wall(), 9, 0);
        setGameObject(new Wall(), 9, 9);
        setGameObject(new Wall(), 9, 10);
        setGameObject(new Wall(), 12, 0);
        setGameObject(new Wall(), 12, 7);
        setGameObject(new Wall(), 12, 8);
        setGameObject(new Wall(), 12, 9);
        setGameObject(new Wall(), 13, 0);
        setGameObject(new Wall(), 13, 1);
        setGameObject(new Finish(13, 12), 13, 12);
        setGameObject(new Wall(), 13, 8);
        setGameObject(new Wall(), 14, 0);
        setGameObject(new Wall(), 14, 1);
        setGameObject(new Wall(), 14, 2);
        setGameObject(new Wall(), 14, 3);
    }
}
