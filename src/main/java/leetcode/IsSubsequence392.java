package main.java.leetcode;

public class IsSubsequence392 {
    public static void main(String[] args) {
        var solution = new IsSubsequence392();

        var smallWord = "abc";
        var longWord = "ahbgdc";
        System.out.println(solution.isSubsequence(smallWord, longWord));
        //todo: implement recursive(greedy) and dynamic solutions

    }

    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) return false;
        if(s.isEmpty()) return true;

        int sIndex = 0;
        int tIndex = 0;

        while (sIndex < s.length() && tIndex < t.length()) {
            if (s.charAt(sIndex) != t.charAt(tIndex)) {
                tIndex++;
                if(tIndex>=t.length())
                    return false;
            }
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
                tIndex++;
            }
        }
        return sIndex == s.length();
    }
}
