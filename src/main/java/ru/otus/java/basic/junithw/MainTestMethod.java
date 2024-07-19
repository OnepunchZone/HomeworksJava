package ru.otus.java.basic.junithw;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MainTestMethod {

    public int[] afterOne(int[] arr) {
        String str = "";

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                if ((i+1) < arr.length && arr[i+1] != 1) {
                    str += arr[i + 1];
                }
            }
        }

        int[] newArr = new int[str.toCharArray().length];
        if (newArr.length == 0) {
            throw new RuntimeException("Нет 1. Массив пустой.") ;
        }
        int count = 0;

        for (Character chr : str.toCharArray()) {
            newArr[count] = Integer.parseInt(String.valueOf(chr));
            count ++;
        }

        return newArr;
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
