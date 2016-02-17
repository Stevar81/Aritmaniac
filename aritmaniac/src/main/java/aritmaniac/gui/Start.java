/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aritmaniac.gui;

import aritmaniac.graphics.GameGraphics;
import java.awt.FontFormatException;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.Timer;
import aritmaniac.listeners.GameListener;
import aritmaniac.listeners.TimerListener;
import aritmaniac.logic.Game;

/**
 *
 * @author Tomi
 */
public class Start implements Runnable {
    
    private JFrame frame;
    private Game game;
    
    /**
     *
     * @param frame
     * @param name
     */
    public Start(JFrame frame, String name) {
        this.frame = frame;
        this.game = new Game(name);
    }
    
    @Override
    public void run() {
        try {
            GameGraphics start = new GameGraphics(game);
            frame.getContentPane().add(start);
            
            frame.pack();
            frame.setVisible(true);
            
            for (KeyListener kl : frame.getKeyListeners()) {
                frame.removeKeyListener(kl);
            }

            frame.addKeyListener(new GameListener(start, game));
            
            start(game, start, frame);
            
        } catch (IOException | FontFormatException ex) {
            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     *
     * @param game
     * @param gg
     * @param frame
     * @throws IOException
     */
    public void start(Game game, GameGraphics gg, JFrame frame) throws IOException {        
        new Timer(1000, new TimerListener(frame, gg, game)).start();
    }
    
}
