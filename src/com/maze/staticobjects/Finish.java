/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.staticobjects;

import com.maze.game.Image;
import com.maze.levels.Level;
import com.maze.game.MazeGame;

/**
 *
 * @author Guido
 */
public class Finish extends StaticObject {

    public Finish() {
        super.image = new Image("finish.png");
    }

    @Override
    public void onStand() {
        Level.loading = true;
        MazeGame.manager.next();
    }
}
