package main.java.leetcode;

//Input: nums = [1,3,5,6], target = 5
//        Output: 2
public class SearchInsertPosition35 {
    public static void main(String[] args) {

        int[] nums = new int[]{1, 3, 5, 6};
        int[] nums1 = new int[]{1};
        int res2 = searchInsert(nums1, 0);
        int res = searchInsert(nums, 5);
        int res1 = searchInsert(nums, 7);

        System.out.println(res2);
        System.out.println(res);
        System.out.println(res1);

    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0, index = 0, right = nums.length - 1;
        while (left <= right) {
            index = (left + right) / 2;
            int current = nums[index];
            if (current == target) return index;
            if (current > target) {
                right = index - 1;
            } else if (current < target) {
                left = index + 1;
            }
        }
        if (right < 0) return 0;
        if (nums[right] > target) return right;
        else return right + 1;
    }

}
