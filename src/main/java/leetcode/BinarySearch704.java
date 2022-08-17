package main.java.leetcode;

//nums = [-1,0,3,5,9,12], target = 9
//nums = [-1,0,3,5,9,12], target = 2
//[-1,0,3,5,9,12]
public class BinarySearch704 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        int[] nums1 = new int[]{5};
        int res = search(nums, 13);
        int res1 = search(nums, 9);
        int res2 = search(nums, 2);
        int res3 = search(nums1, 5);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
        System.out.println(res);
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right ) {
            int mid = (left + right) / 2;
            int current = nums[mid];
            if (current > target) {
                right = mid - 1;
            } else if (current < target) {
                left = mid + 1;
            } else if (current == target) {
                return mid;
            }
        }
        return -1;
    }

    public static int wrongSearch(int[] nums, int target) {
            int left = 0;
            int right = nums[nums.length - 1];
            while (left < right - 1) {
                int mid = (left + right / 2) - 1;
                int current = nums[mid];
                if (current > target) {
                    right = mid;
                } else if (current < target) {
                    left = mid;
                } else if (current == target) {
                    return mid;
                }
            }
            return -1;
    }
}
