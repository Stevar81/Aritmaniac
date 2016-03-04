/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aritmaniac.logic;

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
    
    private Operator op1;
    private Operator op2;
    private Operator op3;
    private Operator op4;
    private Operator op5;
    private Operator op6;
    
    /**
     *
     */
    public OperatorTest() {
        this.op1 = new Operator(1);
        this.op2 = new Operator(2);
        this.op3 = new Operator(3);
        this.op4 = new Operator(4);
        this.op5 = new Operator(5);
        this.op6 = new Operator(6);
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
            Operator oper = new Operator((int) (Math.random() * 4) + 1);
            char[] a = {'+', '-', '·', '/'};
            int i = 0;
            int s = 0;

            while (s < a.length) {
                if (a[s] == oper.getOperator()) {
                    i++;
                }
                s++;
            }
            assertEquals(i, 1);
            assertEquals(s, 4);
        }
    }

    @Test
    public void testOperators() {
        assertTrue(this.op1.getOperator() == '+' || this.op1.getOperator() == '-');
        assertTrue(this.op2.getOperator() == '+' || this.op2.getOperator() == '-' || this.op2.getOperator() == '·');
        assertTrue(this.op3.getOperator() == '+' || this.op3.getOperator() == '-' || this.op3.getOperator() == '·' || this.op3.getOperator() == '/');
        assertTrue(this.op4.getOperator() == '+' || this.op4.getOperator() == '-' || this.op4.getOperator() == '·' || this.op4.getOperator() == '/');
        assertTrue(this.op5.getOperator() == '·' || this.op5.getOperator() == '/');
        assertTrue(this.op6.getOperator() == '·' || this.op6.getOperator() == '/');
    }
}
