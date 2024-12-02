package com.solvd.buildingcompany.utils;

public class MyLinkedList<T> {
    private Node first;
    private Node last;

    private class Node {
        private T data;
        private Node next;
        private Node previous;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }

    public void add(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }

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

        while (current != null) {
            if (current.data.equals(data)) {
                current.previous.next = current.next;

                if (current.next != null) {
                    current.next.previous = current.previous;
                } else {
                    last = current.previous;
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
