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

    private JLabel label;
    private int steps = 0;

    public Steps() {
        this.setPreferredSize(new Dimension(100, 30));
        this.setLayout(new BorderLayout());

        this.label = new JLabel(this.getText());

        this.add(this.label, BorderLayout.WEST);
    }

    public void addStep() {
        this.steps++;
        this.label.setText(this.getText());
    }
    
    public void addSteps(int num) {
        this.steps += num;
        this.label.setText(this.getText());
    }

    public void reset() {
        this.steps = 0;
        this.label.setText(this.getText());
    }

    public String getText() {
        return "Stappen: " + this.steps;
    }
}
