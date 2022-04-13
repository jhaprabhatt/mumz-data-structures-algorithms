package com.mumz.test.leet;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        final List<Integer> spiralMatrix = new ArrayList<>(matrix.length * matrix[0].length);
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        int direction = 0;
        while (top <= bottom && left <= right) {
            if (direction == 0) {
                for (int i = left; i <= right; i++)
                    spiralMatrix.add(matrix[top][i]);
                top += 1;
            } else if (direction == 1) {
                for (int i = top; i <= bottom; i++)
                    spiralMatrix.add(matrix[i][right]);
                right -= 1;
            } else if (direction == 2) {
                for (int i = right; i >= left; i--)
                    spiralMatrix.add(matrix[bottom][i]);
                bottom -= 1;
            } else if (direction == 3) {
                for (int i = bottom; i >= top; i--)
                    spiralMatrix.add(matrix[i][left]);
                left += 1;
            }
            direction = (direction + 1) % 4;
        }
        return spiralMatrix;
    }
}
