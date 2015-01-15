/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.menu;

import com.maze.game.GameManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Liam
 */
public class TimerListener implements ActionListener {
    private Time time;
    
    public TimerListener(Time time) {
        this.time = time;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        GameManager.addSecond();
    }
}
