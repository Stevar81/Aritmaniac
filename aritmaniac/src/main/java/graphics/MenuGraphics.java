/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import java.awt.Color;
import static java.awt.Color.white;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

    
public class MenuGraphics extends JPanel {
    
    private Image backgroundImage; 
    
    public MenuGraphics() throws IOException {
        backgroundImage = ImageIO.read(new File("C:\\Users\\Tomi\\Desktop\\aritmaniac\\aritmaniac\\src\\main\\java\\graphics\\blackboard.jpg"));
    }
    
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(backgroundImage, 0, 0, 800, 500, this);
        graphics.setColor(white);
        graphics.setFont(new Font("Serif", Font.PLAIN, 50));
        graphics.drawString("Welcome to Aritmaniac!", 150, 220);
        graphics.setFont(new Font("Monospaced", Font.PLAIN, 16));
        graphics.drawString("Start by pressing Enter", 315, 350);
    }
    
}

