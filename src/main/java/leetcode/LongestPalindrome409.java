package main.java.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class LongestPalindrome409 {
    public static void main(String[] args) {
        var solution = new LongestPalindrome409();
        System.out.println(solution.longestPalindrome("a"));
    }

    public int longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            map.merge(chars[i], 1, Integer::sum);
        }
        var pairsSum = map
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() % 2 == 0)
                .map(entry -> entry.getValue())
                .reduce((x, y) -> x + y).orElse(0);

        AtomicInteger i = new AtomicInteger(0);
        var oddSum = map
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() % 2 != 0)
                .map(entry -> {
                    var entryValue = entry.getValue();
                    var value = entryValue / 2;
                    var newValue = i.get() + (value * 2);
                    i.set(newValue);
                    return entry.setValue(entryValue - value);
                })
                .collect(Collectors.summingInt(Integer::intValue));

        if (oddSum > 1) oddSum = 1;
        return pairsSum + i.get() + oddSum;
    }
}
