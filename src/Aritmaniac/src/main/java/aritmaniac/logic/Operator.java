
package aritmaniac.logic;

public class Operator {
    
    private int level;
    private int operatorNumb;
    private char operator;
    
    public Operator(int level) {
        this.level = level;
    }
    
    public char getOperator() {
        if (level == 1) {
            operatorNumb = (int)(Math.random() * 2);
            if (operatorNumb == 0) {
                operator = '+';
            } else {
                operator = '-';
            }
        }
        if (level == 2) {
            operatorNumb = (int)(Math.random() * 10);
            if (operatorNumb == 0 || operatorNumb == 1 || operatorNumb == 2) {
                operator = '+';
            } else if (operatorNumb == 3 || operatorNumb == 4 || operatorNumb == 5) {
                operator = '-';
            } else {
                operator = '*';
            }
        }
        if (level == 3) {
            operatorNumb = (int)(Math.random() * 10);
            if (operatorNumb == 0 || operatorNumb == 1) {
                operator = '+';
            } else if (operatorNumb == 2 || operatorNumb == 3) {
                operator = '-';
            } else if (operatorNumb == 4 || operatorNumb == 5 || operatorNumb == 6) {
                operator = '*';
            } else {
                operator = '/';
            }
        }
        if (level == 4) {
            operatorNumb = (int)(Math.random() * 10);
            if (operatorNumb == 0) {
                operator = '+';
            } else if (operatorNumb == 1) {
                operator = '-';
            } else if (operatorNumb == 2 || operatorNumb == 3 || operatorNumb == 4 || operatorNumb == 5) {
                operator = '*';
            } else {
                operator = '/';
            }
        }
        if (level == 5) {
            operatorNumb = (int)(Math.random() * 2);
            System.out.println(operatorNumb);
            if (operatorNumb == 0) {
                operator = '*';
            } else {
                operator = '/';
            }
            
        }
        
        
        return operator;
    }
}
