package com.duytq.assignment.part1;

import com.duytq.assignment.part1.linkedlist.DeQue;

import java.util.ArrayList;
import java.util.List;

public class ArrayStructure {
    //implement queue
    public static void main(String[] args) {
        DeQue deQue = new DeQue();
        deQue.push_front(8);
        deQue.push_back(15);
        deQue.push_front(20);
        deQue.push_back(30);
        deQue.display();

        deQue.pop_back();
        deQue.pop_front();
        System.out.println("After pop:");
        deQue.display();
    }
}
