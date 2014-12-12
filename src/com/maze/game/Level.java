/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.game;

import com.maze.movableobjects.Player;
import com.maze.staticobjects.Finish;
import com.maze.staticobjects.Ground;
import com.maze.staticobjects.obstacles.Wall;
import com.maze.staticobjects.weapons.Bazooka;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JComponent;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Guido
 */
public class Level extends JComponent {
    
    private static int HEIGHT;
    private static int WIDTH;
    private static GameObject[][] gameObjects;
    public Player player;
    public Finish finish;
    private ArrayList<Map> maps;
    protected GameManager gameManager;
    private int difficulty;
    private int spawnY = 0;
    private int spawnX = 0;
    private int finishY = 13;
    private int finishX = 12;
    
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        for (int y = 0; y < this.HEIGHT; y++) {
            for (int x = 0; x < this.WIDTH; x++) {
                this.gameObjects[y][x].draw(g);                
            }
        }
        
        this.player.draw(g);
    }
    
    public static void paintGameObject(int posY, int posX) {
        gameObjects[posY][posX].draw(MazeGame.manager.level.getGraphics());
    }

    public void setGameObject(GameObject object, int posY, int posX) {
        gameObjects[posY][posX] = object;
        object.setPosition(posY, posX);
    }
    
    public void removeGameObject(int posY, int posX) {
        Ground ground = new Ground();
        ground.setPosition(posY, posX);
        
        gameObjects[posY][posX] = ground;
        
        paintGameObject(ground.posY, ground.posX);
        
        if(player.posY == ground.posY && player.posX == ground.posX) {
            this.player.draw(MazeGame.manager.level.getGraphics());
        }
    }
    
    public static GameObject getGameObject(int posY, int posX) {
        return gameObjects[posY][posX];
    }
    
    public void build(String path, HashMap<String, GameObject> abbrs) {
        JSONParser parser = new JSONParser();

        try {     
            File file = new File(path);
            FileReader fr = new FileReader(file.getAbsolutePath());
            JSONObject obj = (JSONObject) parser.parse(fr);
            
            JSONArray obstacles = (JSONArray) obj.get("obstacles");
            JSONObject settings = (JSONObject) obj.get("settings");
            
            JSONArray first = (JSONArray) obstacles.get(0);
            this.WIDTH = first.size();
            this.HEIGHT = obstacles.size();
            this.setPreferredSize(new Dimension(this.WIDTH * GameObject.SIZE, this.HEIGHT * GameObject.SIZE));
            
            JSONObject spawn = (JSONObject) settings.get("spawn");
            this.player = new Player(Integer.parseInt(spawn.get("x").toString()), Integer.parseInt(spawn.get("y").toString()));
            
            this.gameObjects =  new GameObject[this.HEIGHT][this.WIDTH];
            
            for(int y = 0; y < this.HEIGHT; y++) {
                JSONArray xobstacles = (JSONArray) obstacles.get(y);
                for(int x = 0; x < this.WIDTH; x++) {
                    if(xobstacles.get(x).equals("*")) {
                        setGameObject(abbrs.get(settings.get("ground")).getClass().newInstance(), y, x);
                    } else if(abbrs.containsKey(xobstacles.get(x))){
                        setGameObject(abbrs.get(xobstacles.get(x)).getClass().newInstance(), y, x);
                    } else {
                        System.out.println("Bestaat niet: "+x);
                    }
                }
            }
        } catch(Exception e){
            System.out.println(e);
        }
    }
}
