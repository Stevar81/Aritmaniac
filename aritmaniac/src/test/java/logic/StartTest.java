/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tomi
 */
public class StartTest {
    
    public StartTest() {
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

    
    @Test
    public void pointsTest() {
        
        int[] results = {1, 4, 3, 56, 33, 22, 5, 3, 4, 2, 0};
        
        int[] answers = {1, 4, 3, 56, 3, 22, 5, 3, 9, 2, 0};
        
        int points = 0;
        int counter = 0;
        int level = 1;

        for (int i = 0; i < results.length; i++) {
            if (results[i] == answers[i]) {
                points = points + level;
                System.out.println("Yeah!");
                counter++;
                if (counter % 3 == 0 && level < 5) {
                    level++;
                    System.out.println("Level " + level);
                }
            } else {
                System.out.println("Wrong! :(");

                if (!(counter % 3 == 0)) {
                    counter--;
                }

                points -= 2;
                if (points < 0) {
                    points = 0;
                }
            }
        }
        
        assertEquals(points, 13);

    }
}
