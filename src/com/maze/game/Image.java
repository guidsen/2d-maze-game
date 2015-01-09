/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import javax.imageio.ImageIO;

/**
 *
 * @author Guido
 */
public class Image {

    private static HashMap<String, BufferedImage> images = new HashMap<>();
    private BufferedImage image;
    
    public Image(String path){
        if(this.images.get(path) == null) {
            try{ 
                ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
                File file = new File(classLoader.getResource("com/maze/images/"+path).toURI());

                BufferedImage image = ImageIO.read(file);
                this.images.put(path, image);
                
                this.image = image;
            } catch(Exception e) {
                System.out.println(e);
            }
        } else {
            this.image = this.images.get(path);
        }
    }

    public BufferedImage getImage() {
        return this.image;
    }
}
