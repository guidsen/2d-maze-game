/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.topbar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Liam
 */
public class TimerListener implements ActionListener {
    private Time time;
    private int seconds = 0;
    private int minutes = 0;
    
    public TimerListener(Time time) {
        this.time = time;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.seconds == 59) {
            this.minutes++;
            this.seconds = 0;
        } else {
            this.seconds++;
        }
        time.label.setText(this.minutes+":"+String.format("%02d", this.seconds));
    }   
    
    public void reset() {
        this.minutes = 0;
        this.seconds = 0;
    }
}
