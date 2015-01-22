/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.staticobjects.obstacles;

import static com.maze.game.GameObject.SIZE;
import com.maze.levels.Level;
import com.maze.staticobjects.StaticObject;
import com.maze.staticobjects.weapons.Weapon;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 *
 * @author Guido
 */
public abstract class Obstacle extends StaticObject {

    private boolean destroyable = true;
    private int health;
    private int fullHealth;
    private boolean blocked = true;
    private boolean hit = false;
    
    public void draw(Graphics g) {
        g.drawImage(this.image.getImage(), (int)this.position.getX() * SIZE, (int)this.position.getY() * SIZE, null);
        if(this.hit) {
            g.setColor(Color.RED);
            g.fillRect((int)this.position.getX() * SIZE + 10, (int)this.position.getY() * SIZE, SIZE - 20, 3);
            double percentage = (double)this.health / (double)this.fullHealth;
            g.setColor(Color.GREEN);
            g.fillRect((int)this.position.getX() * SIZE + 10, (int)this.position.getY() * SIZE, (int)((SIZE - 20) * percentage), 3);
        }
    }
    
    public void setHealth(int health) {
        this.health = health;
        this.fullHealth = health;
    }

    public boolean onCollision() {
        return !this.blocked;
    }
    
    public boolean isDestroyable() {
        return this.destroyable;
    }
    
    public void hit(Weapon weapon) {
        if(this.isDestroyable()) {
            this.hit = true;
            this.health -= weapon.getDamage();
            if(this.health <= 0) {
                this.dissapear();
            } else {
                Level.queue(this);
            }
        }
    }
}
