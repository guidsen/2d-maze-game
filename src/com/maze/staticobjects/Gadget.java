/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.staticobjects;

/**
 *
 * @author Guido
 */
public abstract class Gadget extends StaticObject {

    public void use() {

    }

    public boolean onCollision() {
        return true;
    }
}
