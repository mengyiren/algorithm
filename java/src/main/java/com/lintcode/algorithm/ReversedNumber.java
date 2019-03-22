package com.lintcode.algorithm;

import org.junit.Test;


/**
 * 反转一个3位数
 * Created by IntelliJ IDEA.
 * User: mengyiren
 * Date: 2018/3/19
 */
public class ReversedNumber {
    int reverseInteger(int number) {
        return number % 10 * 100 + number % 100 / 10 * 10 + number / 100;
    }

    @Test
    public void test() {
        System.out.println(reverseInteger(321));
    }
}
