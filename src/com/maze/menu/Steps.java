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
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Liam
 */
public class Steps extends JPanel {

    private JLabel label = new JLabel();

    public Steps() {
        this.setPreferredSize(new Dimension(100, 30));
        this.setLayout(new BorderLayout());

        this.setText();

        this.add(this.label, BorderLayout.WEST);
    }

    public void setText() {
        this.label.setText("Stappen: "+GameManager.steps);
    }
}
