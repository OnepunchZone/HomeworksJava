package ru.otus.java.oop2;

public class Main {

    public static void main(String[] args) {
        animalPrint();
    }

    private static void animalPrint() {
        Animal[] animal = {new Cat("Мира", 3, 100),
                new Dog("Альма", 2, 60),
                new Horse("Платва", 6, 100),
                new Dog("Снупдог", 4, 60)};


        for (Animal chooseAnimal : animal) {

            if (chooseAnimal instanceof Cat) {

                System.out.println("Котейка " + chooseAnimal.getName() + " начал(а) бег.");
                run(chooseAnimal);
                System.out.println("Котейка не любит мочить лапки =(. Плыть отказывается ");

            }

            if (chooseAnimal instanceof Dog) {

                System.out.println("Пёсель " + chooseAnimal.getName() + " начал(а) бег.");
                run(chooseAnimal);

                System.out.println("Пёсель " + chooseAnimal.getName() + " начал(а) заплыв.");
                swim(chooseAnimal);

            }

            if (chooseAnimal instanceof Horse) {

                System.out.println("Лошадина " + chooseAnimal.getName() + " начал(а) бег.");
                run(chooseAnimal);

                System.out.println("Лошадина " + chooseAnimal.getName() + " начал(а) заплыв.");
                swim(chooseAnimal);

            }

            System.out.println();
        }
    }

    public static void swim(Animal chooseAnimal) {
        int distanceSwimTime = chooseAnimal.swim(100);

        chooseAnimal.info();
        System.out.println("Время прохождения дистанции: " + distanceSwimTime + " сек.");

    }

    public static void run(Animal chooseAnimal) {
        int distanceRunTime = chooseAnimal.run(200);

        chooseAnimal.info();
        System.out.println("Время прохождения дистанции: " + distanceRunTime + " сек.");
    }
}
