package ru.otus.java.basic.oop3.transport;

import ru.otus.java.basic.oop3.LandscapeType;
import ru.otus.java.basic.oop3.Transport;

public class Bicycle implements Transport {
    private int distance;
    private LandscapeType landscapeType;

    public Bicycle(int distance, LandscapeType landscapeType) {
        this.distance = distance;
        this.landscapeType = landscapeType;
    }

    @Override
    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public LandscapeType getLandscapeType() {
        return landscapeType;
    }

    public void setLandscapeType(LandscapeType landscapeType) {
        this.landscapeType = landscapeType;
    }

    @Override
    public boolean move(int distance) {

        if (cantMove()) {
            if (distance <= this.distance) {
                System.out.println("Расстояние полностью пройдено на велике.");
                return true;
            }

            System.out.println("На велосипеде было проехано " + this.distance + " метров.");
            return true;
        }

        return false;
    }

    private boolean cantMove() {

        if (landscapeType == LandscapeType.SWAMP) {
            System.out.println("На велике невозможно передвигаться по этой местности.");
            return false;
        }

        return true;
    }
}
