
package javalabra.aritmaniac;

public class Calculation {
    
    private int firstNumber;
    private int secondNumber;
    private int level;
    private Operator operator;
    
    public Calculation(int level) {
        this.level = level;
        this.firstNumber = (int)(Math.random()*(Math.pow(this.level, 2) * 10));
        this.secondNumber = (int)(Math.random()*(Math.pow(this.level, 2) * 10));
        this.operator = new Operator(this.level);
    }
    
    public int getFirst(){
        return this.firstNumber;
    }
    
    public int getSecond() {
        return this.secondNumber;
    }
    
    public char getOperator() {
        return this.operator.getOperator();
    }
}
