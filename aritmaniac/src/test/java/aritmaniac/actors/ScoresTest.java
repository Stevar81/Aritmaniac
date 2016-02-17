/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package actors;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kallava
 */
public class ScoresTest {
    
    private Scores scores;
    private Player a;
    private Player b;
    private Player c;
    private Player d;
    private Player e;
    
    public ScoresTest() {
        this.scores = new Scores();
 
        this.scores.setScore(new Player("a", 2));
        this.scores.setScore(new Player("b", 1));
        this.scores.setScore(new Player("c", 6));
        this.scores.setScore(new Player("d", 4));
        this.scores.setScore(new Player("e", 8));
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testOrder() {
        for (int i = 0; i < this.scores.getList().size(); i++) {
            assertTrue(this.scores.getList().get(i).getPoints() >= this.scores.getList().get(i).getPoints());
        }
    }
}
