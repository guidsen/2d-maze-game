/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.menu;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author Liam
 */
public class TopBar extends JPanel {

    private Steps steps = new Steps();
    private Time time = new Time();

    public TopBar() {
        this.setLayout(new BorderLayout());

        JPanel con = new JPanel();

        con.add(new Title(), BorderLayout.WEST);
        con.add(this.steps, BorderLayout.CENTER);
        con.add(this.time, BorderLayout.EAST);

        this.add(con, BorderLayout.WEST);
    }

    public void update() {
        this.steps.setText();
        this.time.setText();
    }
}
