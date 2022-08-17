package main.java.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IsomorphicString205 {
    public static void main(String[] args) {
        var solution = new IsomorphicString205();
        var a = "egg";
        var b = "iff";
        System.out.println(solution.isIsomorphic(a, b));

    }

    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;

        Map<Character, List<Integer>> hashTableA = new HashMap<>();
        Map<Character, List<Integer>> hashTableB = new HashMap<>();
        var sArray = s.toCharArray();
        var tArray = t.toCharArray();

        Map<Character, Character> symbolsHashTable = new HashMap<>();
        for (int i = 0; i < sArray.length; i++) {
            symbolsHashTable.put(sArray[i], tArray[i]);

        }

        symbolsHashTable.entrySet().forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));


        for (int i = 0; i < sArray.length; i++) {
            var symbol = sArray[i];
            hashTableA.computeIfAbsent(symbol, k -> new ArrayList()).add(i);
        }
        for (int i = 0; i < tArray.length; i++) {
            var symbol = tArray[i];
            hashTableB.computeIfAbsent(symbol, k -> new ArrayList()).add(i);
        }

        boolean allMatch = symbolsHashTable.entrySet().stream().allMatch(entry -> {
            var key = entry.getKey();
            var value = entry.getValue();

            List<Integer> positionsA = hashTableA.get(key);
            List<Integer> positionsB = hashTableB.get(value);

            boolean equal = compareArrays(positionsA, positionsB);
            return equal;
        });

        System.out.println("all match: " + allMatch);
        hashTableA.forEach((k, v) -> {
            System.out.println(k);
            v.forEach(a-> System.out.print(a + " "));
            System.out.println();
        });

        hashTableB.forEach((k, v) -> {
            System.out.println(k);
            v.forEach(a-> System.out.print(a + " "));
            System.out.println();
        });
        return allMatch;
    }

    private boolean compareArrays(List<Integer> positionsA, List<Integer> positionsB) {
        return positionsA.equals(positionsB);
    }

}
