package ru.otus.java.oop2;

public class Animal {
    private String name;
    private int speed;
    private int enduranceSwimCost;
    private int endurance;
    private final int enduranceRunCost = 1;

    public Animal(String name, int speed, int endurance) {
        this.name = name;
        this.speed = speed;
        this.endurance = endurance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getEnduranceSwimCost() {
        return enduranceSwimCost;
    }

    public void setEnduranceSwimCost(int enduranceSwimCost) {
        this.enduranceSwimCost = enduranceSwimCost;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public int getEnduranceRunCost() {
        return enduranceRunCost;
    }

    public int run(int distance) {
        return time(distance, enduranceRunCost);
    }

    public int swim(int distance) {
        return time(distance, enduranceSwimCost);
    }

    private int time(int distance, int enduranceCost) {
        int distancePassed = distance;

        for (int i = 0; i <= distance; i += speed) {
            distancePassed -= speed;

            if (distancePassed < 1) {
                break;
            }

            if (endurance < 1) {
                return -1;
            }

            endurance -= enduranceCost;
        }

        return distance / speed;
    }

    public void info() {
        System.out.println(name + (endurance < 1 ? (" очень устал(а) и не смог завершить дистанцию.") :
                (" отлично себя чувствует. Прошёл/прошла всю дистанцию и сохранил " +
                endurance + " ед выносливости!")));
    }
}
