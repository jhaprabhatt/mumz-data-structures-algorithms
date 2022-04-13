package com.mumz.test.leet;

public class SpiralMatrixII {

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        int direction = 0;
        int value = 1;
        while (top <= bottom && left <= right) {
            if (direction == 0) {
                for (int i = left; i <= right; i++) {
                    matrix[top][i] = value;
                    value++;
                }
                top += 1;
            } else if (direction == 1) {
                for (int i = top; i <= bottom; i++) {
                    matrix[i][right] = value;
                    value++;
                }
                right -= 1;
            } else if (direction == 2) {
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = value;
                    value++;
                }
                bottom -= 1;
            } else if (direction == 3) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = value;
                    value++;
                }
                left += 1;
            }
            direction = (direction + 1) % 4;
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = generateMatrix(3);
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
        }
    }
}
