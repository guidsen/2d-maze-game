/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.staticobjects.weapons;

import com.maze.movableobjects.Direction;
import com.maze.game.GameObject;
import com.maze.game.MazeGame;
import com.maze.staticobjects.obstacles.Obstacle;
import com.maze.staticobjects.StaticObject;
import java.awt.Point;

/**
 *
 * @author Guido
 */
public abstract class Weapon extends StaticObject {

    public String name;
    public int ammo;
    protected int range;
    protected int damage = 100;

    public final static int INFINITE = -1;

    public void use(Direction direction, Point bulletPosition) {
        if (this.ammo > 0 || this.ammo == Weapon.INFINITE) {
            boolean hit = false;
            if (this.range == Weapon.INFINITE) {
                while (!hit) {
                    GameObject next = direction.getNext(bulletPosition);
                    if (next == null) {
                        hit = true;
                    } else if (next instanceof Obstacle) {
                        Obstacle obstacle = ((Obstacle) next);
                        obstacle.hit(this);
                        hit = true;
                    } else {
                        bulletPosition = next.getPosition();
                    }
                }
            } else {
                for (int i = 0; i < this.range; i++) {
                    if (!hit) {
                        GameObject next = direction.getNext(bulletPosition);
                        if (next == null) {
                            hit = true;
                        } else if (next instanceof Obstacle) {
                            Obstacle obstacle = ((Obstacle) next);
                            obstacle.hit(this);
                            hit = true;
                        } else {
                            bulletPosition = next.getPosition();
                        }
                    }
                }
            }
            if (this.ammo != Weapon.INFINITE) {
                this.ammo -= 1;
            }
        }

        MazeGame.manager.weaponInfo.update();
    }

    @Override
    public void onStand() {
        MazeGame.manager.level.player.addWeapon(this);
        this.dissapear();
    }

    public int getDamage() {
        return this.damage;
    }
}
