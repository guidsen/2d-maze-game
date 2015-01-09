/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.game;

import com.maze.topbar.Menu;
import com.maze.topbar.Steps;
import com.maze.topbar.Time;
import com.maze.topbar.Title;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Liam
 */
public class TopBar extends JPanel {
    private JPanel steps = new Steps();
    private JPanel time = new Time();
    
    public TopBar() {
        this.setLayout(new BorderLayout());
        
        JPanel con = new JPanel();
        
        con.add(new Title(), BorderLayout.WEST);
        con.add(this.steps, BorderLayout.CENTER);
        con.add(this.time, BorderLayout.EAST);
        
        this.add(con, BorderLayout.WEST);
        
        Menu menu = new Menu();
        this.add(menu, BorderLayout.EAST);
        
        menu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                System.out.println("asd");
            }
       });
    }
}
