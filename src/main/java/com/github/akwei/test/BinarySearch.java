package com.github.akwei.test;

public class BinarySearch {

    public static int find(int[] arr, int a) {
        int maxIdx = arr.length - 1;
        int minIdx = 0;
        while (true) {
            int midIdx = (maxIdx + minIdx) / 2;
            if (arr[midIdx] == a) {
                return midIdx;
            }
            if (arr[midIdx] > a) {
                maxIdx = midIdx;
                continue;
            }
            if (arr[midIdx] < a) {
                minIdx = midIdx;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};
        System.out.println(BinarySearch.find(arr, 7));
    }


}
