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
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import logic.Game;

/**
 *
 * @author Tomi
 */
public class HighScoresGraphics extends JPanel {
    
    final String chars = "1234567890";
    private Image backgroundImage; 
    private Font f;
    private Font f2;
    private BufferedWriter out;
    private Scanner in;
    private Map<String, String> players;
    
    /**
     *
     * @throws IOException
     * @throws FontFormatException
     */
    public HighScoresGraphics() throws IOException, FontFormatException {
     
        String PicBasePath = new File("src\\main\\java\\graphics\\blackboard.jpg").getAbsolutePath();
        String fontBasePath = new File("src\\main\\java\\graphics\\ColoredCrayons.ttf").getAbsolutePath();
        
        f = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File(fontBasePath))).deriveFont(Font.PLAIN, 50);
        f2 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File(fontBasePath))).deriveFont(Font.PLAIN, 32);

        backgroundImage = ImageIO.read(new File(PicBasePath));
        this.in = new Scanner(new FileReader("src\\main\\java\\graphics\\filename.txt"));
        this.players = new HashMap<>();
        
        while (in.hasNext()) {
            int i = 0;
            String line = in.next();
            String points = "";
            String name = "";
            while(chars.contains(Character.toString(line.charAt(i)))) {
                points += line.charAt(i);
                i++;
            }
            while(i < line.length()) {
                name += line.charAt(i);
                i++;
            }
            players.put(name, points);
        }
        
    }
    
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(backgroundImage, 0, 0, 800, 500, this);
        graphics.setColor(white);
        graphics.setFont(f);
        graphics.drawString("High scores", 150, 80);
        graphics.setFont(f2);
        int x = 0;
        int k = 0;
        for (Map.Entry<String, String> e : players.entrySet()) {
            k++;
            String print = k + ". " + e.getKey() + ": " + e.getValue();           
            graphics.drawString(print, 150, 130 + x);
            x += 40;
        }
               
        graphics.setFont(new Font("Monospaced", Font.PLAIN, 16));
        graphics.drawString("[Esc] Back", 515, 450);
    }
    
}

