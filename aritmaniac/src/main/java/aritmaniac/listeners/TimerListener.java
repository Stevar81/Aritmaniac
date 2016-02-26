/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aritmaniac.listeners;

import aritmaniac.graphics.GameGraphics;
import aritmaniac.gui.Start;
import aritmaniac.gui.End;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import aritmaniac.logic.Game;

/**
 * Timerlistener refreshes the game information every second so that the countdown clock runs and creates the end frame when counter reaches zero.
 * @author Tomi
 */
public class TimerListener implements ActionListener {

    private JFrame frame;
    private GameGraphics gg;
    private Game game;
    private BufferedWriter out;

    /**
     *
     * @param frame
     * @param gg
     * @param game
     * @throws java.io.FileNotFoundException
     */
    public TimerListener(JFrame frame, GameGraphics gg, Game game) throws FileNotFoundException, IOException {
        this.frame = frame;
        this.gg = gg;
        this.game = game;
        this.out = new BufferedWriter(new FileWriter("src/main/resources/filename.txt", true));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            gg.refreshGame(game);
            if (game.getTime() <= 0) {
                ((Timer) e.getSource()).stop();
                SwingUtilities.invokeLater(new End(frame, game));
                out.write(game.getPoints() + game.getPlayer() + "\n");
                out.close();
            } else {
                game.setTime();
            }
        } catch (IOException ex) {
            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
