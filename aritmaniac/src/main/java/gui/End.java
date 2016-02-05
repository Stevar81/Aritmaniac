package gui;

import graphics.EndGraphics;
import graphics.MenuGraphics;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import listeners.EndListener;
import listeners.MenuListener;
import logic.Game;

public class End implements Runnable{

    private JFrame frame;
    private Game game;
    
    public End(JFrame frame, Game game) throws IOException{
        this.game = game;
        this.frame = frame;
    }
    
    @Override
    public void run() {
        frame.setPreferredSize(new Dimension(820, 555));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        try {
            addComponents(frame.getContentPane());
        } catch (IOException ex) {
            Logger.getLogger(End.class.getName()).log(Level.SEVERE, null, ex);
        }
        frame.pack();
        frame.setVisible(true);
    }
    
    public void addComponents(Container container) throws IOException {
        EndGraphics aloituskuva = new EndGraphics(this.game);
        container.add(aloituskuva);
        
        for (KeyListener kl : frame.getKeyListeners()) {
            frame.removeKeyListener(kl);
        }
        
        frame.addKeyListener(new EndListener(frame));
        
    }
    
    
}

