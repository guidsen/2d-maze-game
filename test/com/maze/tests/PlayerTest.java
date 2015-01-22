
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.tests;

import com.maze.game.GameObject;
import com.maze.game.LevelManager;
import com.maze.game.MazeGame;
import com.maze.movableobjects.Player;
import static com.maze.game.MazeGame.frame;
import com.maze.staticobjects.Ground;
import com.maze.staticobjects.weapons.Bazooka;
import java.awt.Point;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Guido
 */
public class PlayerTest {

    LevelManager manager;
    Player player;

    @Before
    public void setUp() {
        frame = new JFrame("Maze game");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        MazeGame.manager = new LevelManager(frame);
        manager = MazeGame.manager;
        manager.startTest();
        player = manager.getLevel().player;
        player.setPosition(new Point(1, 1));
    }

    /**
     * Test of moving the player to the left.
     */
    @Test
    public void testMoveLeft() {
        player.move(KeyEvent.VK_LEFT);
        Point expPos = new Point(0, 1);
        Point endPos = player.getPosition();
        assertEquals(expPos, endPos);
    }

    /**
     * Test of moving the player to the right.
     */
    @Test
    public void testMoveRight() {
        player.move(KeyEvent.VK_RIGHT);
        Point expPos = new Point(2, 1);
        Point endPos = player.getPosition();
        assertEquals(expPos, endPos);
    }

    /**
     * Test of moving the player up.
     */
    @Test
    public void testMoveUp() {
        player.move(KeyEvent.VK_UP);
        Point expPos = new Point(1, 0);
        Point endPos = player.getPosition();
        assertEquals(expPos, endPos);
    }

    /**
     * Test of moving the player down.
     */
    @Test
    public void testMoveDown() {
        player.move(KeyEvent.VK_DOWN);
        Point expPos = new Point(1, 2);
        Point endPos = player.getPosition();
        assertEquals(expPos, endPos);
    }

    /**
     * Test of use method, of class Weapon.
     */
    @Test
    public void testUseWeapon() {
        player.setPosition(new Point(0, 5));
        player.addWeapon(new Bazooka());
        player.setCurrentWeapon(1);
        player.move(KeyEvent.VK_RIGHT);
        player.useWeapon();
        GameObject expObj = manager.getLevel().getGameObject(new Point(2, 5));
        assertTrue(expObj instanceof Ground);
    }

}
