package com.migue.lists.simpleList;

import com.migue.interfaces.ListOperation;

public class List implements ListOperation {
    private Node head;
    private Node last;
    private int size;

    public List() {
        this.head = null;
        this.last = null;
        this.size = 0;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int obtenerTamanio() {
        return this.size;
    }

    public void vaciar() {
        this.head = null;
        this.last = null;
        this.size = 0;
    }

    public void clear() {
        vaciar();
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public void add(int data) {
        agregarAlFinal(data);
    }

    public void agregarAlFinal(int data) {
        Node n = new Node(data);
        if (this.isEmpty()) {
            this.head = n;
            this.last = n;
        } else {
            this.last.setNext(n);
            this.last = n;
        }
        this.size++;
    }

    public void agregarNodo(Node nodo) {
        if (nodo == null) return;
        nodo.setNext(null);
        if (this.head == null) {
            this.head = nodo;
        } else {
            this.last.setNext(nodo);
        }
        this.last = nodo;
        this.size++;
    }

    public void agregarNodoAlFinal(Node n) {
        agregarNodo(n);
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
    public void delete(int position) {
        if (position < 0 || position >= this.size) {
            return;
        }

        if (position == 0) {
            this.head = this.head.getNext();
            if (this.head == null) {
                this.last = null;
            }
            this.size--;
            return;
        }

        Node temp = this.head;
        for (int i = 0; i < position - 1; i++) {
            temp = temp.getNext();
        }

        Node toDelete = temp.getNext();
        temp.setNext(toDelete.getNext());
        if (toDelete == this.last) {
            this.last = temp;
        }
        this.size--;
    }

    @Override
    public Integer get(int position) {
        if (position < 0 || position >= this.size) {
            return null;
        }
        Node temp = this.head;
        for (int i = 0; i < position; i++) {
            temp = temp.getNext();
        }
        return temp.getData();
    }

    @Override
    public boolean contains(int data) {
        Node temp = this.head;
        while (temp != null) {
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
            this.size++;
            return;
        }

        if (this.head.getData() >= n.getData()) {
            n.setNext(this.head);
            this.head = n;
            this.size++;
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
        this.size++;
    }

    @Override
    public void removeDuplicates() {
        if (this.isEmpty()) return;
        Node temp1 = this.head;
        while (temp1 != null && temp1.getNext() != null) {
            Node temp2 = temp1;
            while (temp2.getNext() != null) {
                if (temp2.getNext().checkData(temp1.getData())) {
                    Node toDelete = temp2.getNext();
                    if (toDelete == this.last) {
                        this.last = temp2;
                    }
                    temp2.setNext(toDelete.getNext());
                    this.size--;
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
        while (this.last.getNext() != null) {
            tempNext = this.last.getNext();
            this.last.setNext(tempNext.getNext());
            tempNext.setNext(this.head);
            this.head = tempNext;
        }
    }

    public void mostrar() {
        System.out.println(this);
    }

    public String obtenerTexto() {
        if (this.isEmpty()) {
            return "vacía";
        }
        StringBuilder sb = new StringBuilder();
        Node temp = this.head;
        while (temp != null) {
            sb.append(temp.getData());
            if (temp.getNext() != null) {
                sb.append(" - ");
            }
            temp = temp.getNext();
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return obtenerTexto();
    }

    public List clonar() {
        List copia = new List();
        Node temp = this.head;
        while (temp != null) {
            copia.agregarAlFinal(temp.getData());
            temp = temp.getNext();
        }
        return copia;
    }

    public void eliminarTodasLasOcurrencias(int data) {
        if (this.isEmpty()) return;

        while (this.head != null && this.head.getData() == data) {
            this.head = this.head.getNext();
            this.size--;
        }

        if (this.head == null) {
            this.last = null;
            this.size = 0;
            return;
        }

        Node anterior = this.head;
        while (anterior.getNext() != null) {
            Node actual = anterior.getNext();
            if (actual.getData() == data) {
                anterior.setNext(actual.getNext());
                if (actual == this.last) {
                    this.last = anterior;
                }
                this.size--;
            } else {
                anterior = actual;
            }
        }
    }

    public static List combinarListas(List l1, List l2) {
        List resultado = new List();
        if (l1 != null) {
            Node temp = l1.head;
            while (temp != null) {
                resultado.agregarAlFinal(temp.getData());
                temp = temp.getNext();
            }
        }
        if (l2 != null) {
            Node temp = l2.head;
            while (temp != null) {
                resultado.agregarAlFinal(temp.getData());
                temp = temp.getNext();
            }
        }
        return resultado;
    }

    public static List elementosComunes(List l1, List l2) {
        List resultado = new List();
        if (l1 == null || l2 == null || l1.isEmpty() || l2.isEmpty()) {
            return resultado;
        }
        Node temp = l1.head;
        while (temp != null) {
            if (l2.contains(temp.getData()) && !resultado.contains(temp.getData())) {
                resultado.agregarAlFinal(temp.getData());
            }
            temp = temp.getNext();
        }
        return resultado;
    }

    public void eliminarElementosDe(List otra) {
        if (this.isEmpty() || otra == null || otra.isEmpty()) {
            return;
        }

        while (this.head != null && otra.contains(this.head.getData())) {
            this.head = this.head.getNext();
            this.size--;
        }

        if (this.head == null) {
            this.last = null;
            this.size = 0;
            return;
        }

        Node anterior = this.head;
        while (anterior.getNext() != null) {
            Node actual = anterior.getNext();
            if (otra.contains(actual.getData())) {
                anterior.setNext(actual.getNext());
                if (actual == this.last) {
                    this.last = anterior;
                }
                this.size--;
            } else {
                anterior = actual;
            }
        }
    }

    public static boolean sonIguales(List l1, List l2) {
        if (l1 == null && l2 == null) return true;
        if (l1 == null || l2 == null) return false;
        if (l1.obtenerTamanio() != l2.obtenerTamanio()) {
            return false;
        }
        Node a = l1.head;
        Node b = l2.head;
        while (a != null && b != null) {
            if (a.getData() != b.getData()) {
                return false;
            }
            a = a.getNext();
            b = b.getNext();
        }
        return true;
    }

    public boolean sonIguales(List otra) {
        return sonIguales(this, otra);
    }

    public static List elementosExclusivos(List l1, List l2) {
        List resultado = new List();
        if (l1 != null) {
            Node temp = l1.head;
            while (temp != null) {
                if ((l2 == null || !l2.contains(temp.getData())) && !resultado.contains(temp.getData())) {
                    resultado.agregarAlFinal(temp.getData());
                }
                temp = temp.getNext();
            }
        }
        if (l2 != null) {
            Node temp = l2.head;
            while (temp != null) {
                if ((l1 == null || !l1.contains(temp.getData())) && !resultado.contains(temp.getData())) {
                    resultado.agregarAlFinal(temp.getData());
                }
                temp = temp.getNext();
            }
        }
        return resultado;
    }

    public void transferirA(List destino) {
        if (this.isEmpty() || destino == null) {
            return;
        }
        if (destino.isEmpty()) {
            destino.head = this.head;
            destino.last = this.last;
            destino.size = this.size;
        } else {
            destino.last.setNext(this.head);
            destino.last = this.last;
            destino.size += this.size;
        }
        this.head = null;
        this.last = null;
        this.size = 0;
    }

    public void transferirElementosA(List destino) {
        transferirA(destino);
    }

    public void distribuirParesImpares(List pares, List impares) {
        Node actual = this.head;
        while (actual != null) {
            Node siguiente = actual.getNext();
            if (actual.getData() % 2 == 0) {
                pares.agregarNodo(actual);
            } else {
                impares.agregarNodo(actual);
            }
            actual = siguiente;
        }
        this.head = null;
        this.last = null;
        this.size = 0;
    }

    public static List[] distribuirParesImpares(List origen) {
        List pares = new List();
        List impares = new List();
        if (origen != null) {
            origen.distribuirParesImpares(pares, impares);
        }
        return new List[]{pares, impares};
    }

    public List fusionarCon(List otra) {
        return fusionarOrdenadas(this, otra);
    }

    public static List fusionarOrdenadas(List l1, List l2) {
        List resultado = new List();
        Node p1 = (l1 != null) ? l1.head : null;
        Node p2 = (l2 != null) ? l2.head : null;

        while (p1 != null && p2 != null) {
            if (p1.getData() <= p2.getData()) {
                resultado.agregarAlFinal(p1.getData());
                p1 = p1.getNext();
            } else {
                resultado.agregarAlFinal(p2.getData());
                p2 = p2.getNext();
            }
        }

        while (p1 != null) {
            resultado.agregarAlFinal(p1.getData());
            p1 = p1.getNext();
        }

        while (p2 != null) {
            resultado.agregarAlFinal(p2.getData());
            p2 = p2.getNext();
        }

        return resultado;
    }

    public List intercalarCon(List otra) {
        return intercalar(this, otra);
    }

    public static List intercalar(List l1, List l2) {
        List resultado = new List();
        Node p1 = (l1 != null) ? l1.head : null;
        Node p2 = (l2 != null) ? l2.head : null;

        while (p1 != null || p2 != null) {
            if (p1 != null) {
                resultado.agregarAlFinal(p1.getData());
                p1 = p1.getNext();
            }
            if (p2 != null) {
                resultado.agregarAlFinal(p2.getData());
                p2 = p2.getNext();
            }
        }

        return resultado;
    }

    public void eliminarDuplicadosCon(List otra) {
        eliminarDuplicadosEntreListas(this, otra);
    }

    public static void eliminarDuplicadosEntreListas(List l1, List l2) {
        if (l1 == null || l2 == null || l1.isEmpty() || l2.isEmpty()) {
            return;
        }

        Node temp = l1.head;
        while (temp != null) {
            l2.eliminarTodasLasOcurrencias(temp.getData());
            temp = temp.getNext();
        }
    }
}
