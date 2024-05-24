package ru.otus.java.basic.oop3;

import ru.otus.java.basic.oop3.transport.AllTerrainVehicle;
import ru.otus.java.basic.oop3.transport.Bicycle;
import ru.otus.java.basic.oop3.transport.Car;
import ru.otus.java.basic.oop3.transport.Horse;

public class Main {
    public static void main(String[] args) {
        print();
    }

    private static void print() {
        Human rick = new Human("Рик");
        Car car = new Car(1000, LandscapeType.SWAMP);
        Horse horse = new Horse(1000, LandscapeType.DENSE_FOREST);
        Bicycle bicycle = new Bicycle(500, LandscapeType.PLAIN);
        AllTerrainVehicle allTerrainVehicle = new AllTerrainVehicle(6000, LandscapeType.SWAMP);

        Transport[] transports = {car, horse, bicycle, allTerrainVehicle};

        int distance = 5000;

        for (Transport transport : transports) {
            System.out.println("Нужно преодолеть " + distance + " метров.");
            createHumanChooseTransportMove(rick, transport, distance);
            distance += 500;
            System.out.println();
        }
    }

    public static void createHumanChooseTransportMove(Human human, Transport transport, int distance) {
        human.chooseTransport(transport);
        if (human.move(distance)) {
            distance -= transport.getDistance();
            System.out.println(distance <= 0 ? human.getName() + " завершил дистанцию." :
                    "Осталось пройти " + distance);
            if (distance > 0) {
                human.chooseTransport(human);
                System.out.println(human.getName() + " завершил дистанцию пешком!");
            }
        } else {
            System.out.println("Дистанция не пройдена. Осталось " +
                    (distance < transport.getMaxDistance() ? distance :
                            distance - transport.getMaxDistance()) + " метров.");
            human.chooseTransport(human);
            System.out.println(human.getName() + " завершил дистанцию пешком.");
        }
    }
}
