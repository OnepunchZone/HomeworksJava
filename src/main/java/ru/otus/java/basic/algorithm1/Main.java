package ru.otus.java.basic.algorithm1;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.addNode(createList().get(createList().size() / 2));
        for (Integer val : createList()) {
            binaryTree.addNode(val);
        }
        System.out.println(binaryTree.find(1));
        System.out.println(binaryTree.find(3));
        System.out.println(binaryTree.find(23));
        binaryTree.sortTree(binaryTree.getRoot());
    }

    public static List<Integer> createList() {
        List<Integer> numList = new ArrayList<>();
        int[] arr = {7, 5, 12, 9, 3, 16, 10, 4, 19, 11, 8, 23, 21};
        for (Integer num : arr) {
            numList.add(num);
        }
        return numList;
    }
}
