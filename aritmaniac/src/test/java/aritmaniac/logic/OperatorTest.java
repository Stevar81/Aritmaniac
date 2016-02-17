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
public class OperatorTest {
    
    /**
     *
     */
    public OperatorTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    /**
     *
     */
     @Test
     public void getOperator() {
         
        for (int k = 0; k < 20; k++) {
            Operator op = new Operator((int) (Math.random() * 4) + 1);
            char[] a = {'+', '-', '·', '/'};
            int i = 0;
            int s = 0;

            while (s < a.length) {
                if (a[s] == op.getOperator()) {
                    i++;
                }
                s++;
            }
            assertEquals(i, 1);
            assertEquals(s, 4);
        }
    }
}
