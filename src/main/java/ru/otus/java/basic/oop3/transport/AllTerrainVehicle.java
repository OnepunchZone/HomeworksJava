package ru.otus.java.basic.oop3.transport;

import ru.otus.java.basic.oop3.LandscapeType;
import ru.otus.java.basic.oop3.Transport;

public class AllTerrainVehicle implements Transport {
    private int distance;
    private LandscapeType landscapeType;
    private static double maxFuel = 40;
    private static int fuelRate = 8;
    private static final int METRES_IN_KM = 1000;
    private final double maxDistance = maxFuel * METRES_IN_KM / fuelRate;;

    public AllTerrainVehicle(int distance, LandscapeType landscapeType) {
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

    public static double getMaxFuel() {
        return maxFuel;
    }

    public static void setMaxFuel(double maxFuel) {
        AllTerrainVehicle.maxFuel = maxFuel;
    }

    public static int getFuelRate() {
        return fuelRate;
    }

    public static void setFuelRate(int fuelRate) {
        AllTerrainVehicle.fuelRate = fuelRate;
    }

    @Override
    public boolean move(int distance) {

        maxFuel -= ((double) this.distance / METRES_IN_KM) * fuelRate;

        if ((maxFuel >= 0 && distance <= this.distance) || (maxFuel <= 0 && maxDistance >= distance) ) {
            System.out.println("Расстояние полностью пройдено на вездеходе.");
            return true;
        } else if (maxFuel >= 0) {
            System.out.println("В вездеходе осталось топлива на " +
                    (maxFuel * METRES_IN_KM) / fuelRate + " метров.");
            return true;
            }
        System.out.println("Вездеходу не хватит топлива на такое расстояние.");

        return false;
    }
}
