package ru.otus.java.basic.junithw;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MainTestMethod {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5};
        System.out.println(Arrays.toString(afterOne(arr)));
    }

    public static int[] afterOne(int[] arr) {
        int[] newArr;
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                index = i + 1;
            }
        }

        newArr = Arrays.copyOfRange(arr, index, arr.length);

        if (index == 0 || newArr.length == 0) {
            throw new RuntimeException("Нет 1.") ;
        } else {
            return newArr;
        }
    }

    public boolean justOneAndTow(int[] arr) {
        int oneCount = 0;
        int towCount = 0;

        for (int i : arr) {
            if(i == 1) {
                oneCount ++;
            } else if (i == 2) {
                towCount ++;
            } else {
                return false;
            }
        }

        return oneCount > 0 && towCount > 0;
    }
}
