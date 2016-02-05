/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import gui.Start;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class MenuListener implements KeyListener{
    
    private JFrame frame;
    
    public MenuListener (JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_ENTER) {            
            SwingUtilities.invokeLater(new Start(frame));            
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
