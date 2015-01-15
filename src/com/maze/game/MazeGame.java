/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.game;

import com.maze.staticobjects.obstacles.Wall;
import java.awt.BorderLayout;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Guido
 */
public class MazeGame {
    public static LevelManager manager;
    public static JFrame frame;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        frame = new JFrame("Maze game");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        manager = new LevelManager(frame);
        manager.start();
        frame.addKeyListener(new ActionListener(manager));
        frame.pack();
    }

}
