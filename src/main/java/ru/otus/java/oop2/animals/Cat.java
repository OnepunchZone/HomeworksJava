package ru.otus.java.oop2.animals;


import ru.otus.java.oop2.Animal;

public class Cat extends Animal {

    public Cat(String name, int speed, int endurance) {
        super(name, speed, endurance);
    }

    @Override
    public int swim(int distance) {
        super.setEnduranceSwimCost(-1);
        return -1;
    }

    @Override
    public void info() {
        System.out.println(getName() + (getEndurance() < 1 ? (( getEnduranceSwimCost() == -1 ?
                " не любит мочить лапки =(." + " Плыть отказывается. " :
                " очень устал(а) и не сможет завершить дистанцию.")) :
                ((getEnduranceSwimCost() == -1 ? " не любит мочить лапки =(." +
                        " Плыть отказывается. " : " отлично себя чувствует. Прошёл/прошла всю дистанцию и сохранил " +
                        getEndurance() + " ед выносливости!"))));
    }
}
