/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.menu;

import com.maze.game.GameManager;
import com.maze.staticobjects.weapons.Weapon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Liam Hubers
 */
public class WeaponInfo extends JPanel {

    private JLabel label;

    public WeaponInfo() {
        FlowLayout layout = new FlowLayout();
        layout.setAlignment(FlowLayout.LEFT);
        this.setBackground(new Color(240, 240, 240));
        this.setLayout(layout);
        this.setPreferredSize(new Dimension(300, 70));
    }

    public void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
        int index = 0;
        for (Weapon weapon : GameManager.player.getWeapons()) {
            if (GameManager.player.isCurrentWeapon(weapon)) {
                g.setColor(Color.RED);
                g.fillRect(index * 60 + 7, 7, 56, 56);
            }
            g.drawImage(weapon.getImage().getImage(), index * 60 + 10, 10, null);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 36));
            /* border om text */
            g.setColor(Color.BLACK);
            g.drawString(Integer.toString(index + 1), index * 60 + 27 + 1, 48);
            g.drawString(Integer.toString(index + 1), index * 60 + 27 - 1, 48);
            g.drawString(Integer.toString(index + 1), index * 60 + 27, 48 + 1);
            g.drawString(Integer.toString(index + 1), index * 60 + 27, 48 - 1);
            g.setColor(Color.WHITE);
            g.drawString(Integer.toString(index + 1), index * 60 + 27, 48);
            index++;
        }
    }

    public void update() {
        this.repaint();
    }

    public void reset() {
        this.update();
    }
}
