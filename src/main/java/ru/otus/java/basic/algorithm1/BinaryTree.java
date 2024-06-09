package ru.otus.java.basic.algorithm1;

public class BinaryTree {
    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void addNode(int value) {
        Node newNode = new Node(value);

        if (root == null) {
            root = newNode;
        }
        else {
            Node nodeNow = root;
            Node parentNode;

            while (true) {
                parentNode = nodeNow;
                if(value == nodeNow.getVal()) {
                    return;
                }
                else  if (value < nodeNow.getVal()) {
                    nodeNow = nodeNow.getLeft();
                    if (nodeNow == null) {
                        parentNode.setLeft(newNode);
                        return;
                    }
                }
                else {
                    nodeNow = nodeNow.getRight();
                    if (nodeNow == null) {
                        parentNode.setRight(newNode);
                        return;
                    }
                }
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
