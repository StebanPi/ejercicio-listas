package com.migue.lists.simpleList;

public class Node implements Comparable<Node> {
    private int data;
    private Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public boolean checkData(int data) {
        return this.data == data;
    }

    @Override
    public int compareTo(Node o) {
        if (o == null) return 1;
        return Integer.compare(this.data, o.data);
    }
}
