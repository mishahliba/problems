package main.java.leetcode;

public class PivotIndex724 {
    public static void main(String[] args) {
        PivotIndex724 solution = new PivotIndex724();
        int[] input = new int[]{-1,-1,0,1,1,0};
        int pivotIndex = solution.pivotIndex(input);
        System.out.println(pivotIndex);
    }

    public int pivotIndex(int[] nums) {
        int[] input = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            input[i] = nums[i];
        }
        input[nums.length] = 0;
        int moving = 0;
        while (moving != input.length - 1) {
            int left = 0;
            int right = 0;
            for (int i = 0; i < moving; i++) {
                left += input[i];
            }
            for (int i = moving+1; i < input.length; i++) {
                right += input[i];
            }
            if (left == right) return moving;
            moving++;
        }
        return -1;
    }
}
