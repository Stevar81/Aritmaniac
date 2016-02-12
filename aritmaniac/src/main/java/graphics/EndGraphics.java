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
public class EndGraphics extends JPanel {
    
    private Image backgroundImage; 
    private Game game;
    private Font f;
    
    /**
     *
     * @param game
     * @throws IOException
     * @throws FontFormatException
     */
    public EndGraphics(Game game) throws IOException, FontFormatException {
        this.game = game;
        
        String PicBasePath = new File("src\\main\\java\\graphics\\blackboard.jpg").getAbsolutePath();
        String fontBasePath = new File("src\\main\\java\\graphics\\ColoredCrayons.ttf").getAbsolutePath();
        
        f = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File(fontBasePath))).deriveFont(Font.PLAIN, 50);

        backgroundImage = ImageIO.read(new File(PicBasePath));
    }
    
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(backgroundImage, 0, 0, 800, 500, this);
        graphics.setColor(white);
        graphics.setFont(f);
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
        graphics.drawString("[Esc] Exit", 515, 400);
        graphics.drawString("[M] Menu", 400, 400);
        graphics.drawString("[Space] Start a new game", 115, 400);
    }
    
}
