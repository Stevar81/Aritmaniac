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
        
    
    public Game() {
        this.counter = 0;
        this.level = 1;
        this.points = 0;
        this.timeLeft = 60;
        this.calc = new Calculation(this.level);
    }
    
    public int getLevel() {
        return this.level;
    }
    
    public String getPoints() {
        return Integer.toString(this.points);
    }

    public void setPoints() {

        points = points + level;
        
        this.counter++;
        
        if (counter == 5 && level < 5) {
            this.counter = 0;
            level++;
        }
    }
    
    public void decPoints() {
        
        this.points -= this.level * this.counter;
        
        this.counter = 0;
        
        if (this.points < 0) {
            this.points = 0;
        }
    }

    public String getCalc() {
        return this.calc.toString();
    }

    public int getResult() {
        return this.calc.getResult();
    }

    public void newCalc() {
        this.calc = new Calculation(this.level);
    }

    public void setTime() {
        this.timeLeft--;
    }
    
    public void setTime(int i) {
        this.timeLeft = i;
    }

    public String getTimeString() {
        
        return "Time: " + Integer.toString(this.timeLeft);
    }
    
    public int getTime() {
        return this.timeLeft;
    }

    public String getCounter() {
        if (counter == 0) {
            return "☆☆☆☆☆";
        } else if (counter == 1) {
            return "★☆☆☆☆";
        } else if (counter == 2) {
            return "★★☆☆☆";
        } else if (counter == 3) {
            return "★★★☆☆";
        } else if (counter == 4) {
            return "★★★★☆";
        }
            
        return "★★★★★";
        
    }
    
}
