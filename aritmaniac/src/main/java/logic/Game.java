/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author Tomi
 */
public class Game {
    
    private int level;
    private int points;
    private int counter;           
    private Calculation calc;
    private int timeLeft;
    private String player;
        
    /**
     *
     * @param player Who is playing the game
     */
    public Game(String player) {
        this.counter = 0;
        this.level = 1;
        this.points = 0;
        this.timeLeft = 2;
        this.calc = new Calculation(this.level);
        this.player = player;
    }
    
    /**
     *
     * @param player
     */
    public void setPlayer(String player) {
        this.player = player;
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
     *
     * @return
     */
    public String getPoints() {
        return Integer.toString(this.points);
    }

    /**
     * Increases points based on current level. 
     * Counter resets after five consecutive right answers. And new level's been reached.
     */

    public void setPoints() {
        
        points = points + level;
        
        this.counter++;
        
        if (counter == 5) {         
            this.counter = 0;
            level++;
        }
    }
    
    /**
     *
     */
    public void decPoints() {
        
        //A wrong answer takes you back to start of current level. In other words, removes earned points and resets counter. 
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
     *
     */
    public void newCalc() {
        this.calc = new Calculation(this.level);
    }

    /**
     *
     */
    public void setTime() {
        this.timeLeft--;
    }
    
    /**
     *
     * @param i
     */
    public void setTime(int i) {
        this.timeLeft = i;
    }

    /**
     *
     * @return
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
    
}
