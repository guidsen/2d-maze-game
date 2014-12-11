/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.staticobjects;

import com.maze.game.GameObject;
import com.maze.game.Level;
import com.maze.game.MazeGame;

/**
 *
 * @author Guido
 */
public abstract class StaticObject extends GameObject {

    public boolean onCollision() {
        return true;
    }

    public void dissapear() {
        MazeGame.manager.level.removeGameObject(this.posY, this.posX);
    }
}
