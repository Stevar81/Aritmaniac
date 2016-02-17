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
import aritmaniac.logic.Game;

/**
 *
 * @author Tomi
 */
public class EndGraphics extends MainGraphics {
     
    private Game game;
    
    /**
     *
     * @param game
     * @throws IOException
     * @throws FontFormatException
     */
    public EndGraphics(Game game) throws IOException, FontFormatException {
        this.game = game;
    }
    
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        graphics.setColor(white);
        graphics.setFont(f1);
        graphics.drawString("Game Over!", 150, 180);
        graphics.setFont(new Font("Serif", Font.PLAIN, 30));
        if (game.getPoints().equals("1")) {
            graphics.drawString("You got " + game.getPoints() + " point", 450, 180);
        } else {
            graphics.drawString("You got " + game.getPoints() + " points", 450, 180);
        }
        graphics.setFont(new Font("Serif", Font.PLAIN, 20));
        graphics.drawString("You didn't make it to...", 150, 290);
        graphics.setFont(new Font("Monospaced", Font.PLAIN, 16));
        graphics.drawString("[Esc] Exit", 480, 450);
        graphics.drawString("[M] Menu", 365, 450);
        graphics.drawString("[Space] Start a new game", 80, 450);
        graphics.drawString("[F1] High Scores", 605, 450);
    }
    
}
