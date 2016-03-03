/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aritmaniac.listeners;

import aritmaniac.graphics.GameGraphics;
import aritmaniac.gui.Menu;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import aritmaniac.logic.Game;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Listener for actions while the game runs.
 * @author Tomi
 */
public class GameListener implements KeyListener {

    final String chars = "1234567890";
    private String answer;
    private JFrame frame;
    private GameGraphics gg;
    private Game game;

    /**
     * Constructor.
     * @param frame frame
     * @param gg game graphics
     * @param game game
     */
    public GameListener(JFrame frame, GameGraphics gg, Game game) {
        this.answer = "";
        this.frame = frame;
        this.gg = gg;
        this.game = game;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!(answer.equals(""))) {
                game.setLevelUp();
                if (Integer.parseInt(answer) == game.getResult()) {
                    game.setPoints();
                } else {
                    game.decPoints();
                }
                answer = "";
                this.game.newCalc();
                try {
                    this.gg.refreshGame(this.game);
                } catch (IOException ex) {
                    Logger.getLogger(GameListener.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else if (chars.contains(Character.toString(e.getKeyChar()))) {
            if (answer.length() <= 6) {
                answer = answer + e.getKeyChar();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            String temp = "";
            for (int i = 0; i < answer.length() - 1; i++) {
                temp += answer.charAt(i);
            }
            answer = temp;
        } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {            
            try {            
                SwingUtilities.invokeLater(new Menu());
                frame.setVisible(false);
                frame.dispose();
            } catch (IOException ex) {
                Logger.getLogger(EndListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        this.gg.refreshAnswer(answer);
        this.gg.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
