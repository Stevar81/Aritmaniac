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
import logic.Game;

/**
 *
 * @author Tomi
 */
public class GameGraphics extends JPanel {
    
        private Image backgroundImage; 
        private String answer;
        private Game game;
        private Font f;
        private Font f2;

    /**
     *
     * @param game
     * @throws IOException
     * @throws FontFormatException
     */
    public GameGraphics(Game game) throws IOException, FontFormatException {
        this.game = game;
        this.answer = "";
        
        String PicBasePath = new File("src\\main\\java\\graphics\\blackboard.jpg").getAbsolutePath();
        String fontBasePath = new File("src\\main\\java\\graphics\\ColoredCrayons.ttf").getAbsolutePath();
        
        f = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File(fontBasePath))).deriveFont(Font.PLAIN, 50);
        f2 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File(fontBasePath))).deriveFont(Font.PLAIN, 30);
        
        backgroundImage = ImageIO.read(new File(PicBasePath));
    }
    
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(backgroundImage, 0, 0, 800, 500, this);
        graphics.setColor(white);
        graphics.setFont(f);
        graphics.drawString(game.getCalc(), 350, 270);
        graphics.drawString(answer, 580, 270);
        graphics.setFont(f2);
        graphics.drawString("Points: " + game.getPoints(), 150, 420);
        graphics.drawString("Level: " + game.getLevel(), 550, 420);
        graphics.drawString(game.getTimeString(), 350, 140);
    }
    
    /**
     *
     * @param ans
     */
    public void refreshAnswer(String ans) {
        this.answer = ans;
    }
    
    /**
     *
     * @param game
     * @throws IOException
     */
    public void refreshGame(Game game) throws IOException {
        this.game = game;
        repaint();
    }
    
}

