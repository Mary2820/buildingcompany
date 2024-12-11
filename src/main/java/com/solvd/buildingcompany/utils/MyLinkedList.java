package com.solvd.buildingcompany.utils;

public class MyLinkedList<T> {
    private Node<T> first;
    private Node<T> last;

    public void add(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }

        Node<T> newNode = new Node<>(data);
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

        Node<T> current = first;

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

        Node<T> current = first;
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

    public String toString() {
        if (first == null) {
            return "[]";
        }

        StringBuilder result = new StringBuilder("[\n");
        Node<T> current = first;

        while (current != null) {
            result.append(current.data);
            if (current.next != null) {
                result.append(",\n ");
            }
            current = current.next;
        }

        result.append("\n]");
        return result.toString();
    }
}
