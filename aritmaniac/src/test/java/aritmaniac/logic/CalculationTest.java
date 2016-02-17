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
public class CalculationTest {
    
    /**
     *
     */
    public CalculationTest() {
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
    public void testDivision() {

        for (int i = 0; i < 10; i++) {
            int firstNumber = (int) (Math.random() * 10);
            int secondNumber = (int) (Math.random() * 10);
            
            if (secondNumber == 0) {
                while (!(secondNumber != 0)) {
                    secondNumber = (int) (Math.random() * 10);
                }
            }

            if (firstNumber % secondNumber != 0) {
                while (!(firstNumber % secondNumber == 0)) {
                    firstNumber++;
                }
            }
            

            int remainder = firstNumber % secondNumber;

            assertEquals(remainder, 0);
        }
        
    }
    
    /**
     *
     */
    @Test 
    public void generateEasyCalculation() {
        
        Calculation calc = new Calculation(1);
        char oper = calc.getOperator();
        int firstNumber = calc.getFirst();
        int secondNumber = calc.getSecond();
        int result = 0;
        
        if (oper == '+') {
            result = firstNumber + secondNumber;
        } else if (oper == '-') {
            result = firstNumber - secondNumber;
        } else if (oper == '*') {
            result = firstNumber * secondNumber;
        } else if (oper == '/') {
            result = firstNumber / secondNumber;
        }
        
        assertEquals(calc.getResult(), result);
    }
    
    /**
     *
     */
    @Test 
    public void generateHardCalculation() {
        
        Calculation calc = new Calculation(5);
        char oper = calc.getOperator();
        int firstNumber = calc.getFirst();
        int secondNumber = calc.getSecond();
        int result = 0;
        
        if (oper == '+') {
            result = firstNumber + secondNumber;
        } else if (oper == '-') {
            result = firstNumber - secondNumber;
        } else if (oper == '·') {
            result = firstNumber * secondNumber;
        } else if (oper == '/') {
            result = firstNumber / secondNumber;
        }
        
        assertEquals(calc.getResult(), result);
    }
    

    
}
