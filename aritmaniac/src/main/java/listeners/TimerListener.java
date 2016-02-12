/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import graphics.GameGraphics;
import gui.Start;
import gui.End;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import logic.Game;

/**
 *
 * @author Tomi
 */
public class TimerListener implements ActionListener {

    private JFrame frame;
    private GameGraphics gg;
    private Game game;

    /**
     *
     * @param frame
     * @param gg
     * @param game
     */
    public TimerListener(JFrame frame, GameGraphics gg, Game game) {
        this.frame = frame;
        this.gg = gg;
        this.game = game;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            gg.refreshGame(game);
            if (game.getTime() <= 0) {
                ((Timer) e.getSource()).stop();
                SwingUtilities.invokeLater(new End(frame, game));
            } else {
                game.setTime();
            }
        } catch (IOException ex) {
            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
