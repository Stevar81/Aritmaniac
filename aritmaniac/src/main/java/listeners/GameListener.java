/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import graphics.GameGraphics;
import gui.Start;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import logic.Game;

/**
 *
 * @author Tomi
 */
public class GameListener implements KeyListener {

    final String merkit = "1234567890";
    private String answer;
    private GameGraphics gg;
    private Game game;

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
        } else if (merkit.contains(Character.toString(e.getKeyChar()))) {
            answer = answer + e.getKeyChar();
        }
        
        this.gg.refreshAnswer(answer);
        this.gg.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    }

    


