package com.migue.lists.circularList;

import com.migue.interfaces.ListOperation;

public class List implements ListOperation {
    private Node head;
    private Node last;
    private int size;

    public List() {
        this.size = 0;
    }


    @Override
    public void add(int data) {
        Node n = new Node(data);
        if (this.isEmpty()) {
            this.head = n;
        } else {
            last.setNext(n);
        }
        this.last = n;
        n.setNext(this.head);

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
        this.last.setNext(this.head);

        this.size++;
    }

    public void deleteByData(int data) {
//        this.size--;

        if (this.head.getData() == data) {
            this.head = this.head.getNext();
            this.last.setNext(this.head);
            this.size--;
            return;
        }

        Node temp = this.head;
        //
        while (temp.getNext() != this.head && temp.getNext().getData() != data) {
            temp = temp.getNext();
        }

        if (temp.getNext() == this.head) return;

        if (temp.getNext() == this.last) {
            this.last = temp;
        }

        Node temp2 = temp.getNext().getNext();
        temp.setNext(temp2);
        this.size--;
    }


    @Override
    public void delete(int position) {
        if (position < 0 || position > this.size - 1)
            return;

        this.size--;

        if (position == 0) {
            this.head = this.head.getNext();
            this.last.setNext(this.head);
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
    public String toString() {
        String info = "[";
        Node temp = this.head;
        if (!this.isEmpty()) {
            do {
                info = info.concat(temp.getData()+((temp.getNext() == this.head)?"":", "));

                temp = temp.getNext();
            } while (temp != this.head);
        }
        return  info.concat("]");
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public Integer get(int position) {
        return 0;
    }

    @Override
    public boolean contains(int data) {
        return false;
    }

    @Override
    public int indexOf(int data) {
        return 0;
    }

    @Override
    public void addOrder(int data) {
        Node n = new Node(data);

        if (this.isEmpty()) {
            this.head = n;
            this.last = n;
            n.setNext(this.head);
            return;
        }

        if (this.head.getData() > n.getData()) {
            n.setNext(this.head);
            this.head = n;
            this.last.setNext(this.head);
            return;
        }

        Node temp = this.head;
        while (temp.getNext() != this.head && temp.getNext().getData() < n.getData()) {
            temp = temp.getNext();
        }

        if (temp.getNext() == this.head) {
            this.last = n;
        }
        n.setNext(temp.getNext());
        temp.setNext(n);
    }


    @Override
    public void removeDuplicates() {

    }

    @Override
    public void reverse() {

    }
}
