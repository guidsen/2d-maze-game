/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.staticobjects.gadgets;

import com.maze.game.Direction;
import com.maze.game.GameObject;
import com.maze.game.Image;
import com.maze.staticobjects.Gadget;
import com.maze.staticobjects.Obstacle;
import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Guido
 */
public class Helper extends Gadget {

    private Direction dir = new Direction();

    public Helper() {
        super.image = new Image("tree.png");
    }

    public void onStand() {
        this.showRoute();
    }

    public void showRoute() {
        Stack objs = new Stack();
        this.findRoute(this, objs);
    }

    public void findRoute(GameObject obj, Stack stack) {
        GameObject next = dir.getNext(position, KeyEvent.VK_RIGHT);
        if (!(next instanceof Obstacle)) {
            stack.add(next);
            findRoute(next, stack);
        }

        // return blabla
    }
}
