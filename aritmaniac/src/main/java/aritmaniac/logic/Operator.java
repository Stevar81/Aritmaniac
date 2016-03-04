package aritmaniac.logic;

/**
 * Creates +, -, * or / based on the current level.
 *
 * @author Tomi
 */
public class Operator {

    private int operatorNumb;
    private char operator;

    /**
     * Constructor.
     * @param level current level
     */
    public Operator(int level) {
        createOperator(level);
    }

    /**
     * Get the operator.
     * @return operator
     */
    public char getOperator() {
        return operator;
    }

    /**
     * Creates operator based on current level.
     * @param level Current level
     */
    private void createOperator(int leve) {
        if (leve == 1) {
            operatorNumb = (int) (Math.random() * 2);
            if (operatorNumb == 0) {
                this.operator = '+';
            } else {
                this.operator = '-';
            }
        } else if (leve == 2) {
            operatorNumb = (int) (Math.random() * 10);
            switch (operatorNumb) {
                case 0:
                case 1:
                case 2:
                    this.operator = '+';
                    break;
                case 3:
                case 4:
                case 5:
                    this.operator = '-';
                    break;
                default:
                    this.operator = '·';
                    break;
            }
        } else if (leve == 3) {
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
        } else if (leve == 4) {
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
        } else {
            operatorNumb = (int) (Math.random() * 2);
            if (operatorNumb == 0) {
                operator = '·';
            } else {
                operator = '/';
            }

        }
    }
}
