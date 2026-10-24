package com.migue;

import com.migue.lists.simpleList.List;

public class Main {


    static List crear(int... valores) {
        List lista = new List();
        for (int v : valores) {
            lista.agregarAlFinal(v);
        }
        return lista;
    }

    public static void main(String[] args) {


        System.out.println("Ejercicio 1: Combinar ");
        List a1 = crear(10, 20, 30);
        List b1 = crear(40, 50, 60);
        List.combinarListas(a1, b1).mostrar();


        System.out.println(" Ejercicio 2: Comunes ");
        List a2 = crear(5, 10, 15, 20, 25);
        List b2 = crear(10, 20, 30, 40);
        List.elementosComunes(a2, b2).mostrar();


        System.out.println(" Ejercicio 3: Eliminar elementos de otra ");
        List a3 = crear(10, 20, 30, 40, 50);
        List b3 = crear(20, 40);
        a3.eliminarElementosDe(b3);
        System.out.print("Lista 1: "); a3.mostrar();
        System.out.print("Lista 2: "); b3.mostrar();


        System.out.println("Ejercicio 4: Son iguales ");
        System.out.println(List.sonIguales(crear(1, 2, 3), crear(1, 2, 3)) ? "Iguales" : "Diferentes");
        System.out.println(List.sonIguales(crear(1, 2, 3), crear(1, 3, 2)) ? "Iguales" : "Diferentes");
        System.out.println(List.sonIguales(crear(1, 2), crear(1, 2, 3)) ? "Iguales" : "Diferentes");
        System.out.println(List.sonIguales(crear(), crear()) ? "Iguales" : "Diferentes");


        System.out.println(" Ejercicio 5: Exclusivos");
        List a5 = crear(1, 2, 3, 4);
        List b5 = crear(3, 4, 5, 6);
        List.elementosExclusivos(a5, b5).mostrar();


        System.out.println(" Ejercicio 6: Transferir ");
        List a6 = crear(10, 20, 30);
        List b6 = crear(40, 50);
        a6.transferirA(b6);
        System.out.print("Lista 1: "); a6.mostrar();
        System.out.print("Lista 2: "); b6.mostrar();


        System.out.println("Ejercicio 7: Pares e impares ");
        List original = crear(8, 3, 12, 7, 4, 9);
        List pares = new List();
        List impares = new List();
        original.distribuirParesImpares(pares, impares);
        System.out.print("Original: "); original.mostrar();
        System.out.print("Pares: "); pares.mostrar();
        System.out.print("Impares: "); impares.mostrar();
    }
}