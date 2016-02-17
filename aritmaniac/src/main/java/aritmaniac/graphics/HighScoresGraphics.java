/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import actors.Player;
import actors.Scores;
import static java.awt.Color.white;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Tomi
 */
public class HighScoresGraphics extends MainGraphics {

    final String chars = "1234567890";
    private Scanner in;
    private Scores scores;

    /**
     *
     * @throws IOException
     * @throws FontFormatException
     * @throws java.io.FileNotFoundException
     */
    public HighScoresGraphics() throws IOException, FontFormatException, FileNotFoundException {

        File f = new File("src\\main\\resources\\filename.txt");
        this.scores = new Scores();

        if (f.exists() && !f.isDirectory()) {
            this.in = new Scanner(new FileReader("src\\main\\resources\\filename.txt"));

            while (in.hasNext()) {
                int i = 0;
                String line = in.next();
                String points = "";
                String name = "";
                while (chars.contains(Character.toString(line.charAt(i)))) {
                    points += line.charAt(i);
                    i++;
                }
                while (i < line.length()) {
                    name += line.charAt(i);
                    i++;
                }
                Player player = new Player(name, Integer.parseInt(points));
                scores.setScore(player);
            }
        }

    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        graphics.setColor(white);
        graphics.setFont(f1);
        graphics.drawString("High scores", 150, 80);
        graphics.setFont(f2);
        int x = 0;
        int y = 0;
        int k = 1;
        int s = 0;
        Player o = new Player("", -1);
        String print = "";

        for (Player p : scores.getList()) {
            if (o.getPoints() != p.getPoints()) {
                k += s;
                s = 1;
                print = k + ". " + p.getName() + ": " + String.format("%" + (10 - p.getName().length()) + "s", "") + p.getPoints();
            } else {
                print = k + ". " + p.getName() + ": " + String.format("%" + (10 - p.getName().length()) + "s", "") + p.getPoints();
                s++;
            }
            if (k < 6) {
                graphics.drawString(print, 150, 130 + x);
                x += 40;
            } else {
                graphics.drawString(print, 400, 130 + y);
                y += 40;
            }
            if (k == 10) {
                break;
            }

            o = p;
        }

        graphics.setFont(new Font("Monospaced", Font.PLAIN, 16));
        graphics.drawString("[Esc] Back", 515, 450);
    }

}
