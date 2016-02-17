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
public class GameTest {
    
    /**
     *
     */
    public GameTest() {
    }

    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }

    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     *
     */
    @Before
    public void setUp() {
    }

    /**
     *
     */
    @After
    public void tearDown() {
    }

    /**
     *
     */
    @Test
    public void setPointsTest() {

        int points = 0;
        int level = 1;
        int counter = 0;

        for (int i = 0; i < 10; i++) {
            points = points + level;

            counter++;

            if (counter == 5) {
                counter = 0;
                level++;
            }
        }

        assertEquals(0, counter);
        assertEquals(15, points);
        assertEquals(3, level);
    }
    
    /**
     *
     */
    @Test
    public void decPointsTest() {

        int points = 13;
        int level = 2;
        int counter = 4;

        
        points = points - (level * counter);

        assertEquals(5, points);
    }
    
}
