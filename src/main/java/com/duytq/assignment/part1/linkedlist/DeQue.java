package com.duytq.assignment.part1.linkedlist;

public class DeQue {
    DoubleQueNode head;
    DoubleQueNode tail;

    public DeQue() {
        head = null;
        tail = null;
    }

    public int pop_front() {
        if (head == null) {
            throw new NullPointerException("");
        }
        DoubleQueNode temp = head;
        head = head.next;
        head.prev = null;
        return temp.data;
    }

    public int pop_back() {
        if (head == null) {
            throw new NullPointerException("");
        }
        DoubleQueNode temp = tail;
        tail = tail.prev;
        tail.next = null;
        return temp.data;
    }

    public void push_front(int n) {
        DoubleQueNode doubleQueNode = new DoubleQueNode();
        doubleQueNode.data = n;

        if (head == null) {
            doubleQueNode.prev = null;
            doubleQueNode.next = null;
            head = doubleQueNode;
            tail = doubleQueNode;
        } else {
            head.prev = doubleQueNode;
            doubleQueNode.prev = null;
            doubleQueNode.next = head;
            head = doubleQueNode;
        }
    }

    public void push_back(int n) {
        DoubleQueNode doubleQueNode = new DoubleQueNode();
        doubleQueNode.data = n;

        if (tail == null) {
            doubleQueNode.prev = null;
            doubleQueNode.next = null;
            head = doubleQueNode;
            tail = doubleQueNode;
        } else {
            tail.next = doubleQueNode;
            doubleQueNode.prev = tail;
            doubleQueNode.next = null;
            tail = doubleQueNode;
        }
    }

    public void display() {
        if (head == null)
            return;
        DoubleQueNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + ", ");
            temp = temp.next;
        }
    }
}
