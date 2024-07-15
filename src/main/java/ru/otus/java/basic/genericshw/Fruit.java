package ru.otus.java.basic.genericshw;

public class Fruit<T extends Number> {
    private T weight;

    public Fruit(T weight) {
        this.weight = weight;
    }

    public T getWeight() {
        return weight;
    }

    public void setWeight(T weight) {
        this.weight = weight;
    }
}
