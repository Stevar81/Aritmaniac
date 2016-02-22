/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aritmaniac.listeners;

import aritmaniac.graphics.MenuGraphics;
import aritmaniac.gui.HighScores;
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
public class MenuListener implements KeyListener {
    
    final String chars = "zaqxswcdevfrbgtnhymjukiloöpäå";
    private JFrame frame;
    private String name;
    private MenuGraphics mg;
    
    /**
     *
     * @param frame
     * @param mg
     */
    public MenuListener(JFrame frame, MenuGraphics mg) {
        this.frame = frame;
        this.mg = mg;
        this.name = "";
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_SPACE) {   
            if (!name.equals("")) {
                try {
                    SwingUtilities.invokeLater(new Start(frame, name));
                } catch (IOException ex) {
                    Logger.getLogger(MenuListener.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else if (ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            String temp = "";
            for (int i = 0; i < name.length() - 1; i++) {
                temp += name.charAt(i);
            }
            name = temp;
        } else if (ke.getKeyCode() == KeyEvent.VK_F1) {            
            try {
                SwingUtilities.invokeLater(new HighScores());
            } catch (IOException ex) {
                Logger.getLogger(MenuListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (chars.contains(Character.toString(ke.getKeyChar()))) {
            if (name.length() <= 8) { 
                name = name + ke.getKeyChar();
            }
        } else if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {            
            frame.setVisible(false);
            frame.dispose();
        }

        this.mg.refreshName(name);
        this.mg.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
