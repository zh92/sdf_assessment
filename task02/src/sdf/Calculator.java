package sdf;

import java.io.Console;

public class Calculator {
    
    public static void main(String[] args) {
        
        System.out.println("Welcome.");
        Console cons = System.console();
        String input = "";
        Double $last = 0.00;

        while (!input.equalsIgnoreCase("exit")) {
            input = cons.readLine(">");

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Bye bye");
            } else {
                input.trim();
                String[] columns = input.split(" ");
                Operator op = new Operator();
                String operator = columns[1];
                Double answer = 0.00;

                if (columns[0].equalsIgnoreCase("$last")) {
                    Double number1 = $last;
                    Double number2 = Double.parseDouble(columns[2]);
                    answer = op.evaluate(number1, operator, number2);

                } else if (columns[2].equalsIgnoreCase("$last")) {
                    Double number2 = $last;
                    Double number1 = Double.parseDouble(columns[0]);
                    answer = op.evaluate(number1, operator, number2);
    
                } else if (columns[0].equalsIgnoreCase("$last") && columns[2].equalsIgnoreCase("$last")) {
                    Double number2 = $last;
                    Double number1 = $last;
                    answer = op.evaluate(number1, operator, number2);
    
                }else {
                    Double number1 = Double.parseDouble(columns[0]);
                    Double number2 = Double.parseDouble(columns[2]);
                    answer = op.evaluate(number1, operator, number2);
                }
                System.out.println(answer);
                $last = answer;
            }
        
        }
    }
}
