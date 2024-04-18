package ru.otus.java.basic;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SecondHomework {

    public static void main(String[] args) {
        chooseFunction();
    }

    public static int[] randomArray() {
        int maxOfRandom = 30;
        int minOfRandom = 2;
        int randomNum = (int) (Math.random() * (maxOfRandom - minOfRandom)) + minOfRandom;
        int[] arrayRandom = new int[randomNum];

        for (int i = 0; i < arrayRandom.length; i++) {
            arrayRandom[i] = (int) (Math.random() * maxOfRandom);
        }

        return arrayRandom;
    }

    public static boolean validChooseFunction(int number) {
        int maxChooseNumber = 9;
        int minChooseNumber = 0;

        return number >= minChooseNumber && number <= maxChooseNumber;
    }

    public static void chooseFunction() {
        Scanner input = new Scanner(System.in);
        boolean inRange;

        do {
            System.out.println("Введите число от 0 до 9, где:");
            System.out.println("0 - выход из программы;");
            System.out.println("1 - печать строки n-ое количество раз;");
            System.out.println("2 - сумма всех элементов массива > 5;");
            System.out.println("3 - заполнение каждой ячейки массива заданным числом;");
            System.out.println("4 - увеличение элементов массива на заданное число;");
            System.out.println("5 - сравнение суммы чисел левой и правой части массива.");
            System.out.println("Номера задач со звездочкой '*':");
            System.out.println("6 - сложение элементов трёх массивов;");
            System.out.println("7 - показать точку равенства между правой и левой частью массивов;");
            System.out.println("8 - возрастание или убывание элементов массива;");
            System.out.println("9 - переворот элементов массива.");

            int inputData;

            try {
                inputData = input.nextInt();
                inRange = validChooseFunction(inputData);

                if (inputData == 0) {
                    System.out.println("Выход из программы.");
                    break;
                }

                if (!inRange) {
                    System.out.println("Введено число вне диапазона!");
                    inRange = true;
                } else if (inputData <= 5){
                    inputDataForFunction(inputData);
                } else {
                    inputDataForFunctionWithStar(inputData);
                }
            } catch (InputMismatchException e) {
                System.out.println("Введено не целое число!");
                inRange = false;
            }

        } while (inRange);
    }

    public static void inputDataForFunction(int number) {
        Scanner input = new Scanner(System.in);

        if (number == 1) {
            int inputNumber;
            String inputString;

            try {
                System.out.println("Введите целое число: ");
                inputNumber = input.nextInt();
                System.out.println("Введите предлжение для вывода: ");
                inputString = input.next();
                System.out.println();
                printStringCertainAmount(inputNumber, inputString);
            } catch (InputMismatchException e) {
                System.out.println("Введены не корректные значения!");
            }

        } else if (number == 2) {
            sumNumbsOfArrayBiggerFivePrint(randomArray());
        } else if (number == 3) {
            int numForArray;
            int lengthOfArray;

            try {
                System.out.println("Введите целое число для заполнения массива: ");
                numForArray = input.nextInt();
                System.out.println("Введите целое число для указания длинны массива: ");
                lengthOfArray = input.nextInt();
                int[] arrayThirdChoose = new int[lengthOfArray];
                addNumbsToArray(numForArray, arrayThirdChoose);
            } catch (InputMismatchException e) {
                System.out.println("Введены не целые числа!");
            }
        } else if (number == 4) {
            int numForFourthChoose;

            try {
                System.out.println("Введите целое число для прибавления к числам массива: ");
                numForFourthChoose = input.nextInt();
                plusNumToArraysNumbers(numForFourthChoose, randomArray());
            } catch (InputMismatchException e) {
                System.out.println("Введены не целые числа!");
            }
        } else if (number == 5) {
            biggestPartOfArray(randomArray());
        }
    }

    public static void inputDataForFunctionWithStar(int number) {
        if (number == 6) {
            sumElementsOfArrays(randomArray(), randomArray(), randomArray());
        } else if (number == 7) {
//            int[] firstArray = {1, 1, 1, 1, 1, 5};
            int[] secondArray = {5, 3, 4, -2};
            pointEqualsPartsOfArray(secondArray);
        } else if (number == 8) {
//            int[] increasingArr = {1, 2, 3};
            int[] decreasingArr = {8, 6, 3, 2, 1, 0};
            increasingOrDecreasingFunction(decreasingArr);
        } else if (number == 9) {
            invertedArray(randomArray());
        }
    }

    public static void printStringCertainAmount(int amount, String dataString) {
        for (int i = 0; i < amount; i++) {
            System.out.println(dataString);
        }
    }

    public static void sumNumbsOfArrayBiggerFivePrint (int[] array) {
        int sum = 0;

        for (int j : array) {
            if (j > 5) {
                sum += j;
            }
        }

        if (sum == 0) {
            System.out.print("Рандом не выдал числа больше 5." +
                    "Сгенерированный массив : " + Arrays.toString(array) +
                    " Сумма = " + sum);
        } else {
            System.out.println("Сгенерированный массив : " + Arrays.toString(array));
            System.out.println("Сумма = " + sum);
        }
    }

    public static void addNumbsToArray(int addNumber, int[] array) {

        Arrays.fill(array, addNumber);

        System.out.println(Arrays.toString(array));
    }

    public static void plusNumToArraysNumbers(int plusNum, int[] array) {
        System.out.println("Сгенерированный массив : \n" + Arrays.toString(array));

        for (int i = 0; i < array.length; i++) {
            array[i] += plusNum;
        }

        System.out.println("Массив с прибавлением числа " + plusNum + " :");
        System.out.println(Arrays.toString(array));
    }

    public static void biggestPartOfArray(int[] array) {
        int sumNumbsOfArrayLeftPart = 0;
        int sumNumbsOfArrayRightPart = 0;

        System.out.println("Сгенерированный массив : \n" + Arrays.toString(array));

        for (int i = 0; i < array.length / 2; i++) {
            sumNumbsOfArrayLeftPart += array[i];
        }

        for (int j = array.length / 2; j < array.length; j++) {
            sumNumbsOfArrayRightPart += array[j];
        }

        if (sumNumbsOfArrayLeftPart > sumNumbsOfArrayRightPart) {
            System.out.println("Сумма чисел левой части массива " +
                    sumNumbsOfArrayLeftPart + " больше суммы правой " +
                    sumNumbsOfArrayRightPart);
        } else if (sumNumbsOfArrayLeftPart == sumNumbsOfArrayRightPart) {
            System.out.println("Сумма чисел левой части массива " +
                    sumNumbsOfArrayLeftPart + " равна сумме правой " +
                    sumNumbsOfArrayRightPart);
        } else {
            System.out.println("Сумма чисел правой части массива " +
                    sumNumbsOfArrayRightPart + " больше суммы левой " +
                    sumNumbsOfArrayLeftPart);
        }
    }

    public static void sumElementsOfArrays(int[] firstArray, int[] secondArray, int[] thirdArray) {
        int maxArrayLength = Math.max(firstArray.length,
                Math.max(secondArray.length, thirdArray.length));

        System.out.println("Сумма элементов массива: ");
        System.out.println(Arrays.toString(firstArray) + "\n+");
        System.out.println(Arrays.toString(secondArray) + "\n+");
        System.out.println(Arrays.toString(thirdArray) + "\n=");

        if (firstArray.length < maxArrayLength) {
            firstArray = Arrays.copyOf(firstArray, maxArrayLength);
        }

        if (secondArray.length < maxArrayLength) {
            secondArray = Arrays.copyOf(secondArray, maxArrayLength);
        }

        if (thirdArray.length < maxArrayLength) {
            thirdArray = Arrays.copyOf(firstArray, maxArrayLength);
        }

        for (int i = 0; i < maxArrayLength; i++) {
            firstArray[i] = firstArray[i] + secondArray[i] + thirdArray[i];
        }

        System.out.println("Сумма элементов массива:\n" + Arrays.toString(firstArray));
    }

    public static void pointEqualsPartsOfArray (int[] array) {
        int sumLeft = 0;
        String[] arrayWithPoint = new String[array.length];

        for (int i = 0; i < array.length - 1; i++) {
            int sumRight = 0;
            sumLeft += array[i];
            arrayWithPoint[i] = Integer.toString(array[i]);
            for (int j = i + 1; j < array.length; j++) {
                sumRight += array[j];
                arrayWithPoint[j] = Integer.toString(array[j]);
            }

            if (sumLeft == sumRight) {
                arrayWithPoint[i + 1] = "|" + array[i + 1];
                break;
            }
        }

        System.out.println(Arrays.toString(arrayWithPoint));
    }

    public static void increasingOrDecreasingFunction(int[] array) {
        Scanner input = new Scanner(System.in);
        int choose;
        int increasing;
        int decreasing;
        int count = 0;

        try {
            System.out.println("Введите 0 или 1, где: ");
            System.out.println("0 - проверка массива на возрастание;");
            System.out.println("1 - проверка массива на убывание;");
            choose = input.nextInt();

            if (choose == 0) {
                for (int i = 0; i < array.length - 1; i++) {
                    increasing = array[i];
                    if (increasing < array[i + 1]) {
                        count ++;
                        System.out.println(count);
                    } else {
                        System.out.println(Arrays.toString(array));
                        System.out.println("Элементы массива НЕ идут в порядке возрастания.");
                        break;
                    }
                    if (count + 1 == array.length) {
                        System.out.println(Arrays.toString(array));
                        System.out.println("Элементы массива идут в порядке возрастания.");
                    }
                }
            } else if (choose == 1) {
                for (int i = 0; i < array.length - 1; i++) {
                    decreasing = array[i];
                    if (decreasing > array[i + 1]) {
                        count ++;
                    } else {
                        System.out.println(Arrays.toString(array));
                        System.out.println("Элементы массива НЕ идут в порядке убывания.");
                        break;
                    }
                    if (count + 1 == array.length) {
                        System.out.println(Arrays.toString(array));
                        System.out.println("Элементы массива идут в порядке убывания.");
                    }
                }
            } else {
                System.out.println("Число вне диапазона. Выберете либо 0, либо 1.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Введено не целое число");
        }
    }

    public static void invertedArray(int[] array) {
        int rememberElement;

        System.out.println(Arrays.toString(array));

        for (int i = 0; i < array.length / 2; i++) {
            rememberElement = array[i];
            array[i] = array[(array.length - 1) - i];
            array[(array.length - 1) - i] = rememberElement;
        }

        System.out.println(Arrays.toString(array));
    }
}
