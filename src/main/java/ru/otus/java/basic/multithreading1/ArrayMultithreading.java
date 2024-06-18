package ru.otus.java.basic.multithreading1;

public class ArrayMultithreading {
    private final int firstPart = 25_000_000;
    private final int secondPart = 50_000_000;
    private final int thirdPart = 75_000_000;
    private final int fourthPart = 100_000_000;

    public long createArray() {
        double[] array = new double[fourthPart];

        long start = System.currentTimeMillis();
        Thread first = new Thread(() -> {
            forCycle(array, 0, firstPart);
        });
        first.start();

        Thread second = new Thread(() -> {
            forCycle(array, firstPart, secondPart);
        });
        second.start();

        Thread third = new Thread(() -> {
            forCycle(array, secondPart, thirdPart);
        });
        third.start();

        Thread fourth = new Thread(() -> {
            forCycle(array, thirdPart, fourthPart);
        });
        fourth.start();
        long finish = System.currentTimeMillis();

        return finish - start;
    }

    private void forCycle(double[] array, int a, int b) {
        for (int i = a; i < b; i++) {
            array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
    }
}
