package javalabra.aritmaniac;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class main {
    
    static int points = 0;
    static boolean time = true;

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        
        int level = 1;
        int result = 0;
        int counter = 0;
        
        Timer timer = new Timer();
        
        timer.schedule( new TimerTask(){
            public void run() {
                time = false;
                end();
            }
        }, 120000 );
        
        
        while (time) {
            
            Calculation calculation = new Calculation(level);
            
            int first = calculation.getFirst();
            int second = calculation.getSecond();
            char operator = calculation.getOperator();

            if (operator == '/') {
                first = (first * second) / 2;
                second = second / 2;
            }

            System.out.println(first + " " + operator + " " + second);
            
            int answer = reader.nextInt();   

            if (operator == '+') {
                result = first + second;
            } else if (operator == '-') {
                result = first - second;
            } else if (operator == '*') {
                result = first * second;
            } else if (operator == '/') {
                result = first / second;
            }

            if (result == answer) {
                points = points + level;
                System.out.println("Yeah!");
                counter++;
                if (counter % 10 == 0 && level < 5) {
                    level++;
                    System.out.println("Level " + level);
                }
            } else {
                System.out.println("Wrong! :(");
                end();
            }

        }
        
        
    }
    
    public static void end() {
        System.out.println("Game over!\nYou got " + points + " points!");
        System.exit(0);
    }
 
}
