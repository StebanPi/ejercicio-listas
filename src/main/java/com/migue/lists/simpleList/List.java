package com.migue.lists.simpleList;

import com.migue.interfaces.ListOperation;

public class List implements ListOperation {
    private Node head;
    private Node last;
    private int size;

    @Override
    public void add(int data) {
        Node n = new Node(data);
        if (this.isEmpty()) {
            this.head = n;
            this.last = n;
        } else {
            last.setNext(n);
            last = n;
        }

        this.size++;
    }

    @Override
    public void addFirst(int data) {
        Node f = new Node(data);
        f.setNext(this.head);
        if (this.isEmpty()) {
            this.last = f;
        }

        this.head = f;

        this.size++;
    }

    @Override
    public String toString() {
        String info = "[";
        Node temp = this.head;
        while (temp != null) {
            info = info.concat(temp.getData()+((temp.getNext() == null)?"":", "));

            temp = temp.getNext();
        }

        return  info.concat("]");
    }

    @Override
    public void delete(int position) {
        if (position < 0 || position > this.size - 1)
            return;

        this.size--;

        if (position == 0) {
            this.head = this.head.getNext();
            return;
        }

        Node temp = this.head;
        //
        for (int i = 0; i < position - 1; i++) {
            temp = temp.getNext();
        }
        if (temp.getNext() == this.last) {
            this.last = temp;
        }
        Node temp2 = temp.getNext().getNext();

        temp.setNext(temp2);
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public Integer get(int position) {
        if (position < 0 || position > this.size - 1)
            return null;

        Node temp = this.head;
        //
        for (int i = 0; i < position; i++) {
            temp = temp.getNext();
        }

        return temp.getData();
    }

    @Override
    public boolean contains(int data) {
        Node temp = this.head;
        while (temp != null) {
            //temp.getData() == data
            if (temp.checkData(data)) {
                return true;
            }
            temp = temp.getNext();
        }

        return false;

    }

    @Override
    public int indexOf(int data) {
        Node temp = this.head;
        int index = 0;
        while (temp != null) {
            //temp.getData() == data
            if (temp.checkData(data)) {
                return index;
            }
            index++;
            temp = temp.getNext();
        }

        return -1;
    }

    @Override
    public void addOrder(int data) {
        Node n = new Node(data);

        if (this.isEmpty()) {
            this.head = n;
            this.last = n;
            return;
        }

        if (this.head.getData() > n.getData()) {
            n.setNext(this.head);
            this.head = n;
            return;
        }

        Node temp = this.head;
        while (temp.getNext() != null && temp.getNext().getData() < n.getData()) {
            temp = temp.getNext();
        }

        if (temp.getNext() == null) {
            this.last = n;
        } else {
            n.setNext(temp.getNext());
        }
        temp.setNext(n);
    }

    @Override
    public void removeDuplicates() {
        if (this.isEmpty()) return;
        Node temp1 = this.head;
        while (temp1 != this.last) {
            Node temp2 = temp1;
            while (temp2.getNext() != null) {
                if (temp2.getNext().checkData(temp1.getData())) {
                    if (temp2.getNext() == this.last) {
                        this.last = temp2;
                    }
                    this.size--;
                    // Eliminar
                    temp2.setNext(temp2.getNext().getNext());
                } else {
                    temp2 = temp2.getNext();
                }
            }
            temp1 = temp1.getNext();
        }
    }

    @Override
    public void reverse() {
        if (this.isEmpty() || this.size == 1) return;
        this.last = this.head;
        Node tempNext;
        while(this.last.getNext() != null) {
            tempNext = this.last.getNext();
            this.last.setNext(tempNext.getNext());
            tempNext.setNext(this.head);
            this.head = tempNext;
        }
    }
}