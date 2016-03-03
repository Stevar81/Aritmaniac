/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aritmaniac.graphics;

import aritmaniac.actors.Scores;
import static java.awt.Color.white;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.io.IOException;
import aritmaniac.logic.Game;

/**
 * Graphics for the view that is visible after the game ends.
 * @author Tomi
 */
public class EndGraphics extends MainGraphics {
     
    private Game game;
    private Scores scores;
    
    /**
     * Constructor.
     * @param game Information about the game that just ended
     * @throws IOException exception
     * @throws FontFormatException exception
     */
    public EndGraphics(Game game) throws IOException, FontFormatException {
        this.game = game;
        this.scores = new Scores();
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
        graphics.setFont(new Font("Serif", Font.PLAIN, 30));
        if (this.scores.getList().size() > 9 && this.scores.getList().get(9).getPoints() >= Integer.parseInt(game.getPoints())) {
            graphics.drawString("You didn't make it to top ten.", 150, 290);
        } else {
            graphics.drawString("You made it to top ten!!", 150, 290);
        }
        graphics.setFont(new Font("Monospaced", Font.PLAIN, 16));
        graphics.drawString("[Esc] Exit", 480, 450);
        graphics.drawString("[M] Menu", 365, 450);
        graphics.drawString("[Space] Start a new game", 80, 450);
        graphics.drawString("[F1] High Scores", 605, 450);
    }
    
}
