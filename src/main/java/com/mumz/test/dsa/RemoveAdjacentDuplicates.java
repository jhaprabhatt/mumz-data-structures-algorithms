package com.mumz.test.dsa;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class RemoveAdjacentDuplicates {

    static class Content {
        char character;
        int count = 1;

        public Content(char character) {
            this.character = character;
        }
    }

    public static String removeDuplicates(
            String s,
            int k
    ) {
        if (Objects.isNull(s) || s.isBlank() || k <= 0) return s;
        char[] stringContent = s.toCharArray();
        Deque<Content> nonDuplicateContent = new ArrayDeque<>();
        for (int i = 0; i < stringContent.length; i++) {
            if (nonDuplicateContent.isEmpty() || nonDuplicateContent.peekFirst().character != stringContent[i]) {
                nonDuplicateContent.push(new Content(stringContent[i]));
            } else {
                nonDuplicateContent.peekFirst().count++;
                if (nonDuplicateContent.peekFirst().count == k)
                    nonDuplicateContent.pop();
            }
        }
        final StringBuilder sb = new StringBuilder();
        nonDuplicateContent.descendingIterator().forEachRemaining(content -> {
            for (int i = 0; i < content.count; i++)
                sb.append(content.character);
        });
        return sb.toString();
    }

    public static String removeDuplicates(String s) {
        if (Objects.isNull(s) || s.isBlank()) return s;
        char[] stringContent = s.toCharArray();
        Deque<Character> nonDuplicateContent = new ArrayDeque<>();
        for (int i = 0; i < stringContent.length; i++) {
            if (nonDuplicateContent.isEmpty() || nonDuplicateContent.peekFirst() != stringContent[i]) {
                nonDuplicateContent.push(stringContent[i]);
            } else nonDuplicateContent.pop();
        }
        final StringBuilder sb = new StringBuilder();
        nonDuplicateContent.descendingIterator().forEachRemaining(character -> sb.append(character));
        return sb.toString();
    }

    public static String removeDuplicatesInPlace(String s) {
        if (Objects.isNull(s) || s.isBlank()) return s;
        char[] stringContent = s.toCharArray();
        int top = -1;
        for (int i = 0; i < stringContent.length; i++) {
            if (top == -1 || stringContent[top] != stringContent[i]) {
                top++;
                stringContent[top] = stringContent[i];
            } else {
                top--;
            }
        }
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= top; i++) {
            sb.append(stringContent[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        /*System.out.println(removeDuplicates("abbaca"));
        System.out.println(removeDuplicates("azxxzy"));
        System.out.println(removeDuplicates("aaaaaaaa"));

        System.out.println(removeDuplicatesInPlace("abbaca"));
        System.out.println(removeDuplicatesInPlace("azxxzy"));
        System.out.println(removeDuplicatesInPlace("aaaaaaaa"));*/

//        System.out.println(removeDuplicates("abcd", 2));
        System.out.println(removeDuplicates("deeedbbcccbdaa", 3));
    }
}
