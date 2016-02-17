/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aritmaniac.listeners;

import aritmaniac.logic.Game;
import aritmaniac.gui.HighScores;
import aritmaniac.gui.Menu;
import aritmaniac.gui.Start;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


/**
 *
 * @author Tomi
 */
public class EndListener implements KeyListener {
    
    private JFrame frame;
    private Game game;
    
    /**
     *
     * @param frame
     * @param game
     */
    public EndListener(JFrame frame, Game game) {
        this.frame = frame;
        this.game = game;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_SPACE) {            
            SwingUtilities.invokeLater(new Start(frame, game.getPlayer()));            
        }
        if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {            
            frame.setVisible(false);
            frame.dispose();
        }
        if (ke.getKeyCode() == KeyEvent.VK_M) {            
            try {            
                SwingUtilities.invokeLater(new Menu());
                frame.setVisible(false);
                frame.dispose();
            } catch (IOException ex) {
                Logger.getLogger(EndListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (ke.getKeyCode() == KeyEvent.VK_F1) {            
            try {
                SwingUtilities.invokeLater(new HighScores());
            } catch (IOException ex) {
                Logger.getLogger(EndListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
