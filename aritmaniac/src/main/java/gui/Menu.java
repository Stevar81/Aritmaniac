
package gui;

import graphics.MenuGraphics;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import listeners.MenuListener;

public class Menu implements Runnable{

    private JFrame frame;
    
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
        }
        frame.pack();
        frame.setVisible(true);
    }
    
    public void addComponents(Container container) throws IOException {
        MenuGraphics aloituskuva = new MenuGraphics();
        container.add(aloituskuva);
        frame.addKeyListener(new MenuListener(frame));
    }
    
    public static void main(String[] args) throws IOException {
        Menu ui = new Menu();
        SwingUtilities.invokeLater(ui);
    }
    
}
