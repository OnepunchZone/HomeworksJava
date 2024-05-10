package ru.otus.java.oop2.animals;


import ru.otus.java.oop2.Animal;

public class Dog extends Animal {

    public Dog(String name, int speed, int endurance) {
        super(name, speed, endurance);
        super.setEnduranceSwimCost(2);
    }

}
