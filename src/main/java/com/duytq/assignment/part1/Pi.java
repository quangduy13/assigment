package com.duytq.assignment.part1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Exercise 3
public class Pi {
    public List<Integer> calculatorPi(List<Integer> input) {
        int zeroFlag = 0;
        int product = 1;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i) == 0)
                zeroFlag++;
            else
                product *= input.get(i);
        }
        for (int i = 0; i < input.size(); i++) {
            if (zeroFlag > 1)
                result.add(0);
            else if (zeroFlag == 1 && input.get(i) != 0)
                result.add(0);
            else if (zeroFlag == 0)
                result.add(product / input.get(i));
            else if (zeroFlag == 1 && input.get(i) == 0)
                result.add(product);
        }

        return result;
    }

    public static void main(String[] args) {
        Pi pi = new Pi();
        List<Integer> integers = Arrays.asList(2, 0, 3, 4, 5);
        System.out.println(pi.calculatorPi(integers));
    }
}
