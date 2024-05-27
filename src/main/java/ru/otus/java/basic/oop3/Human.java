package ru.otus.java.basic.oop3;

import ru.otus.java.basic.oop3.transport.AllTerrainVehicle;
import ru.otus.java.basic.oop3.transport.Bicycle;
import ru.otus.java.basic.oop3.transport.Car;
import ru.otus.java.basic.oop3.transport.Horse;

public class Human implements Transport{
    private final String name;
    private Transport currentTransport;

    public Human(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Transport getCurrentTransport() {
        return currentTransport;
    }

    public void setCurrentTransport(Transport currentTransport) {
        this.currentTransport = currentTransport;
    }

    public void chooseTransport(Transport transport) {
        currentTransport = transport;
        if (currentTransport instanceof Car) {
            System.out.println(name + " взял машину.");
        } else if (currentTransport instanceof Horse) {
            System.out.println(name + " взял лошадину.");
        } else if (currentTransport instanceof Bicycle) {
            System.out.println(name + " взял велик.");
        } else if (currentTransport instanceof AllTerrainVehicle) {
            System.out.println(name + " взял вездеход.");
        } else {
            System.out.println(name + " решил пойти пешком.");
        }
    }

    @Override
    public boolean move(int distance) {
        return currentTransport.move(distance);
    }
}
