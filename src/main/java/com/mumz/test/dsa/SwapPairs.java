package com.mumz.test.dsa;

import java.util.List;

public class SwapPairs {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {this.val = val;}

        ListNode(int val,
                 ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                   "val=" + val +
                   ", next=" + next +
                   '}';
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode swapped = swapPairs(head.next.next);
        ListNode current = head;
        ListNode next = head.next;
        current.next = null;
        next.next = current;
        current = next;

        if (current.next != null)
            current.next.next = swapped;
        return current;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode swapped = swapPairs(head);
        System.out.println(swapped);
    }
}
