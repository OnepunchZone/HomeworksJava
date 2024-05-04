package ru.otus.java.OOP1;


public class Main {
    public static void main(String[] args) {
        userPrint();
        boxPrint();
    }

    private static void boxPrint() {
        Box box = new Box(30, 40, 30, "белый");
        box.info();
        box.putInBox();
        box.setOpen(true);
        box.putInBox();
        box.putInBox();
        box.setOpen(false);
        box.deleteFromBox();
        box.setOpen(true);
        box.deleteFromBox();
        box.putInBox();
        box.setColor("Чёрный");
        box.info();
    }

    private static void userPrint() {
        User[] users = {
                new User("Гоголь", "Николай", "Васильевич",
                        1805),
                new User("Парадоксин", "Кот", "Шреденгерович",
                        2882, "bombam@rom.com"),
                new User("Санчес", "Рик", "Петрович",
                        1954, "rick@room.com"),
                new User("Дэпп", "Джонни", "Яковлевич",
                        1963, "johnny@deep.com"),
                new User("Сатурнов", "Сатурн", "Сатурнович",
                        -12229999),
                new User("Пупсов", "Щегол", "Александрович",
                        2022, "pups@child.com"),
                new User("Фролова", "Анна", "Николаевна",
                        1989, "ananik@mail.com"),
                new User("Власов", "Вадим", "Платонович",
                        1984, "vlasvad@gmail.com"),
                new User("Пожилой", "Гусь", "Старпёрович",
                        1930, "gaga@gusi.com"),
                new User("Железный", "Бэндэр", "Футурамович",
                        3026)
        };

        for (User user: users) {
            if(user.maxYear - user.getYearOfTheBirth() > 40) {
                System.out.println(user);
            }
        }
    }
}
