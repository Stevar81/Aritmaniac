package aritmaniac.gui;

import aritmaniac.graphics.HighScoresGraphics;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FontFormatException;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import aritmaniac.listeners.HighScoresListener;

/**
 * Creates a frame for Highscoregraphics.
 * @author Tomi
 */
public class HighScores implements Runnable {

    private JFrame frame;
    
    /**
     * Constructor.
     * @throws IOException exception
     */
    public HighScores() throws IOException {
        
    }
    
    @Override
    public void run() {
        frame = new JFrame("Aritmaniac");
        frame.setLocation(550, 150);
        frame.setPreferredSize(new Dimension(820, 555));
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        try {
            addComponents(frame.getContentPane());
        } catch (IOException | FontFormatException ex) {
            Logger.getLogger(HighScores.class.getName()).log(Level.SEVERE, null, ex);
        }
        frame.pack();
        frame.setVisible(true);
    }
    
    /**
     * Adding graphics and replacing keylisteners.
     * @param container container
     * @throws IOException exception
     * @throws FontFormatException exception
     */
    public void addComponents(Container container) throws IOException, FontFormatException {
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        HighScoresGraphics score = new HighScoresGraphics();
        container.add(score);
        
        for (KeyListener kl : frame.getKeyListeners()) {
            frame.removeKeyListener(kl);
        }
        frame.addKeyListener(new HighScoresListener(frame));   
    }
}


