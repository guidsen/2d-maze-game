/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.menu;

import com.maze.game.GameManager;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Liam
 */
public class Time extends JPanel {
    private Timer timer;
    private int seconds;
    public JLabel label;
    
    public Time() {
        this.setPreferredSize(new Dimension(100, 30));
        this.setLayout(new BorderLayout());
        
        this.label = new JLabel("Tijd: 0:00");
        
        this.add(label, BorderLayout.WEST);
        
        this.timer = new Timer(1000, new TimerListener(this));
        
        this.timer.start();
    }
    
    public void setText() {
        this.label.setText("Tijd: "+GameManager.minutes+":"+String.format("%02d", GameManager.seconds));
    }
}
