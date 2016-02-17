/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aritmaniac.graphics;

import static java.awt.Color.white;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.io.IOException;

/**
 *
 * @author Tomi
 */
public class MenuGraphics extends MainGraphics {
    
    private String name;
    
    /**
     *
     * @throws IOException
     * @throws FontFormatException
     */
    public MenuGraphics() throws IOException, FontFormatException{
        this.name = "";
    }
    
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        graphics.setColor(white);
        graphics.setFont(f2);
        graphics.drawString("Welcome to Aritmaniac!", 150, 220);
        graphics.drawString(this.name, 290, 330);
        graphics.setFont(new Font("Monospaced", Font.PLAIN, 16));
        graphics.drawString("Type your name and press Space to start!", 100, 450);
        graphics.drawString("[F1] High Scores", 600, 450);
    }
    
    /**
     *
     * @param name
     */
    public void refreshName(String name) {
        this.name = name;
    }
    
}

