/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aritmaniac.logic;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * The information about the ongoing game
 * @author Tomi
 */
public class Game {
    
    private int level;
    private int points;
    private int counter;           
    private Calculation calc;
    private int timeLeft;
    private String player;
    private String picBasePath;
    private String picBasePath2;
    private String levelUp;
    Image greenHand;
    Image redHand;
    Image hand;
        
    /**
     *
     * @param player Who is playing the game
     * @throws java.io.IOException
     */
    public Game(String player) throws IOException {
        this.picBasePath = new File("src/main/resources/greenHand.png").getAbsolutePath();
        this.picBasePath2 = new File("src/main/resources/redHand.png").getAbsolutePath();
        this.greenHand = ImageIO.read(new File(picBasePath));
        this.redHand = ImageIO.read(new File(picBasePath2));
        
        this.counter = 0;
        this.level = 1;
        this.points = 0;
        this.timeLeft = 100;
        this.calc = new Calculation(this.level);
        this.player = player;
        this.levelUp = "";
    }
    
    /**
     *
     * @return
     */
    public String getPlayer() {
        return this.player;
    }
    
    /**
     *
     * @return
     */
    public int getLevel() {
        return this.level;
    }
    
    /**
     * Removing the "thumb up"- or "thumb down"-picture
     * @return
     */
    public String getPoints() {
        this.hand = null;
        return Integer.toString(this.points);
    }

    /**
     * Increases points based on current level and gives a "thumb up".  
     * Counter resets after five consecutive right answers. And new level's been reached.
     */

    public void setPoints() {
        
        this.hand = this.greenHand;
        points = points + level;
        
        this.counter++;
        
        if (counter == 5) {
            this.counter = 0;
            level++;
            this.levelUp = "You reached level " + this.level + "!";
        }
    }
    
    /**
     * Takes back to start of current level. In other words, removes earned points and resets counter.
     * Also giving a "thumb down"
     */
    public void decPoints() {
        
        this.hand = this.redHand;
         
        this.points = this.points - (this.level * this.counter);
        
        this.counter = 0;
        
    }

    /**
     *
     * @return
     */
    public String getCalc() {
        return this.calc.toString();
    }

    /**
     *
     * @return
     */
    public int getResult() {
        return this.calc.getResult();
    }

    /**
     * Getting a new calculation task
     */
    public void newCalc() {
        this.calc = new Calculation(this.level);
    }

    /**
     * Every second time left decreases.
     */
    public void setTime() {
        this.timeLeft--;
    }
    
    /**
     * 
     * @return String to be printed on the screen while playing
     */
    public String getTimeString() {
        
        return "Time: " + Integer.toString(this.timeLeft);
    }
    
    /**
     *
     * @return
     */
    public int getTime() {
        return this.timeLeft;
    }
    
    public Image getHand() {
        return this.hand;
    }
    
    public String getLevelUp() {
        return this.levelUp;
    }
    
    public void setLevelUp() {
        this.levelUp = "";
    }
    
}
