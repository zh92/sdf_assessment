package sdf;

public class Operator {

    private Double number1;
    private Double number2;
    private String operand;

    public Double getNumber1() {return number1;}
    public void setNumber1(Double number1) {this.number1 = number1;}
    public Double getNumber2() {return number2;}
    public void setNumber2(Double number2) {this.number2 = number2;}
    public String getOperand() {return operand;}
    public void setOperand(String operand) {this.operand = operand;}

    
    public Operator() {
    }
    
    public Double evaluate(Double number1, String operand, Double number2) {
        Double answer = 0.00;
        switch (operand) {
            case "+":
                answer = number1 + number2;
                break;
            case "-":
                answer = number1 - number2;
                break;
            case "*":
                answer = number1 * number2;
                break;
            case "/":
                answer = number1 / number2;
                break;
        }
        return answer;
    }
}