package com.github.akwei.leetcode;

public class LeetCode9 {
    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }
        //<0的都不是
        if (x < 0) {
            return false;
        }
        // 余数为0的也不是，因为10  01就不行
        int v = x % 10;
        if (v == 0) {
            return false;
        }
        int t = 0;
        int tx = x;
        while (t < tx) {
            int pop = tx % 10;
            t = t * 10 + pop;
            if (t == tx) {
                return true;
            }
            tx = tx / 10;
            if (t == tx) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode9().isPalindrome(12321));
    }
}
