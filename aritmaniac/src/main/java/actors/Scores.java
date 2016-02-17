/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actors;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Tomi
 */
public class Scores {
    
    private List<Player> scores;
    
    public Scores() {
        this.scores = new ArrayList<>();
    }
    
    public void setScore(Player player) {
        this.scores.add(player);
    }
	
    public static Comparator<Player> pointsComparator = (Player player1, Player player2) -> player1.compareTo(player2);
    
    public List<Player> getList() {
        this.scores.sort(pointsComparator);
        return this.scores;
    }
    
}
