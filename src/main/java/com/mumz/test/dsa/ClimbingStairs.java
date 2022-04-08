package com.mumz.test.dsa;

public class ClimbingStairs {
    /**
     * Algo
     * <p>
     * If steps == 0 return 0
     * If steps == 1 return 1
     * remaining_steps = steps - 1
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if (n < 0) return 0;
        if (n == 0 || n == 1) return 1;
        int[] steps = new int[n + 1];
        steps[0] = 0;
        steps[1] = 1;
        if (steps[n] == 0) {
            steps[n] = climbStairs(n - 1) + climbStairs(n - 2);
        }
        return steps[n];
    }

    public static int climbStairsNonRecursive(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        int[] steps = new int[n + 1];
        steps[0] = 1;
        steps[1] = 1;
        int index = 2;
        while (index <= n) {
            steps[index] = steps[index - 1] + steps[index - 2];
            index++;
        }
        return steps[n];
    }

    public static int climbStairsNonRecursiveLessMemory(int n) {
        if (n < 0) return 0;
        if (n == 0 || n == 1) return 1;
        int currentMinusOne = 1;
        int currentMinusTwo = 1;
        int index = 2;
        while (index <= n) {
            int temp = currentMinusOne;
            currentMinusOne = currentMinusOne + currentMinusTwo;
            currentMinusTwo = temp;
            index++;
        }
        return currentMinusOne;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
        System.out.println(climbStairsNonRecursive(5));
        System.out.println(climbStairsNonRecursiveLessMemory(5));
    }
}
