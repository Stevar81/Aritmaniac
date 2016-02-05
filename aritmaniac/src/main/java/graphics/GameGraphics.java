/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import gui.Menu;
import java.awt.Color;
import static java.awt.Color.white;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import logic.Calculation;
import logic.Game;

/**
 *
 * @author Tomi
 */
public class GameGraphics extends JPanel {
    
        private Image backgroundImage; 
        private String answer;
        private Game game;


    public GameGraphics(Game game) throws IOException {
        this.game = game;
        this.answer = "";
        backgroundImage = ImageIO.read(new File("C:\\Users\\Tomi\\Desktop\\aritmaniac\\aritmaniac\\src\\main\\java\\graphics\\blackboard.jpg"));
    }
    
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(backgroundImage, 0, 0, 800, 500, this);
        graphics.setColor(white);
        graphics.setFont(new Font("Serif.italic", Font.PLAIN, 60));
        graphics.drawString(game.getCalc(), 150, 220);
        graphics.drawString(answer, 550, 220);
        graphics.setFont(new Font("Serif.italic", Font.PLAIN, 30));
        graphics.drawString("Points: " + game.getPoints(), 150, 420);
        graphics.drawString("Level: " + game.getLevel(), 350, 420);
        graphics.setFont(new Font("Serif.italic", Font.PLAIN, 15));
        graphics.drawString(game.getCounter(), 500, 420);
        graphics.setFont(new Font("Serif.italic", Font.PLAIN, 30));
        graphics.drawString(game.getTimeString(), 350, 120);
    }
    
    public void refreshAnswer(String ans) {
        this.answer = ans;
    }
    
    public void refreshGame(Game game) throws IOException {
        this.game = game;
        repaint();
    }
    
}

