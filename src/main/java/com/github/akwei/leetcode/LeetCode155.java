package com.github.akwei.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class MinStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();


    /**
     * initialize your data structure here.
     */
    public MinStack() {
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        stack.push(x);
        minStack.push(Integer.min(minStack.peek(), x));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}


class MinStack2 {

    private Stack<int[]> stack = new Stack<>();


    /**
     * initialize your data structure here.
     */
    public MinStack2() {
        stack.push(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE});
    }

    public void push(int x) {
        int[] peek = stack.peek();
        int min = Integer.min(peek[1], x);
        stack.push(new int[]{x, min});
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}

public class LeetCode155 {

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(0);
        obj.push(1);
        obj.push(0);
        System.out.println("min: " + obj.getMin());
        obj.pop();
        System.out.println("top: " + obj.top());
        System.out.println("min: " + obj.getMin());
    }
}
