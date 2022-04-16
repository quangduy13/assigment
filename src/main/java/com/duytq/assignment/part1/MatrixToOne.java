package com.duytq.assignment.part1;

//Exercise 4
public class MatrixToOne {
    public static int[][] matrixToOne(int[][] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1)
                    arr[i][0] = arr[0][j] = 1;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int arr[][] = {{0, 1, 2, 0}, {3, 1, 5, 2}, {1, 3, 1, 5}};
        matrixToOne(arr);
    }
}
