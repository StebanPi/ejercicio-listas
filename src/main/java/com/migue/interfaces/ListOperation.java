package com.migue.interfaces;

import com.migue.lists.simpleList.Node;

public interface ListOperation {
    void add(int data);
    void addFirst(int data);
    void delete(int position);
    boolean isEmpty();
    Integer get(int position);
    boolean contains(int data);
    int indexOf(int data);
    void addOrder(int data);
    void removeDuplicates();
    void reverse();
}