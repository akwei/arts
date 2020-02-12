package com.github.akwei.me;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GenDouYaMath {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        Random r = new Random(System.currentTimeMillis());
        Random opRand1 = new Random(System.currentTimeMillis());
        Random opRand2 = new Random(System.currentTimeMillis());
        while (true) {
            int a = r.nextInt(20);
            int b = r.nextInt(20);
            int c = r.nextInt(20);
            String op1;
            String op2;
            int ab;
            if (opRand1.nextInt(2) == 0) {
                op1 = "-";
                if (a < b) {
                    continue;
                }
                ab = a - b;
            } else {
                op1 = "+";
                if (a + b > 20) {
                    continue;
                }
                ab = a + b;
            }
            if (opRand2.nextInt(2) == 0) {
                op2 = "-";
                if (ab < c) {
                    continue;
                }
            } else {
                op2 = "+";
                if (ab + c > 20) {
                    continue;
                }
            }
            set.add(a + " " + op1 + " " + b + " " + op2 + " " + c + " =");
            if (set.size() == 1000) {
                break;
            }
        }
        for (String s : set) {
            System.out.println(s);
        }
    }
}
