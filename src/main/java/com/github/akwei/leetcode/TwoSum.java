package com.github.akwei.leetcode;

import java.util.Arrays;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int a = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == a) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum obj = new TwoSum();
        int[] result = obj.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(result));
    }
}
