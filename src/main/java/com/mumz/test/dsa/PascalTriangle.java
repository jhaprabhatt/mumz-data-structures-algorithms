package com.mumz.test.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
    // f(i,j)=f(i−1,j−1)+f(i−1,j)
    public static List<Integer> getRow(int rowIndex) {
        return getRowSimpleSolution(rowIndex);
    }

    private static List<Integer> getRowSimpleSolution(int row) {
        if (row == 0) {
            return Arrays.asList(new Integer[]{1});
        }
        final List<List<Integer>> pascalTriangle = new ArrayList<>();
        for (int i = 0; i <= row; i++) {
            List<Integer> currentRowValues = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0) {
                    currentRowValues.add(1);
                } else {
                    currentRowValues.add(pascalTriangle.get(i - 1).get(j) + pascalTriangle.get(i - 1).get(j - 1));
                }
            }
            currentRowValues.add(1);
            pascalTriangle.add(currentRowValues);
        }
        return pascalTriangle.get(row);
    }

    public List<List<Integer>> generate(int numRows) {
        final List<List<Integer>> pascalTriangle = new ArrayList<>();
        for (int i = 0; i <= numRows; i++) {
            List<Integer> currentRowValues = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0) {
                    currentRowValues.add(1);
                } else {
                    currentRowValues.add(pascalTriangle.get(i - 1).get(j) + pascalTriangle.get(i - 1).get(j - 1));
                }
            }
            currentRowValues.add(1);
            pascalTriangle.add(currentRowValues);
        }
        return pascalTriangle;
    }

    public static void main(String[] args) {
        System.out.println(getRow(3));
    }
}
