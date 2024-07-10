package ru.otus.java.basic.genericshw.fruits;

import ru.otus.java.basic.genericshw.Fruit;

public class Orange extends Fruit {

    public Orange(double weight) {
        super(weight);
    }

    @Override
    public String toString() {
        String name = "Апельсин";
        return name + " вес (кг) = " + super.getWeight();
    }
}
