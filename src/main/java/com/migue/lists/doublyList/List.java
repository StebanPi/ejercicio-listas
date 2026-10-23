package com.migue.lists.doublyList;

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
            this.last = n;
        } else {
            n.setBack(this.last);
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
        } else {
            this.head.setBack(f);
        }
        this.head = f;
        this.size++;
    }

    @Override
    public void delete(int position) {
        if (position < 0 || position > this.size - 1)
            return;
        this.size--;
        if (position == 0) {
            this.head = this.head.getNext();
            this.head.setBack(null);
            return;
        }
        Node temp = this.head;
        for (int i = 0; i < position - 1; i++) {
            temp = temp.getNext();
        }
        Node temp2 = temp.getNext().getNext();
        temp.setNext(temp2);
        if (temp2 != null) {
            temp2.setBack(temp);
        } else {
            this.last = temp;
        }
    }

    public int countDupplycate(List lista2) {
        return 0;
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
            if (temp.getData() == data) {
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
            if (temp.getData() == data) {
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
            this.head.setBack(n);
            this.head = n;

            return;
        }
        Node temp = this.head;
        while (temp.getNext() != null && temp.getNext().getData() < n.getData()) {
            temp = temp.getNext();
        }
        if (temp.getNext() == null) {
            this.last = n;
            n.setBack(temp);
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
        Node temp = this.last;
        while(temp != null){
            Node back = temp.getBack();
            temp.setBack(temp.getNext());
            temp.setNext(back);
            temp = back;
        }
        Node aux = this.last;
        this.last = this.head;
        this.head = aux;
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
}
