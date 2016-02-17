/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actors;

import java.util.ArrayList;
import java.util.Collections;
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
    
    public List<Player> getList() {
        Collections.sort(this.scores, new Comparator<Player>() {
            @Override
            public int compare(Player player1, Player player2) {
                return player1.compareTo(player2);
            }
        });
        return this.scores;
    }
      
}
