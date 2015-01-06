/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.game;

import java.awt.event.KeyEvent;

/**
 *
 * @author Guido
 */
public class Direction {
    private int direction = KeyEvent.VK_DOWN;
    
    public void setDirection(int keyCode){
        this.direction = keyCode;
    }
    
    public int getAngle() {
        int angle;
        
        switch(this.direction){
            case KeyEvent.VK_LEFT:
                angle = 270;
                break;
            case KeyEvent.VK_UP:
                angle = 0;
                break;
            case KeyEvent.VK_RIGHT:
                angle = 90;
                break;
            case KeyEvent.VK_DOWN:
                angle = 180;
                break;
            default:
                angle = 0;
                break;
        }
        
        return angle;
    }
}
