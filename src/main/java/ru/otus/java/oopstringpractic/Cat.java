package ru.otus.java.oopstringpractic;

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

    public void setFullCat(boolean fullCat) {
        this.fullCat = fullCat;
    }

    @Override
    public String toString() {
        return fullCat ? "Котейка " + name + " сытый и довольный." :
                "Котейке " + name + " не хватает еды =(";
    }
}
