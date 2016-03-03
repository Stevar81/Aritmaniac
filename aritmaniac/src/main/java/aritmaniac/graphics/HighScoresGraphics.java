/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aritmaniac.graphics;

import aritmaniac.actors.Player;
import aritmaniac.actors.Scores;
import static java.awt.Color.white;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.io.IOException;

/**
 * Graphics for the high score-list.
 * @author Tomi
 */
public class HighScoresGraphics extends MainGraphics {

    
   
    private Scores scores;

    /**
     * Constructor.
     * @throws IOException exception
     * @throws FontFormatException exception
     */
    public HighScoresGraphics() throws IOException, FontFormatException {
        this.scores = new Scores();
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        graphics.setColor(white);
        graphics.setFont(f1);
        graphics.drawString("High scores", 150, 80);
        drawList(graphics);
        graphics.setFont(new Font("Monospaced", Font.PLAIN, 16));
        graphics.drawString("[Esc] Back", 515, 450);
    }

    /**
     * Printing the high score-list correctly
     * @param graphics
     */
    private void drawList(Graphics graphics) {
        
        graphics.setFont(f2);
        int x = 0;
        int y = 0;
        int k = 1;
        int s = 0;
        int n = 0;
        Player o = new Player("", -1);
        String print = "";

        for (Player p : scores.getList()) {
            if (o.getPoints() != p.getPoints()) {
                k += s;
                s = 1;
                print = k + ". " + p.getName() + "" + String.format("%" + (10 - p.getName().length()) + "s", "") + p.getPoints();
            } else {
                print = k + ". " + p.getName() + "" + String.format("%" + (10 - p.getName().length()) + "s", "") + p.getPoints();
                s++;
            }
            if (n < 5) {
                graphics.drawString(print, 150, 130 + x);
                x += 40;
            } else {
                graphics.drawString(print, 400, 130 + y);
                y += 40;
            }
            if (n == 9) {
                break;
            }
            n++;
            o = p;
        }
    }

}
