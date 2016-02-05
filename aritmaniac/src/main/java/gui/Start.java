/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import graphics.EndGraphics;
import graphics.GameGraphics;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import listeners.GameListener;
import listeners.MenuListener;
import listeners.TimerListener;
import logic.Calculation;
import logic.Game;

/**
 *
 * @author Tomi
 */
public class Start implements Runnable {
    
    private JFrame frame;
    private Game game;
    
    public Start(JFrame frame){
        this.frame = frame;
        this.game = new Game();
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
            
        } catch (IOException ex) {
            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void start(Game game, GameGraphics gg, JFrame frame) throws IOException {        
        new Timer(1000, new TimerListener(frame, gg, game)).start();
     }
     

}
