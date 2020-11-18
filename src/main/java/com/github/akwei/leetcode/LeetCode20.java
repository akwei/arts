package com.github.akwei.leetcode;

import java.util.Stack;

public class LeetCode20 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            char prevCh = stack.pop();
            if (prevCh == '(' && ch == ')') {
                // 忘记了，应该是全匹配。犯错是只匹配了一个
                // return true;
                continue;
            }
            if (prevCh == '{' && ch == '}') {
                continue;
            }
            if (prevCh == '[' && ch == ']') {
                continue;
            }
            return false;
        }
        //需要判断stack为空才是对的
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        LeetCode20 obj = new LeetCode20();
        System.out.println(obj.isValid("(){}}{"));
    }
}
