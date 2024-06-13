package ru.otus.java.basic.oopstringpractic;

import ru.otus.java.basic.oopstringpractic.tableware.FoodPlate;

public class Cat {
    private String name;
    private int appetite;
    private boolean fullCat;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        fullCat = false;
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public boolean isFullCat() {
        return fullCat;
    }

    public void eat(FoodPlate plate) {
        if (plate.getCurrentFood() - appetite >= 0) {
            plate.reducingFood(appetite);
            fullCat = true;
        } else {
            fullCat = false;
        }
    }

    @Override
    public String toString() {
        return fullCat ? "Котейка " + name + " сытый и довольный." :
                "Котейке " + name + " не хватает еды =(";
    }
}
