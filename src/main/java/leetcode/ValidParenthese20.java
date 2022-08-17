package main.java.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ValidParenthese20 {
    public static void main(String[] args) {
        ValidParenthese20 solution = new ValidParenthese20();
        System.out.println(solution.isValid("(){}}{"));
    }

    public boolean isValid(String s) {
        List<Character> in = Arrays.asList('[', '{', '(');
        List<Character> out = Arrays.asList(']', '}', ')');
        Map<Character, Character> mapping = Map.of(']', '[', '}', '{', ')', '(');
        Stack<Character> openStack = new Stack<>();

        if(s.isEmpty() || out.contains(s.charAt(0))) return false;

        char[] symbols = s.toCharArray();
        for (int i = 0; i < symbols.length; i++) {
            if (in.contains(symbols[i]))
                openStack.push(symbols[i]);
            else if (out.contains(symbols[i])) {
                if (openStack.isEmpty() || openStack.pop() != mapping.get(symbols[i]))
                    return false;
            }
        }

        return openStack.isEmpty();

    }
}
