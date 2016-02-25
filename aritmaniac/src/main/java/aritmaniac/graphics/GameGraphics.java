/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aritmaniac.graphics;

import static java.awt.Color.white;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.io.IOException;
import aritmaniac.logic.Game;
import static java.awt.Color.green;

/**
 *
 * @author Tomi
 */
public class GameGraphics extends MainGraphics {
     
    private String answer;
    private Game game;
    /**
     *
     * @param game
     * @throws IOException
     * @throws FontFormatException
     */
    public GameGraphics(Game game) throws IOException, FontFormatException {
        this.game = game;
        this.answer = "";
    }
    
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        graphics.drawImage(game.getHand(), 100, 100, 100, 100, this);
        graphics.setColor(green);
        graphics.setFont(f2);
        graphics.drawString(game.getLevelUp(), 450, 50);
        graphics.setColor(white);       
        graphics.drawString("Now playing:   " + game.getPlayer(), 20, 50);
        graphics.setFont(f1);
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

