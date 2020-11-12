package com.github.akwei.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum1(int[] nums, int target) {
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

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        for (int num : nums) {
            int v = target - num;
            if (map.containsKey(v)) {
                return new int[]{map.get(v), i};
            }
            map.put(num, i);
            i++;
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum obj = new TwoSum();
        int[] result = obj.twoSum2(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(result));
    }
}
