package org.example;

class List {

    Node head;

    class Node {
        int value;
        Node next;
    }
// Метод добавления в начало списка
    public void pushFront(int value){
        Node node = new Node();
        node.value = value;
        node.next = head;
        head = node;
    }

    // Метод удаления из начало списка
    public void popFront(){
        if (head != null){
            head = head.next;
        }
    }
    // Печать списка
    public void print(){
        Node cur = head;
        while (cur !=null){
            System.out.printf("%d ", cur.value);
            cur = cur.next;
        }
        System.out.println();
    }
    // Метод поиска значения
    public boolean consist(int value){
        Node cur = head;
        while (cur !=null){
            if (cur.value == value){
                return true;
            }
            cur = cur.next;
        }
            return false;
    }
// Метод добавления значения в конец

    public void pushBack(int value){
        Node node = new Node();
        node.value = value;

        if (head == null){
            head = node;
        }else {

            Node cur = head;
            while (cur.next !=null){
                cur = cur.next;
            }
            cur.next = node;
        }
    }
// Метод удаления значения с конеца
    public void popBack(){

    if (head != null) {
        if (head.next == null) {
            head = null;
        } else {
            Node cur = head;
            while (cur.next.next != null) {
                cur = cur.next;
            }
            cur.next = null;
        }
    }
}


}

public class Main {
    public static void main(String[] args) {

        List list = new List();
        for (int i=1; i<=5; i++){
            list.pushFront(i);
        }
        list.print();

        list.popFront();
        list.popFront();

        list.print();

        System.out.println(list.consist(2));
        System.out.println(list.consist(4));

        list.pushBack(7);
        list.print();
        list.popBack();
        list.print();

// **************************************************************

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        for (int i=10; i>=1; i--){
            doubleLinkedList.pushBack(i);
        }
        doubleLinkedList.print();

        doubleLinkedList.sort();

        doubleLinkedList.print();

    }

}

// **************************************************************
// Двусвязанный список

class DoubleLinkedList {
    Dnode head;
    Dnode tail;

    class Dnode {
        int value;
        Dnode next;
        Dnode previous;
    }

    public void print(){
        DoubleLinkedList.Dnode cur = head;
        while (cur !=null){
            System.out.printf("%d ", cur.value);
            cur = cur.next;
        }
        System.out.println();
    }


    // Метод добавления в начало списка
    public void pushFront(int value){
        DoubleLinkedList.Dnode dnode = new DoubleLinkedList.Dnode();
        dnode.value = value;
        if (head==null){
            head = dnode;
            tail = dnode;
        }else {
         dnode.next = head;
         head.previous = dnode;
        }
        head = dnode;
    }

    // Метод удаления из начала двусвязанного списка
    public void popFront(){
        if (head != null) {
            if (head.next == null) {
                head = null;
                tail = null;
            } else {
                head = head.next;
            }
        }
    }

// Метод добавления значения в конец двусвязанного списка

    public void pushBack(int value){
        Dnode dnode = new Dnode();
        dnode.value = value;

        if (tail==null){
            head = dnode;
        }else {
            tail.next = dnode;
            dnode.previous = tail;
        }
        tail=dnode;
    }

    // Метод удаления значения с конеца из двусвязанного скиска
    public void popBack(){

        if (tail != null) {
            if(tail.previous==null){
                head = null;
                tail = null;
            }else {
                tail = tail.previous;
            }
        }
    }

    public void sort(){
        boolean needSort = true;
        do{
            needSort=false;
            Dnode dnode = head;
            while (dnode !=null && dnode.next !=null){
                if(dnode.value > dnode.next.value){
                    Dnode before = dnode.previous;
                    Dnode cur = dnode;
                    Dnode next = dnode.next;
                    Dnode after = dnode.next.next;

                    cur.previous = next;
                    cur.next = after;
                    next.previous = before;
                    next.next = cur;

                    if(before != null){
                        before.next = next;
                    }else{
                        head = next;
                    }
                    if(after != null){
                        after.previous = cur;
                    }else{
                        tail = cur;
                    }
                    needSort = true;
                }
                dnode= dnode.next;
            }
        }while (needSort);
    }
}