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
            for (int i = 0; i < firstPart; i++) {
                array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
            }
        });
        first.start();

        Thread second = new Thread(() -> {
            for (int i = firstPart; i < secondPart; i++) {
                array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
            }
        });
        second.start();

        Thread third = new Thread(() -> {
            for (int i = secondPart; i < thirdPart; i++) {
                array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
            }
        });
        third.start();

        Thread fourth = new Thread(() -> {
            for (int i = thirdPart; i < fourthPart; i++) {
                array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
            }
        });
        fourth.start();
        long finish = System.currentTimeMillis();

        return finish - start;
    }
}
