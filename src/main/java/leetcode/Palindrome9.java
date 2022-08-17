package main.java.leetcode;

public class Palindrome9 {
    public static void main(String[] args) {

        Palindrome9 p = new Palindrome9();
  //      boolean isPalindrome = p.isPalindrome(11311);
//        System.out.println(isPalindrome);
        System.out.println(p.approachWithoutString(131));
    }

    public boolean isPalindrome(int x) {
        String[] chars = String.valueOf(x).split("");
        for (int i = 0; i <= chars.length / 2; i++) {
            String left = chars[i];
            String right = chars[chars.length - i - 1];
            if (!left.equals(right))
                return false;
        }
        return true;
    }

    public boolean approachWithoutString(int x) {
        int reversed = 0, remainder, original = x;
        while(x!=0){
            remainder = x%10;
            reversed = reversed * 10 + remainder;
            x = x/10;
        }
        return reversed == original;
    }
}

