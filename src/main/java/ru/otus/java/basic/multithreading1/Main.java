package ru.otus.java.basic.multithreading1;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ArrayCycle arrayCycle = new ArrayCycle();
        long resultArr1 = arrayCycle.createArray();
        System.out.println("С использование одного потока (мс): " + resultArr1);

        ArrayMultithreading arrayMultithreading = new ArrayMultithreading();
        long resultArrThread = arrayMultithreading.createArray();
        System.out.println("С использование многопоточности (мс): " + resultArrThread);
    }
}
