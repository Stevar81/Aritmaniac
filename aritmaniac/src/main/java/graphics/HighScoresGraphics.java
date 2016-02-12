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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import logic.Game;

/**
 *
 * @author Tomi
 */
public class HighScoresGraphics extends JPanel {
    
    private Image backgroundImage; 
    private Font f;
    private BufferedWriter out;
    Scanner in;
    
    /**
     *
     * @throws IOException
     * @throws FontFormatException
     */
    public HighScoresGraphics() throws IOException, FontFormatException {
     
        String PicBasePath = new File("src\\main\\java\\graphics\\blackboard.jpg").getAbsolutePath();
        String fontBasePath = new File("src\\main\\java\\graphics\\ColoredCrayons.ttf").getAbsolutePath();
        
        f = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File(fontBasePath))).deriveFont(Font.PLAIN, 50);

        backgroundImage = ImageIO.read(new File(PicBasePath));
        this.in = new Scanner(new FileReader("src\\main\\java\\graphics\\filename.txt"));
    }
    
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(backgroundImage, 0, 0, 800, 500, this);
        graphics.setColor(white);
        graphics.setFont(f);
        graphics.drawString("High scores", 150, 180);
        graphics.setFont(new Font("Monospaced", Font.PLAIN, 16));
        int x = 0;
        while (in.hasNext()) {
            graphics.drawString(in.next(), 215, 200 + x);
            x += 20;
        }
        
        
        
        graphics.drawString("[Esc] Back", 515, 450);
    }
    
}

