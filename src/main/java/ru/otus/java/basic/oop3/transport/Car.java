package ru.otus.java.basic.oop3.transport;

import ru.otus.java.basic.oop3.LandscapeType;
import ru.otus.java.basic.oop3.Transport;

public class Car implements Transport {
    private int distance;
    private LandscapeType landscapeType;
    private double maxFuel = 20;
    private int fuelRate = 2;
    private static final int METRES_IN_KM = 1000;
    private final double maxDistance = maxFuel * METRES_IN_KM / fuelRate;

    public Car(int distance, LandscapeType landscapeType) {
        this.distance = distance;
        this.landscapeType = landscapeType;
    }

    @Override
    public double getMaxDistance() {
        return maxDistance;
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

    public double getMaxFuel() {
        return maxFuel;
    }

    public void setMaxFuel(double maxFuel) {
        this.maxFuel = maxFuel;
    }

    public int getFuelRate() {
        return fuelRate;
    }

    public void setFuelRate(int fuelRate) {
        this.fuelRate = fuelRate;
    }

    @Override
    public boolean move(int distance) {

        if (cantMove()) {
            maxFuel -= ((double) this.distance / METRES_IN_KM) * fuelRate;

            if ((maxFuel >= 0 && distance <= this.distance) || (maxFuel <= 0 && maxDistance >= distance) ) {
                System.out.println("Расстояние полностью пройдено на машине.");
                return true;
            } else if (maxFuel >= 0) {
                System.out.println("В машине осталось топлива на " +
                        (maxFuel * METRES_IN_KM) / fuelRate + " метров.");
                return true;
            }
            System.out.println("Машине не хватит топлива на такое расстояние.");

            return false;
        }

        return false;
    }

    private boolean cantMove() {

        if (landscapeType != LandscapeType.PLAIN) {
            System.out.println("Машина не может двигаться по этой местности.");
            return false;
        }

        return true;
    }
}
