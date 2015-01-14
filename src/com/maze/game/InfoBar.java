/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.maze.game;

import com.maze.infobar.WeaponInfo;
import com.maze.topbar.Steps;
import com.maze.topbar.Time;
import com.maze.topbar.Title;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Liam Hubers
 */
public class InfoBar extends JPanel {
    public WeaponInfo weapon = new WeaponInfo();
    
    public InfoBar() {
        this.setLayout(new BorderLayout());
        
        JPanel con = new JPanel();
        
        con.add(this.weapon, BorderLayout.WEST);
        
        this.add(con, BorderLayout.WEST);
    }
    
    public void reset() {
        this.weapon.reset();
    }
}
