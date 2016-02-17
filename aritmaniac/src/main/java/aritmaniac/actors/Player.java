/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actors;

/**
 *
 * @author Tomi
 */
public class Player {
    
    private String name;
    private int points;
    
    public Player(String name, int points) {
        this.name = name;
        this.points = points;
    }
    
    public void setPoints(int points) {
        this.points = points;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getPoints() {
        return this.points;
    }

    int compareTo(Player player2) {
        
        int comparePoints = player2.getPoints();
            
        return comparePoints - this.points;
    }
    
}
