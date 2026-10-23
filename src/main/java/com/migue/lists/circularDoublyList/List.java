package com.migue.lists.circularDoublyList;

import com.migue.interfaces.ListOperation;


// compareTo() -> interface Comparable
public class List implements ListOperation {
    private Node head;
    private Node last;
    private int size;
    public List() {
        this.size = 0;
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
    public void add(int data) {
        Node n = new Node(data);
        if (this.isEmpty()) {
            this.head = n;
        } else {
            n.setBack(this.last);
            last.setNext(n);
        }
        this.last = n;
        this.head.setBack(this.last);
        this.last.setNext(this.head);
        this.size++;
    }

    @Override
    public void addFirst(int data) {
        Node f = new Node(data);
        f.setNext(this.head);

        // La lista está vacía
        if (this.isEmpty()) {
            this.last = f;
        } else {
            this.head.setBack(f);
        }
        this.head = f;
        this.head.setBack(this.last);
        this.last.setNext(this.head);
        this.size++;
    }

    @Override
    public void delete(int position) {
        if (position < 0 || position > this.size - 1)
            return;
        this.size--;
        if (position == 0) {
            if (this.size == 1) {
                // Esto
                // this.head = null;
                // this.last = null;
                // Es lo mismo que esto
                this.head = this.last = null;
            } else {
                this.head = this.head.getNext();
                this.head.setBack(this.last);
                this.last.setNext(this.head);
            }

            return;
        }
        Node temp = this.head;
        for (int i = 0; i < position - 1; i++) {
            temp = temp.getNext();
        }
        Node temp2 = temp.getNext().getNext();
        temp.setNext(temp2);
        if (temp2 != this.head) {
            temp2.setBack(temp);
        } else {
            this.last = temp;
            this.head.setBack(this.last);
        }
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
            this.head.setBack(this.last);
            this.last.setNext(this.head);
            return;
        }
        if (this.head.getData() > n.getData()) {
            n.setNext(this.head);
            this.head.setBack(n);
            this.head = n;
            this.head.setBack(this.last);
            this.last.setNext(this.head);
            return;
        }
        Node temp = this.head;
        while (temp.getNext() != this.head && temp.getNext().getData() < n.getData()) {
            temp = temp.getNext();
        }
        if (temp.getNext() == this.head) {
            this.last = n;
            n.setBack(temp);
            this.head.setBack(this.last);
            this.last.setNext(this.head);
        } else {
            n.setBack(temp);
            n.setNext(temp.getNext());
            temp.getNext().setBack(n);
        }
        temp.setNext(n);
    }

    @Override
    public void removeDuplicates() {

    }

    @Override
    public void reverse() {

    }
}
