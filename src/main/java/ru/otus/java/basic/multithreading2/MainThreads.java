package ru.otus.java.basic.multithreading2;

public class MainThreads {
    private final Object monitor1 = new Object();
    private final Object monitor2 = new Object();
    private final Object monitor3 = new Object();

    public static void main(String[] args) {

        MainThreads mainA = new MainThreads();
        MainThreads mainB = new MainThreads();
        MainThreads mainC = new MainThreads();

        new Thread(() -> {
            try {
                mainA.threadMethod1("A");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                mainB.threadMethod2("B");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                mainC.threadMethod3("C");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }


    private void threadMethod1(String letter) throws InterruptedException {
        synchronized (monitor1) {
            for (int i = 0; i < 5; i++) {
                System.out.print(letter);
                Thread.sleep(500);
            }

            synchronized (monitor2) {
                synchronized (monitor3) {
                    Thread.sleep(200);
                }
            }
        }
    }

    private void threadMethod2(String letter) throws InterruptedException {
        synchronized (monitor1) {
            for (int i = 0; i < 5; i++) {
                System.out.print(letter);
                Thread.sleep(550);
            }

            synchronized (monitor2) {
                synchronized (monitor3) {
                    Thread.sleep(200);
                }
            }
        }
    }

    private void threadMethod3(String letter) throws InterruptedException {
        synchronized (monitor1) {
            for (int i = 0; i < 5; i++) {
                System.out.print(letter);
                Thread.sleep(600);
            }

            synchronized (monitor2) {
                synchronized (monitor3) {
                    Thread.sleep(200);
                }
            }
        }
    }
}
