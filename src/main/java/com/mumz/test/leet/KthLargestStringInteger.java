package com.mumz.test.leet;

public class KthLargestStringInteger {

    public static String KthLargestNumber(
            final String[] nums,
            int k
    ) {
        if (nums == null || nums.length == 0 || k <= 0) return "";
        int low = 0, high = nums.length - 1;
        k = nums.length - k;
        return kthLargestNumber(nums, low, high, k);
    }

    private static String kthLargestNumber(
            final String[] nums,
            int low,
            int high,
            int kthElement
    ) {
        int partition = partition(low, high, kthElement, nums);
        if (partition > kthElement)
            return kthLargestNumber(nums, low, partition - 1, kthElement);
        else if (partition < kthElement)
            return kthLargestNumber(nums, partition + 1, high, kthElement);
        else
            return nums[partition];
    }


    private static int partition(
            int low,
            int high,
            int kthElement,
            String[] nums
    ) {
        int p = low;
        for (int i = low; i < high; i++) {
            if (compareTwoStrings(nums[low], nums[i]) < 0) {
                swap(i, p, nums);
                p++;
            }
        }
        swap(p, high, nums);
        return p;
    }

    private static void swap(
            int from,
            int to,
            String[] nums
    ) {
        String temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }

    private static int compareTwoStrings(String s1,
                                         String s2) {
        return s1.length() == s2.length() ? s1.compareTo(s2) : Integer.compare(s1.length(), s2.length());
    }

    public static void main(String[] args) {
        System.out.println(KthLargestNumber(new String[]{"3", "6", "7", "10"}, 4));
        System.out.println(KthLargestNumber(new String[]{"2", "21", "12", "1"}, 3));
    }
}
