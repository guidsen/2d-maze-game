/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.levels;

import com.maze.game.GameManager;
import com.maze.game.GameObject;
import com.maze.game.MazeGame;
import com.maze.game.QueueOrderer;
import com.maze.movableobjects.Player;
import com.maze.staticobjects.Finish;
import com.maze.staticobjects.Ground;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
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
    private static ArrayList<GameObject> queue = new ArrayList<>();
    public static boolean loading = false;
    
    public Player player;
    public Finish finish;
    protected GameManager gameManager;
    private int difficulty;
    
    @Override
    public void paintComponent(Graphics g) {
        Collections.sort(queue, new QueueOrderer());
        for(GameObject obj : queue) {
            obj.draw(g);
        }
    }
    
    public static void queue(GameObject obj) {
        if(!Level.loading) {
            queue.add(obj);
        }
    }
    
    public static void priorityQueue(GameObject obj, int index) {
        if(!Level.loading) {
            obj.setIndex(index);
            queue.add(obj);
        }
    }
    
    public static void drawQueue() {
        Graphics g = MazeGame.manager.level.getGraphics();
        
        Collections.sort(queue, new QueueOrderer());
        for(GameObject obj : queue) {
            obj.draw(g);
        }
        
        if(!Level.loading){
            queue.clear();
        } else {
            Level.loading = false;
        }
    }
    
    public static void paintGameObject(Point point) {
        gameObjects[(int)point.getY()][(int)point.getX()].draw(MazeGame.manager.level.getGraphics());
    }

    public void setGameObject(GameObject object, Point point) {
        gameObjects[(int)point.getY()][(int)point.getX()] = object;
        object.setPosition(point);
        this.queue(object);
    }
    
    public void removeGameObject(Point point) {
        Ground ground = new Ground();
        ground.setPosition(point);

        gameObjects[(int)point.getY()][(int)point.getX()] = ground;
        
        this.priorityQueue(ground, 2);
    }
    
    public static GameObject getGameObject(Point point) {
        return gameObjects[(int)point.getY()][(int)point.getX()];
    }
    
    public void build(String path, HashMap<String, GameObject> abbrs) {
        Level.loading = false;
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
            this.player = new Player(new Point(Integer.parseInt(spawn.get("x").toString()), Integer.parseInt(spawn.get("y").toString())));
            this.queue(this.player);
            
            this.gameObjects =  new GameObject[this.HEIGHT][this.WIDTH];
            
            for(int y = 0; y < this.HEIGHT; y++) {
                JSONArray xobstacles = (JSONArray) obstacles.get(y);
                for(int x = 0; x < this.WIDTH; x++) {
                    if(xobstacles.get(x).equals("*")) {
                        setGameObject(abbrs.get(settings.get("ground")).getClass().newInstance(), new Point(x, y));
                    } else if(abbrs.containsKey(xobstacles.get(x))){
                        setGameObject(abbrs.get(xobstacles.get(x)).getClass().newInstance(), new Point(x, y));
                    } else {
                        System.out.println("Bestaat niet: "+x);
                    }
                }
            }
        } catch(Exception e){
            System.out.println(e);
        }
        Level.loading = true;
    }
    
    public void unLit() {
        for(GameObject[] y : this.gameObjects) {
            for(GameObject x : y) {
                if(x.isDot()) {
                    x.setDot(false);
                    this.queue(x);
                }
            }
        }
    }
}
