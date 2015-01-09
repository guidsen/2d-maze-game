/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.topbar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Liam
 */
public class Steps extends JPanel {
    public Steps() {
        this.setBackground(Color.BLUE);
        this.setPreferredSize(new Dimension(100, 30));
        this.setLayout(new BorderLayout());
        
        this.add(new JLabel("Stappen"), BorderLayout.WEST);
    }
}
