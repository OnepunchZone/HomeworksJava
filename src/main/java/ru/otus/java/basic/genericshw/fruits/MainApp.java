package ru.otus.java.basic.genericshw.fruits;

import ru.otus.java.basic.genericshw.Box;
import ru.otus.java.basic.genericshw.Fruit;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        createAndPrint();
    }

    private static void createAndPrint() {
        Fruit fruit1 = new Apple(0.13);
        Fruit fruit2 = new Orange(0.17);
        Fruit fruit3 = new Apple(0.1);
        Fruit fruit4 = new Orange(0.3);

        Orange orange1 = new Orange(0.4);
        Orange orange2 = new Orange(0.35);
        Orange orange3 = new Orange(0.25);
        Orange orange4 = new Orange(0.2);

        Apple apple1 = new Apple(0.1);
        Apple apple2 = new Apple(0.17);
        Apple apple3 = new Apple(0.25);
        Apple apple4 = new Apple(0.2);

        System.out.println("Коробка с яблоками:");
        Box<Apple> appleBox = new Box<>(apple1, apple2, apple3, apple4);
        System.out.println(appleBox);
        System.out.println("Коробка с апельсинами:");
        Box<Orange> orangeBox = new Box<>(orange1, orange2, orange3, orange4);
        System.out.println(orangeBox);
        System.out.println("Коробка с фруктами:");
        Box<Fruit> fruitBox = new Box<>(fruit1, fruit2, fruit3, fruit4);
        System.out.println(fruitBox);
        System.out.println();

        System.out.println("Вес коробки с яблоками = " + weightBox(appleBox.getListObj()));
        System.out.println("Вес коробки с апельсинами = " + weightBox(orangeBox.getListObj()));
        System.out.println("Вес коробки с фруктами = " + weightBox(fruitBox.getListObj()));
        System.out.println(compareBox(orangeBox, fruitBox));
        fruitBox.takeFruitFromBox(orange3, orangeBox);
        System.out.println(compareBox(orangeBox, fruitBox));
        appleBox.takeFruitFromBox((Apple) fruit1, fruitBox);
        orangeBox.addFruit(new Orange(3));
        System.out.println();

        System.out.println(appleBox);
        System.out.println(fruitBox);
        System.out.println(orangeBox);
    }

    public static double weightBox(List<? extends Fruit> list) {
        double sum = 0.0;
        for (Fruit fruit : list) {
            double weightFruit = fruit.getWeight().doubleValue();
            sum += weightFruit;
        }
        return sum;
    }

    public static boolean compareBox(Box<? extends Fruit> box1, Box<? extends Fruit> box2) {
        return Math.abs(weightBox(box1.getListObj()) - weightBox(box2.getListObj())) < 0.0001;
    }
}
