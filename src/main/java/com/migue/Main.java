package com.migue;

import com.migue.lists.circularList.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        List lista = new List();
        lista.add(7);
        lista.add(10);
        lista.add(5);
        lista.add(8);
        lista.add(1);
        System.out.println(lista);
        lista.deleteByData(20);
        System.out.println(lista);
        System.out.println("!");


//        lista.reverse();
//        System.out.println(lista);

    }
}
