
package javalabra.aritmaniac;

public class Calculation {
    
    private int firstNumber;
    private int secondNumber;
    private String operator;
    private int level;
    
    public Calculation(int level) {
        this.level = level;
        this.firstNumber = (int)(Math.random()*(this.level * 10));
        this.secondNumber = (int)(Math.random()*(this.level * 10));
        this.operator = "+";
    }
    
    
    
    public String toString() {
        return this.firstNumber + " " + this.operator + " " + this.secondNumber;
    }
}
