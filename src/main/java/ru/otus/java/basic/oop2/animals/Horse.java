package ru.otus.java.basic.oop2.animals;


import ru.otus.java.basic.oop2.Animal;

public class Horse extends Animal {

    public Horse(String name, int speed, int endurance) {
        super(name, speed, endurance);
        super.setEnduranceSwimCost(4);
    }

}
