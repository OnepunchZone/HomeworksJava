package ru.otus.java.basic.hwexceptions.exceptions;
public class AppArrayDataException extends RuntimeException{

    public AppArrayDataException(int i, int j) {
        super("Невозможно преобразовать элемент массива [" +
                i + "][" + j + "] к типу int.");
    }
}
