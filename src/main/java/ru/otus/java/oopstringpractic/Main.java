package ru.otus.java.oopstringpractic;

import ru.otus.java.oopstringpractic.tableware.FoodPlate;

public class Main {

    public static void main(String[] args) {
        print();
    }

    public static void print() {
        Cat[] cats = {new Cat("Ричард", 30),
                new Cat("Боря", 100),
                new Cat("Андрей", 50),
                new Cat("Муся", 80),
                new Cat("Арчи", 50),
                new Cat("Базилио", 20)};

        FoodPlate plate = new FoodPlate(200);

        for (Cat chooseCat : cats) {
            infoAndReducingFood(chooseCat, plate);

            if (!chooseCat.isFullCat()) {
                plate.addSomeFood(300);
                infoAndReducingFood(chooseCat, plate);
            }
        }
    }

    private static void infoAndReducingFood(Cat chooseCat, FoodPlate plate) {
        plate.reducingFood(chooseCat);
        System.out.println(chooseCat);
    }


}
