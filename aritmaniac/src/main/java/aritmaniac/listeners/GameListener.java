/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aritmaniac.listeners;

import aritmaniac.graphics.GameGraphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import aritmaniac.logic.Game;

/**
 * Listener for actions while the game runs
 * @author Tomi
 */
public class GameListener implements KeyListener {

    final String chars = "1234567890";
    private String answer;
    private GameGraphics gg;
    private Game game;

    /**
     *
     * @param gg
     * @param game
     */
    public GameListener(GameGraphics gg, Game game) {
        this.answer = "";
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
        }

        this.gg.refreshAnswer(answer);
        this.gg.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
