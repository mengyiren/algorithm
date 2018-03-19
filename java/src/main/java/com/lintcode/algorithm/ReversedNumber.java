package com.lintcode.algorithm;

import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: mengyiren
 * Date: 2018/3/19
 */
public class ReversedNumber {
    int  reverseInteger(int number) {
        int bai = number / 100;
        int shi = number % 100 / 10;
        int ge = number % 10;
        return ge*100+shi*10+bai;
    }

    @Test
    public void test() {
        System.out.println(reverseInteger(900));
    }
}
