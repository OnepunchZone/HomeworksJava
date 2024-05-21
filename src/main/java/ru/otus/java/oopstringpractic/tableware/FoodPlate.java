package ru.otus.java.oopstringpractic.tableware;


public class FoodPlate {
    private int maxAmountFood;
    private int currentFood;

    public FoodPlate(int maxAmountFood) {
        this.maxAmountFood = maxAmountFood;
        currentFood = maxAmountFood;
    }

    public int getMaxAmountFood() {
        return maxAmountFood;
    }

    public void setMaxAmountFood(int maxAmountFood) {
        this.maxAmountFood = maxAmountFood;
    }

    public int getCurrentFood() {
        return currentFood;
    }

    public void setCurrentFood(int currentFood) {
        this.currentFood = currentFood;
    }

    public void addSomeFood(int addedFood) {
        System.out.println("В миску с едой добавлено " +
                addedFood + " ед. еды.");

        if (addedFood + currentFood >= maxAmountFood) {
            currentFood = maxAmountFood;
            System.out.println("Тарелка с едой заполнена. " +
                    currentFood + "ед. из " + maxAmountFood + "ед.");
        } else {
            currentFood += addedFood;
            System.out.println("В тарелке сейчас " + currentFood + " ед. из " +
                    maxAmountFood + " ед.");
        }
    }

}


