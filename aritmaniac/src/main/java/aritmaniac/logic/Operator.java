
package aritmaniac.logic;

/**
 *
 * @author Tomi
 */
public class Operator {
    
    private int operatorNumb;
    private char operator;
    
    /**
     *
     * @param level
     */
    public Operator(int level) {
  
        if (level == 1) {
            operatorNumb = (int) (Math.random() * 2);
            if (operatorNumb == 0) {
                operator = '+';
            } else {
                operator = '-';
            }
        }
        if (level == 2) {
            operatorNumb = (int) (Math.random() * 10);
            switch (operatorNumb) {
                case 0:
                case 1:
                case 2:
                    operator = '+';
                    break;
                case 3:
                case 4:
                case 5:
                    operator = '-';
                    break;
                default:
                    operator = '·';
                    break;
            }
        }
        if (level == 3) {
            operatorNumb = (int) (Math.random() * 10);
            switch (operatorNumb) {
                case 0:
                case 1:
                    operator = '+';
                    break;
                case 2:
                case 3:
                    operator = '-';
                    break;
                case 4:
                case 5:
                case 6:
                    operator = '·';
                    break;
                default:
                    operator = '/';
                    break;
            }
        }
        if (level == 4) {
            operatorNumb = (int) (Math.random() * 10);
            switch (operatorNumb) {
                case 0:
                    operator = '+';
                    break;
                case 1:
                    operator = '-';
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                    operator = '·';
                    break;
                default:
                    operator = '/';
                    break;
            }
        }
        else {
            operatorNumb = (int) (Math.random() * 2);
            if (operatorNumb == 0) {
                operator = '·';
            } else {
                operator = '/';
            }
            
        }
    }
    
    /**
     *
     * @return
     */
    public char getOperator() {
        return operator;
    }
}
