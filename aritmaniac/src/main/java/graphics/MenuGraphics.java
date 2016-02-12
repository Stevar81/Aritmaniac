/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import static java.awt.Color.white;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import static javax.swing.SwingConstants.CENTER;

/**
 *
 * @author Tomi
 */
public class MenuGraphics extends JPanel {
    
    private Image backgroundImage; 

    /**
     *
     */
    public Font f;
    private String name;
    
    /**
     *
     * @throws IOException
     * @throws FontFormatException
     */
    public MenuGraphics() throws IOException, FontFormatException {
        String PicBasePath = new File("src\\main\\java\\graphics\\blackboard.jpg").getAbsolutePath();
        String fontBasePath = new File("src\\main\\java\\graphics\\ColoredCrayons.ttf").getAbsolutePath();
        
        f = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File(fontBasePath))).deriveFont(Font.PLAIN, 50);

        backgroundImage = ImageIO.read(new File(PicBasePath));
        this.name = "";
    }
    
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(backgroundImage, 0, 0, 800, 500, this);
        graphics.setColor(white);
        graphics.setFont(f);
        graphics.drawString("Welcome to Aritmaniac!", 150, 220);
        graphics.drawString(this.name, 290, 330);
        graphics.setFont(new Font("Monospaced", Font.PLAIN, 16));
        graphics.drawString("Type your name and press Space to start!", 200, 450);
    }
    
    /**
     *
     * @param name
     */
    public void refreshName(String name) {
        this.name = name;
    }
    
}

