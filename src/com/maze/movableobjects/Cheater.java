/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.movableobjects;

import com.maze.game.GameManager;
import static com.maze.game.GameObject.SIZE;
import com.maze.game.Image;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 *
 * @author Guido
 */
public class Cheater extends MovableObject {

    private int fallback = 5;

    public Cheater() {
        super.image = new Image("guard.png");
    }

    public void onStand() {
        GameManager.addSteps(5);
        this.dissapear();
    }

    public void draw(Graphics g) {
        if (this.isDot()) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(Color.YELLOW);
            g2d.fillOval((int) this.position.getX() * SIZE + ((SIZE - 10) / 2), (int) this.position.getY() * SIZE + ((SIZE - 10) / 2), 10, 10);
        }
        g.drawImage(this.image.getImage(), (int) this.position.getX() * SIZE, (int) this.position.getY() * SIZE, null);
    }
}
