package com.github.akwei.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class ReverseIntegerTest {

    @Test
    public void test01() {
        ReverseInteger ri = new ReverseInteger();
        Assert.assertEquals(321, ri.reverse(123));
        Assert.assertEquals(-321, ri.reverse(-123));
        Assert.assertEquals(21, ri.reverse(120));
        Assert.assertEquals(0, ri.reverse(Integer.MAX_VALUE));
        Assert.assertEquals(0, ri.reverse(Integer.MIN_VALUE));
    }
}
