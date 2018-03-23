package com.lintcode.algorithm;

import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: mengyiren
 * Date: 2018/3/23
 */
public class StrStrKmp {
    public int strStr(String source, String target) {
        return 0;
    }

    public int[] next(String p) {
        int[] next = new int[p.length()];
        int k=-1,j=0;
        next[0] = -1;
        while (j < p.length() - 1) {
            if (k == -1 || p.charAt(k) == p.charAt(j)) {
                j++;
                k++;
                if (p.charAt(k) == p.charAt(j)) {
                    next[j] = next[k];
                } else {
                    next[j] = k;
                }
            } else {
                k = next[k];
            }
        }
        return next;
    }

    @Test
    public void test() {
        next("abcab");
    }
}
