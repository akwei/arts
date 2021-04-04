package com.github.akwei.me.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BaseSort {
    public static void exchange(int[] arr, int i, int k) {
        int tmp = arr[i];
        arr[i] = arr[k];
        arr[k] = tmp;
    }

    public static boolean less(int a, int b) {
        return a < b;
    }

    public void printlnArr(int[] arr) {
        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
    }
}
