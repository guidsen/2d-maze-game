/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.tests;

import com.maze.game.LevelManager;
import com.maze.game.MazeGame;
import static com.maze.game.MazeGame.frame;
import javax.swing.JFrame;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Guido
 */
public class LevelManagerTest {

    LevelManager manager;

    @Before
    public void setUp() {
        frame = new JFrame("Maze game");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        MazeGame.manager = new LevelManager(frame);
        manager = MazeGame.manager;
        manager.start();
    }

    /**
     * Test of next method, of class LevelManager.
     */
    @Test
    public void testNext() {
        manager.next();
        assertEquals(manager.current, 1);
    }
}
