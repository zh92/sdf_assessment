package sdf;

import java.io.Console;

public class Calculator {
    
    public static void main(String[] args) {
        
        System.out.println("Welcome.");
        Console cons = System.console();
        String input = cons.readLine(">");

        if (input.equalsIgnoreCase("exit")) {
            System.out.println("Bye bye");
        } else {
            input.trim();
            String[] columns = input.split(" ");

            Double number1 = Double.parseDouble(columns[0]);
            Double number2 = Double.parseDouble(columns[2]);
            String operator = columns[1];
            Double answer = 0.00;

            Operator op = new Operator();
            answer = op.evaluate(number1, operator, number2);
            System.out.println(answer);
        }
    }
}
