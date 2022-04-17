package com.mumz.test.leet;

public class AddTwoNumbers {

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
    }

    public static ListNode addTwoNumbers(
            ListNode l1,
            ListNode l2
    ) {
        if (l1 == null && l2 != null) return l2;
        if (l1 != null && l2 == null) return l1;

        ListNode first = l1;
        ListNode second = l2;
        int carry = 0;
        int sum = first.val + second.val + carry;
        int placeValue = sum % 10;
        carry = sum / 10;
        ListNode head = new ListNode(placeValue);
        ListNode cursor = head;

        first = first.next;
        second = second.next;
        while (first != null && second != null) {
            sum = first.val + second.val + carry;
            placeValue = sum % 10;
            carry = sum / 10;
            cursor.next = new ListNode(placeValue);

            cursor = cursor.next;
            first = first.next;
            second = second.next;
        }

        ListNode node = first != null ? first : second;
        while (node != null) {
            sum = node.val + carry;
            placeValue = sum % 10;
            carry = sum / 10;

            cursor.next = new ListNode(placeValue);
            cursor = cursor.next;
            node = node.next;
        }

        if (carry != 0) {
            cursor.next = new ListNode(carry);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode sum = addTwoNumbers(new ListNode(2, new ListNode(4, new ListNode(3))), new ListNode(5, new ListNode(6, new ListNode(4))));
        printList(sum);

        sum = addTwoNumbers(new ListNode(0), new ListNode(0));
        printList(sum);

        sum = addTwoNumbers(
                new ListNode(9,
                             new ListNode(9,
                                          new ListNode(9,
                                                       new ListNode(9,
                                                                    new ListNode(9,
                                                                                 new ListNode(9,
                                                                                              new ListNode(9)
                                                                                 )
                                                                    )
                                                       )
                                          )
                             )
                ),
                new ListNode(9,
                             new ListNode(9,
                                          new ListNode(9,
                                                       new ListNode(9)
                                          )
                             )
                )
        );
        printList(sum);
    }

    private static void printList(ListNode sum) {
        while (sum != null) {
            System.out.print(sum.val + " ");
            sum = sum.next;
        }
        System.out.println();
    }
}
