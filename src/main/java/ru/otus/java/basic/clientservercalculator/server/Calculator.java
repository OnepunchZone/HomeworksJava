package ru.otus.java.basic.clientservercalculator.server;

public class Calculator {
    private double num1;
    private double num2;
    private char symbol;

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public double calculate() {
        char multiply = '*';
        char divided = '/';
        char minus = '-';
        char plus = '+';
        if (symbol == plus) {
            return setPlus(this.num1, this.num2);
        } else if (symbol == minus) {
            return setMinus(this.num1, this.num2);
        } else if (symbol == divided) {
            return setDivided(this.num1, this.num2);
        } else if (symbol == multiply) {
            return setMultiply(this.num1, this.num2);
        }
        System.out.println("Такая операция недоступна.");
        return -1;
    }

    private double setPlus(double num1, double num2) {
        return num1 + num2;
    }

    private double setMinus(double num1, double num2) {
        return num1 - num2;
    }

    private double setDivided(double num1, double num2) {
       return num1 / num2;
    }

    private double setMultiply(double num1, double num2) {
        return num1 * num2;
    }
}
