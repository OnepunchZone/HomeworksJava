package ru.otus.java.oop2.animals;


import ru.otus.java.oop2.Animal;

public class Horse extends Animal {

    public Horse(String name, int speed, int endurance) {
        super(name, speed, endurance);
        super.setEnduranceSwimCost(4);
    }

}
