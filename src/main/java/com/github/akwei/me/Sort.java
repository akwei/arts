package com.github.akwei.me;

public class Sort {
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int k = i; k < arr.length; k++) {
                if (arr[k] < arr[i]) {
                    exchange(arr, i, k);
                }
            }
        }
    }

    public static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int k = 0; k < a.length - 1; k++) {
                if (a[k] > a[k + 1]) {
                    int tmp = a[k];
                    a[k] = a[k + 1];
                    a[k + 1] = tmp;
                }
            }
        }
    }

    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int value = a[i];
            int k = i - 1;
            for (; k >= 0; k--) {
                if (a[k] > value) {
                    a[k + 1] = a[k];
                    continue;
                }
                break;
            }
            a[k + 1] = value;
        }
    }




    public static boolean less(int a, int b) {
        return a < b;
    }


    public static void exchange(int[] arr, int i, int k) {
        int tmp = arr[i];
        arr[i] = arr[k];
        arr[k] = tmp;
    }


    public static void main(String[] args) {
        int[] a = {5, 1, 2, 3, 9, 4, 6, 8};
//        Sort.selectionSort(a);
//        Sort.insertionSort(a);
//        Sort.mergeSort(a);
//        System.out.println(Arrays.toString(a));
//        int partition = partation(a, 0, a.length - 1);
//        System.out.println(partition);
    }


}
