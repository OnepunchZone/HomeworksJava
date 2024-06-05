package ru.otus.java.basic.algorithm1;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    private List<Integer> createSortList() {
        List<Integer> numList = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            numList.add(i);
        }
        return numList;
    }

    private Node addNode(Node node, int value) {

        if (node == null) {
            return new Node(value);
        }
        if (value < root.getVal()) {
            node.setLeft(addNode(node.getLeft(), value));
        } else if (value > root.getVal()) {
            node.setRight(addNode(node.getRight(), value));
        } else {
            return node;
        }

        return node;
    }

    public void createTree() {
        int len = createSortList().size();
        int midVal = len / 2;
        root = new Node(createSortList().get(midVal));

        for (int i = 0; i < len ; i++) {
            if (i < midVal) {
                root = addNode(root, createSortList().get((midVal-1) - i));
            } else {
                root = addNode(root, createSortList().get(i));
            }
        }
    }

    private boolean searchValue(Node node, int value) {
        if (node == null ) {
            return false;
        }
        if (value == node.getVal()) {
            return true;
        }
        return value < node.getVal() ? searchValue(node.getLeft(), value) : searchValue(node.getRight(), value);
    }

    public boolean find(int value) {
        return searchValue(root, value);
    }

    public void sortTree(Node node) {
        if (node != null) {
            sortTree(node.getLeft());
            if (node.getVal() < root.getVal()) {
                System.out.print("<" + node.getVal() + " ");
            } else if (node.getVal() > root.getVal()) {
                System.out.print(">" + node.getVal() + " ");
            } else {
                System.out.print("|" + node.getVal() + "| ");
            }
            sortTree(node.getRight());
        }
    }
}
