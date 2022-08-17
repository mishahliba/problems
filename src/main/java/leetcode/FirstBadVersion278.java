package main.java.leetcode;

//nums = [-1,0,3,5,9,12], target = 9
//nums = [-1,0,3,5,9,12], target = 2
//[-1,0,3,5,9,12]
public class FirstBadVersion278 {
    public static void main(String[] args) {

        int firstBad = search(2126753390);
        System.out.println(firstBad);

    }

    public static int search(int n) {
        int smallestBadVersion = n;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            boolean currentIsBad = isBadVersion(mid);
            if (currentIsBad) {
                if (smallestBadVersion > mid) {
                    smallestBadVersion = mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return smallestBadVersion;
    }

    static boolean isBadVersion(int n) {
        return n >= 1702766719;
    }

}
