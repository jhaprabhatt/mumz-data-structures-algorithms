package com.mumz.test.misc;

public class Quicksort {

    private static void quickSort(int[] items) {
        if (items == null || items.length == 0) return;
        int low = 0, high = items.length, mid = 0;
        quickSort(low, high, items);
    }

    private static void quickSort(
            int low,
            int high,
            int[] items
    ) {
        if (low < high) {
            int mid = partition(low, high, items);
            quickSort(low, mid - 1, items);
            quickSort(mid + 1, high, items);
        }
    }

    private static int partition(
            int low,
            int high,
            int[] items
    ) {
        int j = high;
        for (int i = low + 1; i < high; i++) {
            if (items[low] <= items[i]) {
                j--;
                swap(i, j, items);
            }
        }
        swap(low, j - 1, items);
        return (j - 1);
    }

    private static void swap(
            int low,
            int high,
            int[] items
    ) {
        int temp = items[low];
        items[low] = items[high];
        items[high] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{5, 2, 3, 1};
        quickSort(array);
        for (int i : array) {
            System.out.printf(i + " ");
        }
        System.out.println();
        array = new int[]{5, 1, 1, 2, 0, 0};
        quickSort(array);
        for (int i : array) {
            System.out.printf(i + " ");
        }
    }
}
