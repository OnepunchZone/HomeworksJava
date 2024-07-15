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
        Fruit fruit3 = new Apple(0.12);
        Fruit fruit4 = new Orange(0.3);

        Orange orange1 = new Orange(0.4);
        Orange orange2 = new Orange(0.35);
        Orange orange3 = new Orange(0.25);
        Orange orange4 = new Orange(0.2);

        Apple apple1 = new Apple(0.1);
        Apple apple2 = new Apple(0.17);
        Apple apple3 = new Apple(0.25);
        Apple apple4 = new Apple(0.2);


        Box<Apple> appleBox = new Box<>(apple1, apple2, apple3, apple4);
        Box<Orange> orangeBox = new Box<>(orange1, orange2, orange3, orange4);
        Box<Fruit> fruitBox = new Box<>(fruit1, fruit2, fruit3, fruit4);
        printBoxes(fruitBox, appleBox, orangeBox);

        System.out.println("Вес коробки с яблоками = " + appleBox.weightBox());
        System.out.println("Вес коробки с апельсинами = " + orangeBox.weightBox());
        System.out.println("Вес коробки с фруктами = " + fruitBox.weightBox());
        System.out.println(orangeBox.compareBox(fruitBox));
        System.out.println(appleBox.compareBox(fruitBox));
        System.out.println();

        appleBox.getAllFromBox(fruitBox);
        orangeBox.getAllFromBox(fruitBox);
        fruitBox.getAllFromBox(fruitBox);
        printBoxes(fruitBox, appleBox, orangeBox);

        appleBox.addFruit(new Apple(1));
        appleBox.addFruit(new Apple(2));
        orangeBox.addFruit(new Orange(3));
        orangeBox.addFruit(new Orange(4));
        printBoxes(fruitBox, appleBox, orangeBox);
    }

    private static void printBoxes(Box fruit, Box apple, Box orange) {
        System.out.println("Коробка с фруктами:");
        System.out.println(fruit);
        System.out.println("Коробка с яблоками:");
        System.out.println(apple);
        System.out.println("Коробка с апельсинами:");
        System.out.println(orange);
        System.out.println();
    }
}
