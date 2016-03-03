/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aritmaniac.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 * Listener for closing the high score-window.
 * @author Tomi
 */
public class HighScoresListener implements KeyListener {
    
    private JFrame frame;
    
    /**
     * Constructor.
     * @param frame frame
     */
    public HighScoresListener(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {            
            frame.setVisible(false);
            frame.dispose();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}

