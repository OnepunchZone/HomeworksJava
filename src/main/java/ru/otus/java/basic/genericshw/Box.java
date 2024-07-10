package ru.otus.java.basic.genericshw;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box <T> {
    private List<T> listObj;

    public Box(T... arrObj) {
        this.listObj = new ArrayList<>(Arrays.asList(arrObj));
    }

    public List<T> getListObj() {
        return listObj;
    }

    public void setListObj(List<T> listObj) {
        this.listObj = listObj;
    }

    public void addFruit(T box) {
        listObj.add(box);
    }

    public void takeFruitFromBox(T fruit, Box<?> delFromBox) {
        listObj.add(fruit);
        delFromBox.getListObj().remove(fruit);
    }

    @Override
    public String toString() {
        return listObj.toString();
    }
}
