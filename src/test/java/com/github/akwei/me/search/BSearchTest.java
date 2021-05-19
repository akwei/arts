package com.github.akwei.me.search;

import org.junit.Test;

public class BSearchTest {

    @Test
    public void invoke() {

    }

    public int bSearch(int[] a, int value) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] == value) {
                return mid;
            }
            if (a[mid] > value) {
                hi = mid - 1;
                continue;
            }
            if (a[mid] < value) {
                lo = mid + 1;
            }
        }
        return -1;
    }

    public int firstBigEq(int[] a, int value) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {
                if (mid == 0 || a[mid - 1] < value) {
                    return mid;
                }
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int lastLessEq(int[] a, int value) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] <= value) {
                if (mid == 0) {
                    return mid;
                }
                if (mid == a.length - 1 || a[mid + 1] > value) {
                    return mid;
                }
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
