package com.duytq.assignment.part1;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public List<Integer> spiralMatrix(int n) {
        int[][] matrix = generateMatrix(n);
        int sizeMatrix = n * n;

        /*
        there are 4 direction:
            move column to right: (0, 1)
            move column to left: (0, -1)
            move row to bottom: (1, 0)
            move row to top: (-1, 0)

         */
        List<Integer> result = new ArrayList<>();
        int row = 0;
        int col = 0;
        int di = 0;
        int[]dir = DIRECTIONS[0];
        for (int i = 0; i < sizeMatrix; i++) {
            result.add(matrix[row][col]);
            //mark use
            matrix[row][col] = -1;
            //check valid next element
            if (inValidNextElement(matrix, row, col, dir)){
                di = (di+1) %4;
                dir = DIRECTIONS[di];
            }
            row += dir[0];
            col += dir[1];

        }
        return result;
    }

    private boolean inValidNextElement(int[][] matrix, int r, int c, int[] dir) {
        int nextRow = r + dir[0];
        int nextCol = c + dir[1];
        if (nextRow < 0 || nextRow >= matrix.length)
            return true;
        if (nextCol < 0 || nextCol >= matrix[0].length)
            return true;
        return matrix[nextRow][nextCol] == -1;
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int number = 1;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                matrix[r][c] = number++;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        List<Integer> spiral = spiralMatrix.spiralMatrix(4);
        System.out.println(spiral);
    }
}
