package com.github.akwei.me.sort;

import org.junit.Test;

public class SortTest extends BaseSort {

    @Test
    public void testPartition0() {
        int[] a = {5, 9, 8, 2, 7, 0, 4, 6, 3, 1};
        partition0(a, 0, a.length - 1);
        printlnArr(a);
    }

    @Test
    public void fastSort() {
        int[] a = {5, 1, 2, 3, 9, 4, 6, 8};
        fastSortFunc(a);
        printlnArr(a);
    }

    private static int partition(int[] a, int lo, int hi) {
        int flag = a[hi];
        int i = lo;
        for (int j = lo; j <= hi; j++) {
            if (a[j] < flag) {
                if (i != j) {
                    exchange(a, i, j);
                }
                i++;
            }
        }
        exchange(a, i, hi);
        return i;
    }

    private static int partition0(int[] a, int lo, int hi) {
        int i = lo + 1;
        int j = hi;
        int v = a[lo];
        while (true) {
            while (a[i] < v) {
                i++;
            }
            while (a[j] > v) {
                j--;
            }
            if (i >= j) {
                break;
            }
            exchange(a, i, j);
        }
        exchange(a, lo, j);
        return j;
    }

    private static void fastSortFunc(int[] a) {
        innerFastSortFunc(a, 0, a.length - 1);
    }

    private static void innerFastSortFunc(int[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int p = partition(a, lo, hi);
        innerFastSortFunc(a, lo, p - 1);
        innerFastSortFunc(a, p + 1, hi);
    }

    @Test
    public void mergeSort() {
        int[] a = {5, 1, 2, 3, 9, 4, 6, 8};
        mergeSortFunc(a);
        printlnArr(a);
    }

    public static void mergeSortFunc(int[] a) {
        int mid = (a.length - 1) / 2;
        int[] tmpArr = new int[a.length];
        mergeSortSub(a, tmpArr, 0, mid);
        mergeSortSub(a, tmpArr, mid + 1, a.length - 1);
        merge(a, tmpArr, 0, mid, a.length - 1);
    }

    private static void mergeSortSub(int[] a, int[] tmpArr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        mergeSortSub(a, tmpArr, lo, mid);
        mergeSortSub(a, tmpArr, mid + 1, hi);
        merge(a, tmpArr, lo, mid, hi);
    }

    private static void merge(int[] a, int[] tmpArr, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                tmpArr[k] = a[j++];
                continue;
            }
            if (j > hi) {
                tmpArr[k] = a[i++];
                continue;
            }
            if (less(a[i], a[j])) {
                tmpArr[k] = a[i++];
                continue;
            }
            tmpArr[k] = a[j++];
        }
        System.arraycopy(tmpArr, lo, a, lo, hi - lo + 1);
    }
}
