package javalabra.aritmaniac;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        int points = 0;
        int level = 1;
        int result = 0;
        int counter = 0;

        while (true) {
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
                if (counter % 10 == 0) {
                    level++;
                    System.out.println("Level " + level);
                }
            } else {
                System.out.println("Wrong! :(");
                System.out.println("Points: " + points);
                break;
            }

        }
    }

}
