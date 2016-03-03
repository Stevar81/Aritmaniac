/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aritmaniac.actors;

/**
 * Player object for high score-list.
 * @author Tomi
 */
public class Player {
    
    private String name;
    private int points;
    
    /**
     * Constructor. Player is created by giving name and points.
     * @param name Player's name
     * @param points Player's points
     */
    public Player(String name, int points) {
        this.name = name;
        this.points = points;
    }
    
    /**
     * Set player's points.
     * @param points points
     */
    public void setPoints(int points) {
        this.points = points;
    }
    
    /**
     * Get player's name.
     * @return name
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Get points.
     * @return points
     */
    public int getPoints() {
        return this.points;
    }
    
    /**
     * Comparing points with this and other player
     * @return positive or negative value
     */
    int compareTo(Player player2) {
        
        int comparePoints = player2.getPoints();
            
        return comparePoints - this.points;
    }
    
}
