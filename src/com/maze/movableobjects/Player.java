/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.movableobjects;

import com.maze.game.Direction;
import static com.maze.game.GameObject.SIZE;
import com.maze.staticobjects.Weapon;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;

/**
 *
 * @author Guido
 */
public class Player extends MovableObject {

    private Direction currentDirection;
    private Weapon weapon;

    public Player(int spawnY, int spawnX) {
        this.setPosition(new Point(spawnY, spawnX));
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if(weapon == null) {
            g.setColor(Color.BLACK);
        } else {
            g.setColor(weapon.getColor());
        }
        g.fillOval((int)this.position.getX() * SIZE, (int)this.position.getY() * SIZE, SIZE, SIZE);
    }
    
    public void addWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
