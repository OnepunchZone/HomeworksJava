package ru.otus.java.basic.genericshw.fruits;

import ru.otus.java.basic.genericshw.Fruit;

public class Apple extends Fruit {

    public Apple(double weight) {
        super(weight);
    }

    @Override
    public String toString() {
        String name = "Яблоко";
        return name + " вес (кг) = " + super.getWeight();
    }
}
