package com.student.lecture;

public class Main {

    public static void main(String[] args) {
        CalculatorService calculatorService = new CalculatorService();
        int plus = calculatorService.calculate(1, 1, '+');
        System.out.println(plus);
        int minus = calculatorService.calculate(1, 1, '-');
        System.out.println("minus = " + minus);
    }
}
class CalculatorService {

    public int calculate(int a, int b, char operator) {
        if (operator == '+') {
            return a + b;
        } else if (operator == '-') {
            return a - b;
        } else {
            throw new IllegalArgumentException("지원하지 않는 연산자입니다.");
        }
    }
}

