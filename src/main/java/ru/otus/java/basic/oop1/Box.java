package ru.otus.java.basic.oop1;

public class Box {
    private final int length;
    private final int width;
    private final int height;
    private String color;
    private boolean open;
    private boolean isEmpty;

    public Box(int length, int width, int height, String color) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.color = color;
        open = false;
        isEmpty = true;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isOpen() {
        return open;
    }

    public void openBox() {
        System.out.println("///Вызывается функция openBox()///");
        open = true;

        System.out.println("Коробка открыта.");
    }

    public void closeBox() {
        System.out.println("///Вызывается функция closeBox()///");
        open = false;

        System.out.println("Коробка закрыта.");
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void info() {
        System.out.println("///Вызывается функция info()///");
        System.out.println("Размеры коробки:\n" + "длина- " + length +
                "; ширина- " + width + "; высота- " + height +
                "\nЦвет коробки:\n" + color);
        System.out.println(open ? "Коробка открыта." : "Коробка закрыта.");
        System.out.println(isEmpty ? "Коробка пустая." : "В коробке что-то лежит.");
        System.out.println();
    }

    public void putInBox() {
        System.out.println("///Вызывается функция putInBox()///");
        if (open) {

            if (isEmpty) {
                System.out.println("В коробке нет предметов.");
                isEmpty = false;
                System.out.println("Предмет помещён в коробку.");
            } else {
                System.out.println("Сначала удалите пердмет из коробки." +
                        " Воспользуйтесь функцией deleteFromBox().");
            }

        } else {
            System.out.println("Нужно открыть коробку." +
                    " Воспользуйтесь функцией openBox()");
        }
    }

    public void deleteFromBox() {
        System.out.println("///Вызывается функция deleteFromBox()///");
        if (!isEmpty) {
            System.out.println("В коробке что-то лежит.");
            if (open) {
                System.out.println("Коробка открыта. Удаляю предмет.");
                isEmpty = true;
                System.out.println("Коробка вновь пустая.");
            } else {
                System.out.println("Откройте сначала коробку" +
                        ". Воспользуйтесь функцией openBox()");
            }
        } else {
            System.out.println("Коробка пустая.");
        }
    }
}
