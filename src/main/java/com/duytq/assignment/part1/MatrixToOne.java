package com.duytq.assignment.part1;

//Exercise 4
public class MatrixToOne {
    public static int[][] matrixToOne(int[][] arr) {
        int n = arr.length;
        int col0 = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i][0] == 1)
                col0 = 1;
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1)
                    arr[i][0] = arr[0][j] = 1;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > 0; j--) {
                if (arr[0][j] == 1 || arr[i][0] == 1)
                    arr[i][j] = 1;
            }
            if (col0 == 1)
                arr[i][0] = 1;
        }

        return arr;
    }

    public static void main(String[] args) {
        int arr[][] = {{1, 0, 2, 3},
                {3, 3, 2, 4},
                {1, 0, 2, 3},
                {5, 9, 2, 5}};
        matrixToOne(arr);
    }
}
