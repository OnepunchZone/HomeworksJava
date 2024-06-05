package ru.otus.java.basic.algorithm1;

public class Main {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.createTree();
        System.out.println(binaryTree.find(1));
        System.out.println(binaryTree.find(10));
        System.out.println(binaryTree.find(15));
        binaryTree.sortTree(binaryTree.getRoot());
    }
}
