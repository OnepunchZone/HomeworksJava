package ru.otus.java.basic.oop3;

public interface Transport {
    default double getMaxDistance() {
        return 0;
    }

    default int getDistance() {
        return 0;
    }

    boolean move(int distance);
}
