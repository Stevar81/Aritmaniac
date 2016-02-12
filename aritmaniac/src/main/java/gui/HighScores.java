package gui;

import graphics.HighScoresGraphics;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FontFormatException;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import listeners.HighScoresListener;
import logic.Game;

/**
 *
 * @author Tomi
 */
public class HighScores implements Runnable{

    private JFrame frame;
    private JFrame frame2;
    
    /**
     *
     * @param frame
     * @throws IOException
     */
    public HighScores(JFrame frame) throws IOException{
        this.frame2 = frame;
    }
    
    @Override
    public void run() {
        frame = new JFrame("Aritmaniac");
        frame.setLocation(550,150);
        frame.setPreferredSize(new Dimension(820, 555));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        try {
            addComponents(frame.getContentPane());
        } catch (IOException | FontFormatException ex) {
            Logger.getLogger(HighScores.class.getName()).log(Level.SEVERE, null, ex);
        }
        frame.pack();
        frame.setVisible(true);
    }
    
    /**
     *
     * @param container
     * @throws IOException
     * @throws FontFormatException
     */
    public void addComponents(Container container) throws IOException, FontFormatException {
        HighScoresGraphics score = new HighScoresGraphics();
        container.add(score);
        
        for (KeyListener kl : frame.getKeyListeners()) {
            frame.removeKeyListener(kl);
        }
        frame.addKeyListener(new HighScoresListener(frame, frame2));   
    }
}


