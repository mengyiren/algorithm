package com.lintcode.algorithm;

import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: mengyiren
 * Date: 2018/3/19
 */
public class APlusB {
    public int aPlusB(int a, int b) {
        int t_a = a ^ b;
        int t_b = (a & b) << 1;
        int tmp = t_a;
        while (t_b != 0) {
            t_a = tmp ^ t_b;
            t_b = (tmp & t_b) << 1;
            tmp = t_a;
        }
        return t_a;
    }


    @Test
    public void test() {
        System.out.println(aPlusB(30, 50));
    }
}
