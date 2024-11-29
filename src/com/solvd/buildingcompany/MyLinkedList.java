package com.solvd.buildingcompany;

public class MyLinkedList<T> {
    private Node first;
    private Node last;

    private class Node {
        T data;
        Node next;
        Node previous;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }

    public void add(T data) {
        Node newNode = new Node(data);
        if (first == null) {
            first = last = newNode;
        } else {
            last.next = newNode;
            newNode.previous = last;
            last = newNode;
        }
    }

    public boolean remove(T data) {
        if (first == null) {
            return false;
        }

        if (first.data.equals(data)) {
            first = first.next;

            if (first != null) {
                first.previous = null;
            } else {
                last = null;
            }
            return true;
        }

        Node current = first;

        while (current != null) { // Поиск нужного элемента
            if (current.data.equals(data)) {

                if (current.next == null) {
                    last = current.previous;
                    last.next = null;
                } else { // удаление элемента по середине
                    current.previous.next = current.next;
                    current.next.previous = current.previous;
                }
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative");
        }

        Node current = first;
        int count = 0;
        while (current != null) {
            if (count == index) {
                return current.data;
            }
            count++;
            current = current.next;
        }
        throw new IndexOutOfBoundsException("Index out of bounds");
    }
}
