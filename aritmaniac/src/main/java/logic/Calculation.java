
package logic;

import logic.Operator;

/**
 *
 * @author Tomi
 */
public class Calculation {
    
    private int firstNumber;
    private int secondNumber;
    private int level;
    private Operator operator;
    private char oper;
    
    /**
     *
     * @param level
     */
    public Calculation(int level) {
        this.level = level;
        this.firstNumber = (int)(Math.random()*(Math.pow(this.level, 2) * 10));
        this.secondNumber = (int)(Math.random()*(Math.pow(this.level, 2) * 10));
        this.operator = new Operator(this.level);
        this.oper = operator.getOperator();
        
        if (this.oper == '/') {
            
            secondNumber = (int)(Math.random()*(this.level * 10));
            
            //Making sure that denominator is not zero.
            if (secondNumber == 0) {
                while (!(secondNumber != 0)) {
                    secondNumber = (int) (Math.random() * 10);
                }
            }
            
            //Making sure that answer is integer.
            if (firstNumber % secondNumber != 0) {
                while (!(firstNumber % secondNumber == 0)) {
                    firstNumber++;
                }
            }
        }
        
        if (this.oper == '·') {
            this.firstNumber = (int)(Math.random()*(this.level * 10));
            this.secondNumber = (int)(Math.random()*(this.level * 10));
        }
        
        if (this.oper == '-') {
            int temp = 0;
            
            //Making sure that answer is a positive integer.
            if (this.firstNumber < this.secondNumber) {
                temp = this.firstNumber;
                this.firstNumber = this.secondNumber;
                this.secondNumber = temp;
            }
        }
    }
    
    @Override
    public String toString() {
        return (firstNumber + " " + oper + " " + secondNumber);
    }
    
    /**
     *
     * @return
     */
    public int getFirst() {
        return this.firstNumber;
    }
    
    /**
     *
     * @return
     */
    public int getSecond() {
        return this.secondNumber;
    }
    
    /**
     *
     * @return
     */
    public char getOperator() {
        return this.oper;
    }
    
    /**
     *
     * @return
     */
    public int getResult() {
        
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
        
        return result;
    }
}
