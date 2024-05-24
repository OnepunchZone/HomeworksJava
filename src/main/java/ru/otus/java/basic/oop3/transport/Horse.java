package ru.otus.java.basic.oop3.transport;

import ru.otus.java.basic.oop3.LandscapeType;
import ru.otus.java.basic.oop3.Transport;

public class Horse implements Transport{
    private int distance;
    private LandscapeType landscapeType;
    private static double endurance = 1000;
    private static double enduranceRate = 0.5;
    private final double maxDistance = endurance * 2;

    public Horse(int distance, LandscapeType landscapeType) {
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

    public static double getEndurance() {
        return endurance;
    }

    public static void setEndurance(double endurance) {
        Horse.endurance = endurance;
    }

    public static double getEnduranceRate() {
        return enduranceRate;
    }

    public static void setEnduranceRate(double enduranceRate) {
        Horse.enduranceRate = enduranceRate;
    }

    @Override
    public boolean move(int distance) {

        if (cantMove()) {
            endurance -= (double) this.distance * enduranceRate;

            if ((endurance >= 0 && distance <= this.distance) || (endurance <= 0 && maxDistance >= distance) ) {
                System.out.println("Расстояние полностью пройдено на лошадине.");
                return true;
            } else if (endurance >= 0) {
                System.out.println("У лошадины ещё есть силы пройти " +
                        endurance * 2 + " метров.");
                return true;
            }
            System.out.println("Лошадины нет сил пройти такое расстояние.");

            return false;
        }

        return false;
    }

    private boolean cantMove() {

        if (landscapeType == LandscapeType.SWAMP) {
            System.out.println("Лошадина не может передвигаться по этой местности.");
            return false;
        }

        return true;
    }
}
