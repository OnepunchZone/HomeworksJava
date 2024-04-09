package ru.otus.java.basic;

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
            String inputData = input.nextLine();

            try {
                int convertToInt = Integer.parseInt(inputData);
                inRange = validNum(convertToInt, minNumber, maxNumber);

                if (convertToInt == 0) {
                    break;
                }

                if (!inRange) {
                    System.out.println("Введено число вне диапазона!");
                    inRange = true;
                } else {
                    inputDataForFunction(convertToInt);
                }
            } catch (NumberFormatException NotInteger) {
                System.out.println("Введено не целое число!");
                inRange = false;
            }

        } while(inRange);

    }

    public static boolean validNum(int inputNumber, int minNumber, int maxNumber) {

        return (inputNumber >= minNumber) && (inputNumber <= maxNumber);
    }

    public static void inputDataForFunction(int number) {
        Scanner input = new Scanner(System.in);

        if (number == 1) {
            greetings();
        } else if (number == 2) {
            System.out.println("Введите первое целое число 'а':");
            String a = input.nextLine();
            System.out.println("Введите второе целое число 'b':");
            String b = input.nextLine();
            System.out.println("Введите третье целое число 'c':");
            String c = input.nextLine();

            try {
                int convertAToInt = Integer.parseInt(a);
                int convertBToInt = Integer.parseInt(b);
                int convertCToInt = Integer.parseInt(c);
                System.out.println(checkSign(convertAToInt, convertBToInt, convertCToInt));
            } catch (NumberFormatException NotInteger) {
                System.out.println("Введено не целое число!");
            }
        } else if (number == 3) {
            selectColor();
        } else if (number == 4) {
            compareNumbers();
        } else if (number == 5) {
            System.out.println("Введите первое целое число 'a':");
            String a = input.nextLine();
            System.out.println("Введите второе целое число 'b':");
            String b = input.nextLine();
            System.out.println("Введите 0 - для поиска разницы чисел" +
                    " или 1 - для поиска суммы чисел:");
            String c = input.nextLine();
            boolean increment;

            try {
                int convertAToInt = Integer.parseInt(a);
                int convertBToInt = Integer.parseInt(b);
                int convertCToInt = Integer.parseInt(c);
                increment = validNum(convertCToInt, 0, 1);
                if (increment) {
                    increment = convertCToInt != 0;
                    System.out.println(addOrSubtractAndPrint(convertAToInt, convertBToInt, increment));
                } else {
                    System.out.println("Третье число должно быть 0 либо 1");
                }
            } catch (NumberFormatException NotInteger) {
                System.out.println("Введено не целое число!");
            }
        }
    }

    public static void greetings() {

        System.out.println("Hello\nWorld\nfrom\nJava");

    }

    public static String  checkSign(int a, int b, int c) {
        int sumOfNumbs = a + b + c;

        if (sumOfNumbs < 0) {
            return sumOfNumbs + " Сумма отрицательная";
        }

        return sumOfNumbs + " Сумма положительная";
    }

    public static void selectColor() {
        int data = (int) (Math.random() * 50);

        if (data <= 10) {
            System.out.println("Красный");
        } else if (data > 10 && data <= 20) {
            System.out.println("Жёлтый");
        } else {
            System.out.println("Зелёный");
        }
    }

    public static void compareNumbers() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите первое целое число 'а':");
        String a = input.nextLine();
        System.out.println("Введите второе целое число 'b':");
        String b = input.nextLine();

        try {
            int convertAToInt = Integer.parseInt(a);
            int convertBToInt = Integer.parseInt(b);
            if (convertAToInt >= convertBToInt) {
                System.out.println("a >= b");
            } else {
                System.out.println("a < b");
            }
        } catch (NumberFormatException NotInteger) {
            System.out.println("Введено не целое число!");
        }

    }

    public static String addOrSubtractAndPrint(int initValue, int delta, boolean increment) {

        if (increment) {
            int sumValueAndDelta = initValue + delta;

            return increment + " " + initValue + " + " + delta + " = " + sumValueAndDelta;
        }

        int differenceValueAndDelta = initValue - delta;

        return increment + " " + initValue + " - " + delta + " = " + differenceValueAndDelta;
    }

}
