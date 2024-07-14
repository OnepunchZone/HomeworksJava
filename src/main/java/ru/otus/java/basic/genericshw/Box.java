package ru.otus.java.basic.genericshw;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box <T> {
    private List<T> listObj;

    public Box(T... arrObj) {
        this.listObj = new ArrayList<>(Arrays.asList(arrObj));
    }

    public List<T> getListObj() {
        return listObj;
    }

    public void setListObj(List<T> listObj) {
        this.listObj = listObj;
    }

    public double weightBox() {
        double sum = 0.0;
        for (Fruit fruit : (List<? extends Fruit>) listObj) {
            double weightFruit = fruit.getWeight().doubleValue();
            sum += weightFruit;
        }
        return sum;
    }

    public boolean compareBox(Box<? extends Fruit> box) {
        return Math.abs(this.weightBox() - box.weightBox()) < 0.0001;
    }

    public void addFruit(T t) {
        listObj.add(t);
    }

    public void getAllFromBox(List<? extends T> box) {
        listObj.addAll(box);
        box.clear();
    }

    @Override
    public String toString() {
        return listObj.toString();
    }
}