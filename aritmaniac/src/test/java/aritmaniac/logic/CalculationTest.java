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
    
    private Calculation calc;
    private Calculation calc2;
    private Calculation calc3;
    private Calculation calc4;
    private Calculation calc5;
    private Calculation calc6;
    
    /**
     *
     */
    public CalculationTest() {
        this.calc = new Calculation(1);
        this.calc2 = new Calculation(2);
        this.calc3 = new Calculation(3);
        this.calc4 = new Calculation(4);
        this.calc5 = new Calculation(5);
        this.calc6 = new Calculation(6);
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
            assertFalse(secondNumber == 0);
        }
        
    }
    
  
    
    /**
     *
     */
    @Test 
    public void generateCalculations() {
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
        
        Calculation calc2 = new Calculation(5);
        oper = calc2.getOperator();
        firstNumber = calc2.getFirst();
        secondNumber = calc2.getSecond();
        result = 0;
        
        if (oper == '+') {
            result = firstNumber + secondNumber;
        } else if (oper == '-') {
            result = firstNumber - secondNumber;
        } else if (oper == '·') {
            result = firstNumber * secondNumber;
        } else if (oper == '/') {
            result = firstNumber / secondNumber;
        }
        
        assertEquals(calc2.getResult(), result);
    }
    
    @Test
    public void testCalc() {
        assertTrue(calc.toString().charAt(2) == '+' || calc.toString().charAt(2) == '-');
    }
    
    @Test
    public void testOperator() {
        assertTrue(this.calc.getOperator() == '+' || this.calc.getOperator() == '-');
        assertTrue(this.calc2.getOperator() == '+' || this.calc2.getOperator() == '-' || this.calc2.getOperator() == '·');
        assertTrue(this.calc3.getOperator() == '+' || this.calc3.getOperator() == '-' || this.calc3.getOperator() == '·' || this.calc3.getOperator() == '/');
        assertTrue(this.calc4.getOperator() == '+' || this.calc4.getOperator() == '-' || this.calc4.getOperator() == '·' || this.calc4.getOperator() == '/');
        assertTrue(this.calc5.getOperator() == '·' || this.calc5.getOperator() == '/');
        assertTrue(this.calc6.getOperator() == '·' || this.calc6.getOperator() == '/');
    }
    
    
    
    @Test
    public void numbersTest() {
        assertTrue(this.calc.getFirst() < 10);
        assertTrue(this.calc.getSecond() < 10);
        
        assertTrue(this.calc2.getFirst() < 40);
        assertTrue(this.calc2.getSecond() < 40);
        
        if (this.calc2.getOperator() == '·') {
            assertTrue(this.calc2.getFirst() < 20);
            assertTrue(this.calc2.getSecond() < 20);
        }
        
        assertTrue(this.calc3.getFirst() < 90);
        assertTrue(this.calc3.getSecond() < 90);
        
        if (this.calc3.getOperator() == '·') {
            assertTrue(this.calc3.getFirst() < 30);
            assertTrue(this.calc3.getSecond() < 30);
        }
        
        assertTrue(this.calc4.getFirst() < 160);
        assertTrue(this.calc4.getSecond() < 160);
        
        if (this.calc4.getOperator() == '·') {
            assertTrue(this.calc4.getFirst() < 40);
            assertTrue(this.calc4.getSecond() < 40);
        }
        
        assertTrue(this.calc5.getFirst() < 250);
        assertTrue(this.calc5.getSecond() < 250);
        
        if (this.calc5.getOperator() == '·') {
            assertTrue(this.calc5.getFirst() < 50);
            assertTrue(this.calc5.getSecond() < 50);
        }
    }
    
}
