package ru.otus.java.basic.hwcollections1;


import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class HomeworkFirstPart {
    public static void main(String[] args) {
        System.out.println(sumNumbsBiggerFive(createArrList(3, 11)));
        System.out.println(overwriteList(3, createArrList(4, 16)));
        System.out.println(plusNumber(10, createArrList(1, 10)));
    }


    public static List<Integer> createArrList(int min, int max) {
        List<Integer> arrList = new ArrayList<>();

        for (int i = min; i <= max; i++) {
            arrList.add(i);
        }
        System.out.println("Созданый список методом createArrList():\n" + arrList);
        return arrList;
    }

    public static int sumNumbsBiggerFive(List<Integer> arrList) {
        int sum = 0;

        for (Integer element : arrList) {
            if (element > 5) {
                sum += element;
            }
        }
        System.out.println("Результат метода sumNumbsBiggerFive():");
        return sum;
    }

    public static List<Integer> overwriteList(int num, List<Integer> arrList) {

        ListIterator<Integer> li = arrList.listIterator();

        while (li.hasNext()) {
            li.next();
            li.set(num);
        }
//        либо воспользоваться методом из коробки arrList.replaceAll(ignored -> num)
        System.out.println("Результат метода overwriteList():");
        return arrList;
    }

    public static List<Integer> plusNumber(int num, List<Integer> arrList) {
        ListIterator<Integer> li = arrList.listIterator();
        int elem;

        while (li.hasNext()) {
            elem = li.next() + num;
            li.set(elem);
        }
        System.out.println("Результат метода plusNumber():");
        return arrList;
    }
}
