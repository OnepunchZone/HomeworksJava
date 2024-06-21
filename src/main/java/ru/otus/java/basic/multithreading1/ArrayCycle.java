package ru.otus.java.basic.multithreading1;

public class ArrayCycle {

    public long createArray() {
        double[] array = new double[100_000_000];

        long start = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
        long finish = System.currentTimeMillis();

        return finish - start;
    }
}
