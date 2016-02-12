/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import graphics.MenuGraphics;
import gui.Start;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Tomi
 */
public class MenuListener implements KeyListener{
    
    private JFrame frame;
    private String name;
    private MenuGraphics mg;
    
    /**
     *
     * @param frame
     * @param mg
     */
    public MenuListener (JFrame frame, MenuGraphics mg) {
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
            SwingUtilities.invokeLater(new Start(frame, name));            
        } else if (ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            String temp = "";
            for (int i = 0; i < name.length() - 1; i++) {
                temp += name.charAt(i);
            }
            name = temp;
        } else {
            if (name.length() <= 8)
                name = name + ke.getKeyChar();
        }

        this.mg.refreshName(name);
        this.mg.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
