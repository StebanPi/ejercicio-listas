package com.migue;

import com.migue.lists.simpleList.List;
import java.util.Scanner;

public class Main {

    public static List pedirLista(Scanner sc, String nombre) {
        List lista = new List();
        System.out.print("Ingrese los datos de " + nombre + " separados por espacio: ");
        String linea = sc.nextLine().trim();
        if (!linea.isEmpty()) {
            String[] partes = linea.split(" ");
            for (int i = 0; i < partes.length; i++) {
                if (!partes[i].isEmpty()) {
                    lista.agregarAlFinal(Integer.parseInt(partes[i]));
                }
            }
        }
        return lista;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op = -1;

        while (op != 0) {
            System.out.println("\n--- MENU EJERCICIOS ---");
            System.out.println("1. Combinar dos listas");
            System.out.println("2. Elementos comunes");
            System.out.println("3. Eliminar de una lista los elementos de otra");
            System.out.println("4. Comparar si dos listas son iguales");
            System.out.println("5. Elementos exclusivos");
            System.out.println("6. Transferir elementos entre listas");
            System.out.println("7. Distribuir pares e impares");
            System.out.println("8. Fusionar dos listas ordenadas");
            System.out.println("9. Intercalar dos listas");
            System.out.println("10. Eliminar duplicados entre listas");
            System.out.println("0. Salir");
            System.out.print("Elija una opcion: ");

            try {
                op = Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Opcion no valida");
                continue;
            }

            switch (op) {
                case 1: {
                    List l1 = pedirLista(sc, "Lista 1");
                    List l2 = pedirLista(sc, "Lista 2");
                    List res = List.combinarListas(l1, l2);
                    System.out.print("Resultado: ");
                    res.mostrar();
                    break;
                }
                case 2: {
                    List l1 = pedirLista(sc, "Lista 1");
                    List l2 = pedirLista(sc, "Lista 2");
                    List res = List.elementosComunes(l1, l2);
                    System.out.print("Resultado: ");
                    res.mostrar();
                    break;
                }
                case 3: {
                    List l1 = pedirLista(sc, "Lista 1");
                    List l2 = pedirLista(sc, "Lista 2");
                    l1.eliminarElementosDe(l2);
                    System.out.print("Lista 1: ");
                    l1.mostrar();
                    System.out.print("Lista 2: ");
                    l2.mostrar();
                    break;
                }
                case 4: {
                    List l1 = pedirLista(sc, "Lista 1");
                    List l2 = pedirLista(sc, "Lista 2");
                    if (List.sonIguales(l1, l2)) {
                        System.out.println("Iguales");
                    } else {
                        System.out.println("Diferentes");
                    }
                    break;
                }
                case 5: {
                    List l1 = pedirLista(sc, "Lista 1");
                    List l2 = pedirLista(sc, "Lista 2");
                    List res = List.elementosExclusivos(l1, l2);
                    System.out.print("Resultado: ");
                    res.mostrar();
                    break;
                }
                case 6: {
                    List l1 = pedirLista(sc, "Lista 1");
                    List l2 = pedirLista(sc, "Lista 2");
                    l1.transferirA(l2);
                    System.out.print("Lista 1: ");
                    l1.mostrar();
                    System.out.print("Lista 2: ");
                    l2.mostrar();
                    break;
                }
                case 7: {
                    List l1 = pedirLista(sc, "Lista original");
                    List pares = new List();
                    List impares = new List();
                    l1.distribuirParesImpares(pares, impares);
                    System.out.print("Lista de pares: ");
                    pares.mostrar();
                    System.out.print("Lista de impares: ");
                    impares.mostrar();
                    System.out.print("Lista original: ");
                    l1.mostrar();
                    break;
                }
                case 8: {
                    List l1 = pedirLista(sc, "Lista 1");
                    List l2 = pedirLista(sc, "Lista 2");
                    List res = List.fusionarOrdenadas(l1, l2);
                    System.out.print("Resultado: ");
                    res.mostrar();
                    break;
                }
                case 9: {
                    List l1 = pedirLista(sc, "Lista 1");
                    List l2 = pedirLista(sc, "Lista 2");
                    List res = List.intercalar(l1, l2);
                    System.out.print("Resultado: ");
                    res.mostrar();
                    break;
                }
                case 10: {
                    List l1 = pedirLista(sc, "Lista 1");
                    List l2 = pedirLista(sc, "Lista 2");
                    List.eliminarDuplicadosEntreListas(l1, l2);
                    System.out.print("Lista 1: ");
                    l1.mostrar();
                    System.out.print("Lista 2: ");
                    l2.mostrar();
                    break;
                }
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }
    }
}
