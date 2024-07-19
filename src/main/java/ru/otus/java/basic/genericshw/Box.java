package ru.otus.java.basic.genericshw;


import org.jetbrains.annotations.NotNull;
import ru.otus.java.basic.genericshw.fruits.Apple;
import ru.otus.java.basic.genericshw.fruits.Orange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box <T extends Fruit> implements Comparable<T> {
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
        for (Fruit fruit : listObj) {
            double weightFruit = fruit.getWeight().doubleValue();
            sum += weightFruit;
        }
        return sum;
    }

    public boolean compareBox(Box<? extends Fruit> box) {
        return Math.abs(this.weightBox() - box.weightBox()) < 0.0001;
    }

    public void addFruit(T t) {

        if (this.compareTo(t) == 0) {
            System.out.println("Нельзя добавить класс Fruit. Только Apple или Orange");
        } else {
            listObj.add(t);
        }
    }

    public void getAllFromBox(Box<? super T> box) {

        if (this == box) {
            System.out.println("Нельзя пересыпать в эту же коробку.");
        }
        else {
            box.getListObj().addAll(0, this.listObj);
            this.listObj.clear();
        }
    }

    @Override
    public int compareTo(@NotNull T o) {
        if (o instanceof Apple) {
            return 1;
        } else if (o instanceof Orange) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return listObj.toString();
    }
}
