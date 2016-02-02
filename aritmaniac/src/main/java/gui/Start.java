package gui;

import logic.Calculation;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import logic.Calculation;

public class Start {
    
    static int points = 0;
    static boolean time = true;

    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Aritmaniac");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        JPanel panel1 = new JPanel();        
        frame.add(panel1);  
        JLabel label1 = new JLabel("");
        panel1.add(label1);

        Scanner reader = new Scanner(System.in);
        
        int level = 1;
        int counter = 0;
        
        
        Timer timer = new Timer();
        
        timer.schedule (new TimerTask(){

            @Override
            public void run() {
                time = false;
                end();
            }
        }, 120000 );
        
        while (time) {
            
            Calculation calculation = new Calculation(level);
            
            label1.setText(calculation.toString());
            
            int answer = reader.nextInt();   

            if (calculation.getResult() == answer) {
                points = points + level;
                System.out.println("Yeah!");
                counter++;
                if (counter % 3 == 0 && level < 5) {
                    level++;
                    System.out.println("Level " + level);
                }
            } else {
                System.out.println("Wrong! :(");
                
                if (!(counter % 3 == 0)) {
                   counter--; 
                }
                
                points -= 2;
                if (points < 0) {
                    points = 0;
                }
            }

        }
        
        
    }
    
    public static void end() {
        System.out.println("Game over!\nYou got " + points + " points!");
        System.exit(0);
    }
 
}

