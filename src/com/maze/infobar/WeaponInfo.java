/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.maze.infobar;

import com.maze.staticobjects.Weapon;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Liam Hubers
 */
public class WeaponInfo extends JPanel {
    private JLabel label;
    
    public WeaponInfo() {
        this.label = new JLabel("Geen wapen");
        
        this.add(this.label, BorderLayout.WEST);
    }
    
    public void setWeapon(Weapon weapon) {
        this.label.setText(weapon.getName());
    }
    
    public void reset() {
        this.label.setText("Geen wapen");
    }
}
