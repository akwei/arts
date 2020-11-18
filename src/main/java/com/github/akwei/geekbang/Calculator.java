package com.github.akwei.geekbang;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Calculator {

    private static final Map<Character, Integer> opPriorityMap = new HashMap<>();

    static {
        opPriorityMap.put('+', 1);
        opPriorityMap.put('-', 1);
        opPriorityMap.put('*', 2);
        opPriorityMap.put('/', 2);
    }

    public BigDecimal exec(String str) {
        Stack<Character> opStack = new Stack<>();
        Stack<BigDecimal> numStack = new Stack<>();
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (isNumChar(ch)) {
                sb.append(ch);
                if (i == chars.length - 1) {
                    //到了结尾
                    numStack.push(new BigDecimal(sb.toString()));
                    sb.delete(0, sb.length());
                }
                continue;
            }
            if (sb.length() > 0) {
                numStack.push(new BigDecimal(sb.toString()));
                sb.delete(0, sb.length());
            }
            if (!isOp(ch)) {
                continue;
            }
            while (true) {
                if (opStack.isEmpty()) {
                    opStack.push(ch);
                    break;
                }
                Character prevOp = opStack.peek();
                if (isHighPriority(ch, prevOp)) {
                    opStack.push(ch);
                    break;
                }
                opPop(numStack, opStack);
            }
        }
        while (!opStack.isEmpty()) {
            opPop(numStack, opStack);
        }
        return numStack.pop();
    }

    private void opPop(Stack<BigDecimal> numStack, Stack<Character> opStack) {
        Character op = opStack.pop();
        BigDecimal num2 = numStack.pop();
        BigDecimal num1 = numStack.pop();
        numStack.push(op(num1, op, num2));
    }

    private boolean isNumChar(char ch) {
        return ch >= '0' && ch <= '9';
    }

    private boolean isOp(char ch) {
        return opPriorityMap.containsKey(ch);
    }

    private boolean isHighPriority(char op1, char op2) {
        return opPriorityMap.get(op1) > opPriorityMap.get(op2);
    }

    private BigDecimal op(BigDecimal num1, char op, BigDecimal num2) {
        switch (op) {
            case '+':
                return num1.add(num2);
            case '-':
                return num1.subtract(num2);
            case '*':
                return num1.multiply(num2);
            case '/':
                return num1.divide(num2, RoundingMode.HALF_UP);
            default:
                throw new UnsupportedOperationException(op + " not supported");
        }
    }

    public static void main(String[] args) {
        Calculator obj = new Calculator();
        BigDecimal result = obj.exec("1+20*3+2*3-50");
        System.out.println(result);
    }

//    private boolean isBracket(char ch) {
//        return false;
//    }
}
