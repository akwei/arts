package com.github.akwei.me;

import java.util.Arrays;

public class SelectionSort {

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int k = i; k < arr.length; k++) {
                if (arr[k] < arr[i]) {
                    exchange(arr, i, k);
                }
            }
        }
    }

    public static void exchange(int[] arr, int i, int k) {
        int tmp = arr[i];
        arr[i] = arr[k];
        arr[k] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 2, 3, 9, 4, 6, 8};
        SelectionSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
