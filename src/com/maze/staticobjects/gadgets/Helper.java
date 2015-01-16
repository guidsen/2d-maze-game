/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.staticobjects.gadgets;

import com.maze.movableobjects.Direction;
import com.maze.game.GameObject;
import com.maze.game.Image;
import com.maze.levels.Level;
import com.maze.game.MazeGame;
import com.maze.staticobjects.Finish;
import com.maze.staticobjects.obstacles.Obstacle;
import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

/**
 *
 * @author Guido
 */
public class Helper extends Gadget {

    private Direction dir = new Direction();
    private Integer[] directions = new Integer[]{ KeyEvent.VK_UP, KeyEvent.VK_RIGHT, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT };
    ArrayList<Stack<GameObject>> stacks = new ArrayList<>();
    ArrayList<GameObject> leaves = new ArrayList<>();
    
    public void draw(Graphics g) {
        g.drawImage(this.image.getImage(), (int)this.position.getX() * SIZE, (int)this.position.getY() * SIZE, null);
    }

    public Helper() {
        super.image = new Image("helper.png");
    }

    public void onStand() {
        this.showRoute();
        this.dissapear();
    }
    
    public void showRoute() {
        Stack<GameObject> stack = new Stack<>();
        this.stacks = new ArrayList<>();
        Stack<GameObject> finalStack = this.findRoute(this, stack, 0);
        if(finalStack != null) {
            MazeGame.manager.getLevel().unLit();
            for(GameObject road : finalStack) {
                road.setDot(true);
                Level.queue(road);
            }
        }
    }

    public Stack<GameObject> findRoute(GameObject obj, Stack<GameObject> stack, int index) {
        stack.add(obj);
        
        for(int key : directions) {
            GameObject next = dir.getNext(obj.getPosition(), key);
            if(!stack.contains(next) && !(next instanceof Obstacle) && !(next instanceof Finish) && next != null) {
                findRoute(next, (Stack<GameObject>)stack.clone(), index+1);
            } else if(next instanceof Finish) {
                this.stacks.add(stack);
            }
        }
        
        if(index == 0) {
            Collections.sort(this.stacks, new Comparator<Stack<GameObject>>() {
                @Override
                public int compare(Stack<GameObject> t, Stack<GameObject> t1) {
                    return t.size() - t1.size();
                }
                
            });
            return this.stacks.get(0);
        } else {
            return null;
        }
    }
}
