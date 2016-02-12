/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import gui.Menu;
import gui.Start;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import logic.Game;

/**
 *
 * @author Tomi
 */
public class HighScoresListener implements KeyListener{
    
    private JFrame frame;
    private JFrame frame2;
    
    /**
     *
     * @param frame
     */
    public HighScoresListener (JFrame frame, JFrame frame2) {
        this.frame = frame;
        this.frame2 = frame2;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {            
            frame.setVisible(false);
            frame.dispose();
            frame2.setVisible(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}

