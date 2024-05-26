package ru.otus.java.basic.hwexceptions.exceptions;

public class AppArrayDataException extends RuntimeException{
    int i, j;

    public AppArrayDataException(String message, int i, int j) {
        super("Невозможно преобразовать элемент массива [" +
                i + "][" + j + "] к типу int.");
        this.i = i;
        this.j = j;

    }
}
