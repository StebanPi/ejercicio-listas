package com.migue.lists.simpleList;

// Comparable
public class Node implements Comparable<Node> {
    private int data;
    private Node next;

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public boolean checkData(int data) {
        return this.data == data;
    }

    public Node(int data) {
        this.data = data;
    }

    @Override
    public int compareTo(Node o) {
        return 0;
    }
}