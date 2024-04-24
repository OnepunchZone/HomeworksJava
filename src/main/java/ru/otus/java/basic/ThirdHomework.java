package ru.otus.java.basic;

import java.util.Scanner;

public class ThirdHomework {
    private static final Scanner input = new Scanner(System.in);
    private static final int MAX_LENGTH_OF_ARRAY = 10;
    private static final int MIN_LENGTH_OF_ARRAY = 2;
    private static final int MAX_NUMBER = 9;
    private static final int MIN_NUMBER = -9;
    public static void main(String[] args) {
        inputAndPrintFunctions();
    }

    private static void inputAndPrintFunctions() {
        System.out.println("1. Первое задание с рандомным массивом: ");
        System.out.println(sumOfPositiveElements(randomDoubleArray()));

        System.out.println("2. Второе задание с пользовательским размером" +
                " для массива. ");
        System.out.println("Введите размер двумерного массива: ");
        squareOfSymbols(input.nextInt());

        System.out.println("3. Третье задание с заданым пользовательским размером массива" +
                " для рандомного массива.");
        System.out.println("Введите размер двумерного массива: ");
        int arrayLength = input.nextInt();
        diagonalsOfZeros(randomSquareDoubleArray(arrayLength));

        System.out.println("4. Четвертое задание - максимальное число в рандомном массиве:");
        System.out.println(findMax(randomDoubleArray()));

        System.out.println("5. Пятое задание - сумма элементов 2-ой строки или столбца " +
                "в рандомном массиве.");
        System.out.println("Сумма элементов 2-ой строки: ");
//        int[][] arr = {{1, 2}, {3, 3}, {6, 5, 7}};
        System.out.println(sumSecondRowOfArray(randomDoubleArray()));
        System.out.println("Сумма элементов 2-ого столбца: ");
        System.out.println(sumSecondColumnOfArray(randomDoubleArray()));
    }

    public static int[][] randomDoubleArray() {
        int firstRandomLength = (int) (Math.random() *
                (MAX_LENGTH_OF_ARRAY - MIN_LENGTH_OF_ARRAY) + MIN_LENGTH_OF_ARRAY);
        int secondRandomLength = (int) (Math.random() *
                (MAX_LENGTH_OF_ARRAY - MIN_LENGTH_OF_ARRAY) + MIN_LENGTH_OF_ARRAY);
        int[][] randomArray = new int[firstRandomLength][secondRandomLength];


        for (int i = 0; i < firstRandomLength; i++) {
            for (int j = 0; j < secondRandomLength; j++) {
                randomArray[i][j] = (int) (Math.random() *
                        (MAX_NUMBER - MIN_NUMBER) + MIN_NUMBER);
            }
        }

        return randomArray;
    }

    public static int[][] randomSquareDoubleArray(int randomLength) {
        int[][] randomArray = new int[randomLength][randomLength];

        for (int i = 0; i < randomLength; i++) {
            for (int j = 0; j < randomLength; j++) {
                randomArray[i][j] = (int) (Math.random() * MAX_NUMBER);
            }
        }

        return randomArray;
    }

    public static int sumOfPositiveElements(int[][] doubleArray) {
        int sumOfPositiveNumber = 0;

        for (int[] firstArr : doubleArray) {
            for (int variable : firstArr) {
                if (variable > 0) {
                    sumOfPositiveNumber += variable;
                }
            }
        }

        return sumOfPositiveNumber;
    }

    public static void squareOfSymbols(int size) {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void diagonalsOfZeros(int[][] doubleArray) {

        for (int i = 0; i < doubleArray.length; i++) {
            doubleArray[i][i] = 0;
            doubleArray[i][(doubleArray.length - 1) - i] = 0;
            for (int j = 0; j < doubleArray.length; j++) {
                System.out.print(doubleArray[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static int findMax(int[][] doubleArray) {
        int maxElement = Integer.MIN_VALUE;

        for (int[] array : doubleArray) {
            for (int elements : array) {
                if (maxElement < elements) {
                    maxElement = elements;
                }
            }
        }
        return maxElement;
    }

    public static int sumSecondRowOfArray(int[][] doubleArray) {
        int sumOfSecondRow = 0;

        if (doubleArray.length < 3) {
            return -1;
        }

        for (int i = 0; i < doubleArray[2].length; i++) {
            sumOfSecondRow += doubleArray[2][i];
        }

        return sumOfSecondRow;
    }

    public static int sumSecondColumnOfArray(int[][] doubleArray) {
        int sumOfSecondColumn = 0;
        int count = 0;

        for (int[] array : doubleArray) {

            if (count == array.length) {
                return -1;
            }

            if (array.length < 3) {
                count++;
                continue;
            }
            sumOfSecondColumn += array[2];
        }

        return sumOfSecondColumn;
    }
}
