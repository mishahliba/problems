package main.java.leetcode;

public class ImplementStrStr28 {
    public static void main(String[] args) {

        var solution = new ImplementStrStr28();

        System.out.println(solution.strStr("mississippi", "issip"));
        System.out.println(solution.strStr("mississippi", "issipi"));
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) return -1;
        char[] haystackArray = haystack.toCharArray();
        char[] needleArray = needle.toCharArray();
        int startPointer = -1;
        int haystackPointer = 0;
        int needlePointer = 0;
        int haystackMatch = 0;
        boolean done = false;

        while (haystackPointer < haystackArray.length && needlePointer < needleArray.length) {
            if (haystackArray[haystackPointer] == needleArray[needlePointer]) {
                if (startPointer == -1) {
                    startPointer = haystackPointer;
                    haystackMatch = haystackPointer;
                }
                if (needlePointer == needleArray.length - 1) {
                    done = true;
                }
                haystackPointer++;
                needlePointer++;

            } else if (startPointer != -1) {
                haystackPointer = ++haystackMatch;
                needlePointer = 0;
                startPointer = -1;
            } else {
                haystackPointer++;
            }
        }
        return done ? startPointer : -1;
    }
}
