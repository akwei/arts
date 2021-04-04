package com.github.akwei.geekbang.dynamic;

public class DynamicStep {
    int countStep(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return countStep(n - 1) + countStep(n - 2);
    }
}
