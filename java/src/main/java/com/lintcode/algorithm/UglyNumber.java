package com.lintcode.algorithm;

/**
 * Created by IntelliJ IDEA.
 * User: mengyiren
 * Date: 2018/3/20
 */
public class UglyNumber {
    /**
     * @param n: An integer
     * @return: the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int num_2 = 0;
        int num_3 = 0;
        int num_5 = 0;
        for (int i = 1; i < n; i++) {
            ugly[i] = Math.min(Math.min(ugly[num_2] * 2, ugly[num_3] * 3), ugly[num_5] * 5);
            if (ugly[i] % 2 == 0) {
                num_2++;
            }
            if (ugly[i] % 3 == 0) {
                num_3++;
            }
            if (ugly[i] % 5 == 0) {
                num_5++;
            }
        }
        return ugly[n - 1];
    }
}
