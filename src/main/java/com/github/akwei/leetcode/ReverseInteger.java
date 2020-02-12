package com.github.akwei.leetcode;

/**
 * leetcode #7
 */
public class ReverseInteger {

    public int reverse(int x) {
        return this.reverse03(x);
    }

    public int reverse03(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
            if (rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10) {
                return 0;
            }
            int tmp = rev * 10;
            int absPop = Math.abs(pop);
            if (tmp > Integer.MAX_VALUE - absPop || tmp < Integer.MIN_VALUE + absPop) {
                return 0;
            }
            rev = tmp + pop;
        }
        return rev;
    }

    public int reverse02(int x) {
        boolean negative = x < 0;
        char[] chars = Integer.toString(x).toCharArray();
        StringBuilder sb = new StringBuilder(String.valueOf(x));
        sb.reverse();
        if (negative) {
            sb.deleteCharAt(sb.length() - 1);
            sb.insert(0, '-');
        }
        long lv = Long.parseLong(sb.toString());
        if (lv < Integer.MIN_VALUE || lv > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) lv;
    }

    /**
     * 字符串反转方式1
     */
    public int reverse01(int x) {
        boolean negative = x < 0;
        char[] chars = Integer.toString(x).toCharArray();
        char[] rchars = new char[chars.length];
        int j = 0;
        int bottom = 0;
        if (negative) {
            rchars[j++] = '-';
            bottom = 1;
        }
        for (int i = chars.length - 1; i >= bottom; i--) {
            rchars[j++] = chars[i];
        }
        long lv = Long.parseLong(String.valueOf(rchars));
        if (lv < Integer.MIN_VALUE || lv > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) lv;
    }

    public static void main(String[] args) {
        ReverseInteger ri = new ReverseInteger();
        System.out.println(ri.reverse(-123));
    }
}
