package ru.otus.java.basic.hwexceptions;

import ru.otus.java.basic.hwexceptions.exceptions.AppArrayDataException;
import ru.otus.java.basic.hwexceptions.exceptions.AppArraySizeException;

public class Main {
    public static void main(String[] args) throws AppArraySizeException{
        String[][] array = {{"1","3","4","5ро" }, {"1","3","4","5"}, {"1","3","4","5"}, {"1","3","4","5"}};

        int maxArrLength = 4;

        try {

            if (array.length == maxArrLength) {

                for (int i = 0; i < array.length; i++) {
                    if (array[i].length != maxArrLength) {
                        throw new AppArraySizeException("Длина массива array[" + i +
                                "] превышает допустимое значение(4).");
                    }
                }

                System.out.println(getDoubleArr(array));

            } else {
                    throw new AppArraySizeException("Длина массива превышает " + maxArrLength);
            }

        } catch (AppArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int getDoubleArr(String[][] doubleArray) throws AppArrayDataException{
        int sum = 0;
        int convertString;

        for (int i = 0; i < doubleArray.length; i++) {
            for (int j = 0; j < doubleArray.length; j++) {

                try {
                    convertString = Integer.parseInt(doubleArray[i][j]);
                    sum += convertString;
                } catch (NumberFormatException e) {
                    throw new AppArrayDataException(i, j);
                }
            }
        }

        return sum;
    }
}
