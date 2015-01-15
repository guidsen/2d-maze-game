/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.maze.menu;

import com.maze.game.GameManager;
import com.maze.staticobjects.weapons.Weapon;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Liam Hubers
 */
public class WeaponInfo extends JPanel {
    private JLabel label;
    private Weapon weapon;
    
    public WeaponInfo() {
        this.setLayout(new BorderLayout());
        this.setBorder(new EmptyBorder(10, 5, 10, 5) );
        this.label = new JLabel("Wapen: geen");
        
        this.add(this.label, BorderLayout.WEST);
    }
    
    public void setText() {
        if(GameManager.weapon == null) {
            this.label.setText("Wapen: geen");
        } else {
            this.label.setText("Wapen: "+GameManager.weapon.getName()+"("+GameManager.weapon.ammo+")");
        }
    }
    
    public void reset() {
        this.weapon = null;
        this.setText();
    }
}
