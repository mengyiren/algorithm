package com.lintcode.algorithm;

import org.junit.Test;

import java.math.BigInteger;

/**
 * Created by IntelliJ IDEA.
 * User: mengyiren
 * Date: 2018/3/19
 */
public class TrailingZeros {
    public long trailingZeros(long n) {
        long flag = 5;
        long result = 0;
        while (n / flag != 0) {
            result += n / flag;
            flag *= 5;
        }
        return result;
    }

    @Test
    public void test() {
        System.out.println(trailingZeros(105));
    }
}
