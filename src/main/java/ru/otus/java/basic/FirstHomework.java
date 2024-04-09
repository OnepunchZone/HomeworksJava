package ru.otus.java.basic;

import java.util.InputMismatchException;
import java.util.Scanner;


// Прошу прощения за усложнение=) Пока позволяет время хочу отработать некоторые моменты
// Буду рад, если укажете на ошибки! Спасибо=)
public class FirstHomework {

    public static void main(String[] args) {
        chooseFunction();
    }

    public static void chooseFunction() {
        Scanner input = new Scanner(System.in);
        int minNumber = 0;
        int maxNumber = 5;
        boolean inRange;

        do {
            System.out.println("Введите число от " + minNumber + " до " +  maxNumber + ", где:");
            System.out.println("1 - приветствие;");
            System.out.println("2 - сумма трех чисел;");
            System.out.println("3 - случайный выбор цвета из трёх;");
            System.out.println("4 - сравнение чисел;");
            System.out.println("5 - сумма либо разность двух чисел.");
            System.out.println("0 - выход из программы;");
            int inputData;

            try {
                inputData = input.nextInt();
                inRange = validNum(inputData, minNumber, maxNumber);

                if (inputData == 0) {
                    break;
                }

                if (!inRange) {
                    System.out.println("Введено число вне диапазона!");
                    inRange = true;
                } else {
                    inputDataForFunction(inputData);
                }
            } catch (NumberFormatException e) {
                System.out.println("Введено не целое число!");
                inRange = false;
            }

        } while(inRange);

    }

    public static boolean validNum(int inputNumber, int minNumber, int maxNumber) {

        return inputNumber >= minNumber && inputNumber <= maxNumber;
    }

    public static void inputDataForFunction(int number) {
        Scanner input = new Scanner(System.in);

        if (number == 1) {
            greetings();
        } else if (number == 2) {
            int a, b, c;

            try {
                System.out.println("Введите первое целое число 'а':");
                a = input.nextInt();
                System.out.println("Введите второе целое число 'b':");
                b = input.nextInt();
                System.out.println("Введите третье целое число 'c':");
                c = input.nextInt();
                checkSign(a, b, c);
            } catch (InputMismatchException e) {
                System.out.println("Введено не целое число!");
            }
        } else if (number == 3) {
            selectColor();
        } else if (number == 4) {
            compareNumbers();
        } else if (number == 5) {

            int a, b, c;
            boolean increment;

            try {
                System.out.println("Введите первое целое число 'a':");
                a = input.nextInt();
                System.out.println("Введите второе целое число 'b':");
                b = input.nextInt();
                System.out.println("Введите 0 - для поиска разности чисел" +
                        " или 1 - для поиска суммы чисел:");
                c = input.nextInt();
                increment = validNum(c, 0, 1);

                if (increment) {
                    increment = c != 0;
                    addOrSubtractAndPrint(a, b, increment);
                } else {
                    System.out.println("Третье число должно быть 0 либо 1");
                }
            } catch (InputMismatchException e) {
                System.out.println("Введено не целое число!");
            }
        }
    }

    public static void greetings() {

        System.out.println("Hello\nWorld\nfrom\nJava");

    }

    public static void checkSign(int a, int b, int c) {
        int sumOfNumbs = a + b + c;

        if (sumOfNumbs < 0) {
            System.out.println(sumOfNumbs + " Сумма отрицательная");
        } else {
            System.out.println(sumOfNumbs + " Сумма положительная");
        }
    }

    public static void selectColor() {
        int data = (int) (Math.random() * 50);

        if (data <= 10) {
            System.out.println("Красный");
        } else if (data <= 20) {
            System.out.println("Жёлтый");
        } else {
            System.out.println("Зелёный");
        }
    }

    public static void compareNumbers() {
        Scanner input = new Scanner(System.in);
        int a, b;

        try {
            System.out.println("Введите первое целое число 'а':");
            a = input.nextInt();
            System.out.println("Введите второе целое число 'b':");
            b = input.nextInt();

            if (a >= b) {
                System.out.println("a >= b");
            } else {
                System.out.println("a < b");
            }
        } catch (InputMismatchException e) {
            System.out.println("Введено не целое число!");
        }

    }

    public static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {

        if (increment) {
            int sumValueAndDelta = initValue + delta;

            System.out.println(increment + " " + initValue + " + " + delta + " = " + sumValueAndDelta);
        } else {
            int differenceValueAndDelta = initValue - delta;

            System.out.println(increment + " " + initValue + " - " + delta + " = " + differenceValueAndDelta);
        }
    }

}
