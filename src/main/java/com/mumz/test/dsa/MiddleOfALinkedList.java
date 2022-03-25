package com.mumz.test.dsa;

public class MiddleOfALinkedList {

    static class Node {
        int item;
        Node next;

        public Node(int item) {
            this.item = item;
        }

        public Node(
                int item,
                Node next
        ) {
            this.item = item;
            this.next = next;
        }
    }

    static class SingleLinkedList {
        private Node head;

        public void add(int item) {
            Node node = new Node(item);
            if (head == null) head = node;
            else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = node;
            }
        }

        public Node middle() {
            if (head == null) return null;
            if (head.next == null) return head;
            Node slow = head;
            Node fast = head;
            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        public boolean isPalindrome() {
            if (head == null || head.next == null) return true;

            return true;
        }
    }

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        for (int i = 5; i > 0; i--) singleLinkedList.add(i);
        System.out.println(singleLinkedList.middle().item);
    }
}
