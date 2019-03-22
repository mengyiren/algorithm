package com.lintcode.algorithm;

import org.junit.Test;

/**
 * 统计数字
 * Created by IntelliJ IDEA.
 * User: mengyiren
 * Date: 2018/3/20
 */
public class DigitCounts {
    /*
     * @param : An integer
     * @param : An integer
     * @return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        if (k == 0 && n == 0) {
            return 1;
        }
        int tmp = n;
        int count = 0;
        int pow = 1;//当前位置，个是1，十是10
        while (tmp != 0) {
            int digit = tmp % 10;//当前位置上的数字
            if (digit < k) {
                //当前位置上的数字小于k，数字出现的次数等于当前高位*当前位置
                count += tmp / 10 * pow;
            } else if (digit == k) {
                //当前位置上的数字等于k，数字出现的次数等于当前高位*当前位置+当前低位+1
                count += tmp / 10 * pow + n % pow + 1;
            } else {
                //防止k=0和tmp/10=0这种特殊情况出现
                if (!(k == 0 && tmp / 10 == 0)) {
                    //当前位置上的数字大于k，数字出现的次数等于（当前高位+1）*当前位置
                    count += (tmp / 10 + 1) * pow;
                }
            }
            tmp /= 10;
            pow *= 10;
        }
        return count;
    }

    @Test
    public void test() {
        System.out.println(digitCounts(0, 19));
    }
}
