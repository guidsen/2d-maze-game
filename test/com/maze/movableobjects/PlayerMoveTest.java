
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.movableobjects;

import com.maze.game.LevelManager;
import com.maze.game.MazeGame;
import static com.maze.game.MazeGame.frame;
import java.awt.Point;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Guido
 */
public class PlayerMoveTest {

    LevelManager manager;

    public PlayerMoveTest() {
    }

    @Before
    public void setUp() {
        frame = new JFrame("Maze game");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        MazeGame.manager = new LevelManager(frame);
        manager = MazeGame.manager;
        manager.startTest();
        manager.getLevel().player.setPosition(new Point(1, 1));
    }

    /**
     * Test of moving the player to the left.
     */
    @Test
    public void testMoveLeft() {
        manager.getLevel().player.move(KeyEvent.VK_LEFT);
        Point expPos = new Point(0, 1);
        Point endPos = manager.getLevel().player.getPosition();
        assertEquals(expPos, endPos);
    }

    /**
     * Test of moving the player to the right.
     */
    @Test
    public void testMoveRight() {
        manager.getLevel().player.move(KeyEvent.VK_RIGHT);
        Point expPos = new Point(2, 1);
        Point endPos = manager.getLevel().player.getPosition();
        assertEquals(expPos, endPos);
    }

    /**
     * Test of moving the player up.
     */
    @Test
    public void testMoveUp() {
        manager.getLevel().player.move(KeyEvent.VK_UP);
        Point expPos = new Point(1, 0);
        Point endPos = manager.getLevel().player.getPosition();
        assertEquals(expPos, endPos);
    }

    /**
     * Test of moving the player down.
     */
    @Test
    public void testMoveDown() {
        manager.getLevel().player.move(KeyEvent.VK_DOWN);
        Point expPos = new Point(1, 2);
        Point endPos = manager.getLevel().player.getPosition();
        assertEquals(expPos, endPos);
    }

}
