package com.ed.leetcode.Easy;

public class TwoSum_1 {

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        System.out.println(twoSum(nums, 6));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }

        }

             return result;
    }
}
