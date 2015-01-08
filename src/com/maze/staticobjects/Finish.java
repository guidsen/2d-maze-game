/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.staticobjects;

import static com.maze.game.GameObject.SIZE;
import com.maze.game.Image;
import com.maze.game.MazeGame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JOptionPane;

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
        MazeGame.manager.next();
    }
}
