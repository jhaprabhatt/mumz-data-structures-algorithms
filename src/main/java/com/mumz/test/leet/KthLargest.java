package com.mumz.test.leet;

public class KthLargest {



    public static int findKthLargest(
            int[] nums,
            int k
    ) {
        if (nums == null || nums.length == 0 || k <= 0) return -1;
        int low = 0, high = nums.length - 1;
        k = nums.length - k;
        return quickSelect(nums, k, low, high);
    }

    private static int quickSelect(
            int[] nums,
            int k,
            int low,
            int high
    ) {
        int partition = partition(low, high, nums);
        if (partition > k) return quickSelect(nums, k, low, partition - 1);
        else if (partition < k) return quickSelect(nums, k, partition + 1, high);
        else return nums[partition];
    }

    private static int partition(
            int low,
            int high,
            int[] nums
    ) {
        int pivot = nums[high];
        int p = low;
        for (int i = low; i < high; i++) {
            if (nums[i] <= pivot) {
                swap(i, p, nums);
                p++;
            }
        }
        swap(p, high, nums);
        return p;
    }

    private static void swap(
            int i,
            int j,
            int[] nums
    ) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3, 6, 7, 10}, 4));
        System.out.println(findKthLargest(new int[]{7, 6, 5, 4, 3, 2, 1}, 2));
        System.out.println(findKthLargest(new int[]{-1, 2, 0}, 1));
        System.out.println(findKthLargest(new int[]{-1, 2, 0}, 1));
        System.out.println(findKthLargest(new int[]{99, 99}, 1));
        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
