package com.github.akwei.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LeetCode13 {

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int num = 0;
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char aChar : chars) {
            if (stack.isEmpty()) {
                stack.push(aChar);
                num += map.get(aChar);
                continue;
            }
            boolean mustPop = false;
            Character prevCh = stack.peek();
            if (aChar == 'V' || aChar == 'X') {
                if (prevCh == 'I') {
                    mustPop = true;
                }
            } else if (aChar == 'L' || aChar == 'C') {
                if (prevCh == 'X') {
                    mustPop = true;
                }
            } else if (aChar == 'D' || aChar == 'M') {
                if (prevCh == 'C') {
                    mustPop = true;
                }
            }
            if (mustPop) {
                stack.pop();
                num = num + map.get(aChar) - map.get(prevCh) - map.get(prevCh);
                stack.clear();
            } else {
                stack.push(aChar);
                num += map.get(aChar);
            }
        }
        return num;
    }

    public static void main(String[] args) {
        LeetCode13 obj = new LeetCode13();
//        System.out.println(obj.romanToInt("III"));
//        System.out.println(obj.romanToInt("IV"));
//        System.out.println(obj.romanToInt("IX"));
//        System.out.println(obj.romanToInt("LVIII"));
//        System.out.println(obj.romanToInt("MCMXCIV"));
//        System.out.println(obj.romanToInt("DCXXI"));
        System.out.println(obj.romanToInt("MCDLXXVI"));
    }
}
