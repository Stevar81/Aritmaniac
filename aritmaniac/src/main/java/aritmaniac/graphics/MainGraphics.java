/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aritmaniac.graphics;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Tomi
 */
public class MainGraphics extends JPanel {
    
    Image backgroundImage; 
    public Font f1;
    public Font f2;
    
    /**
     *
     * @throws IOException
     * @throws FontFormatException
     */
    public MainGraphics() throws IOException, FontFormatException {
        String picBasePath = new File("src/main/resources/blackboard.jpg").getAbsolutePath();
        String fontBasePath = new File("src/main/resources/ColoredCrayons.ttf").getAbsolutePath();

        f1 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File(fontBasePath))).deriveFont(Font.PLAIN, 50);
        f2 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File(fontBasePath))).deriveFont(Font.PLAIN, 32);

        backgroundImage = ImageIO.read(new File(picBasePath));
    }
}
