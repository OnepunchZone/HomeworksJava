package ru.otus.java.basic.algorithm1;

public class Node {
    private int val;
    private Node left;
    private Node right;

    Node(int val) {
        this.val = val;
        left = null;
        right = null;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return val + " " + right;
    }
}
