package com.mumz.test.dsa;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class EvaluateReversePolishNotation {

    public static int evalRPN(String[] tokens) {
        final List<String> operators = Arrays.asList(new String[]{"+", "-", "*", "/"});
        if (tokens == null || tokens.length == 0) return 0;
        Deque<Integer> stack = new ArrayDeque<>(tokens.length);
        for (int index = 0; index < tokens.length; index++) {
            String token = tokens[index];
            if (operators.contains(token)) {
                int first = stack.pop();
                int second = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(second + first);
                        break;
                    case "-":
                        stack.push(second - first);
                        break;
                    case "*":
                        stack.push(second * first);
                        break;
                    case "/":
                        stack.push(second / first);
                        break;
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        //System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }
}
