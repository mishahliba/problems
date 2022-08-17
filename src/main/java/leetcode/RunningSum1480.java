package main.java.leetcode;

public class RunningSum1480 {
    public static void main(String[] args) {
        RunningSum1480 solution = new RunningSum1480();
        int[] in = new int[]{1, 2, 3, 4};
        int[] result = solution.runningSum(in);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ",");
        }

    }

    public int[] runningSum(int[] nums) {
        int [] sums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int currentSum = 0;
            for (int j = 0; j <= i; j++) {
                currentSum+=nums[j];
            }
            sums[i]=currentSum;
        }
        return sums;
    }
}
