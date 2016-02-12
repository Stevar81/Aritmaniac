
package gui;

import graphics.MenuGraphics;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import listeners.MenuListener;

/**
 *
 * @author Tomi
 */
public class Menu implements Runnable{

    private JFrame frame;
    
    /**
     *
     * @throws IOException
     */
    public Menu() throws IOException{
    }
    
    @Override
    public void run() {
        
        frame = new JFrame("Aritmaniac");
        frame.setLocation(550,150);
        frame.setPreferredSize(new Dimension(820, 555));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        try {
            addComponents(frame.getContentPane());
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FontFormatException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
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
        MenuGraphics mg = new MenuGraphics();
        container.add(mg);
        frame.addKeyListener(new MenuListener(frame, mg));
    }
    
    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Menu ui = new Menu();
        SwingUtilities.invokeLater(ui);
    }
    
}
