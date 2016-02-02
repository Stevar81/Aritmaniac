
package logic;

import logic.Operator;

public class Calculation {
    
    private int firstNumber;
    private int secondNumber;
    private int level;
    private Operator operator;
    private char oper;
    
    public Calculation(int level) {
        this.level = level;
        this.firstNumber = (int)(Math.random()*(Math.pow(this.level, 2) * 10));
        this.secondNumber = (int)(Math.random()*(Math.pow(this.level, 2) * 10));
        this.operator = new Operator(this.level);
        this.oper = operator.getOperator();
        
        if (this.oper == '/') {
            
            secondNumber = (int)(Math.random()*(this.level * 10));
            
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
        }
        
        if (this.oper == '*') {
            this.firstNumber = (int)(Math.random()*(this.level * 10));
            this.secondNumber = (int)(Math.random()*(this.level * 10));
        }
    }
    
    @Override
    public String toString() {
        return (firstNumber + " " + oper + " " + secondNumber);
    }
    
    public int getFirst() {
        return this.firstNumber;
    }
    
    public int getSecond() {
        return this.secondNumber;
    }
    
    public char getOperator() {
        return this.oper;
    }
    
    public int getResult() {
        
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
        
        return result;
    }
}
