package com.lintcode.algorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: mengyiren
 * Date: 2018/3/23
 * 移动位数 = 已匹配的字符数-对应的部分匹配值
 */
public class StrStrKmp {
    public int strStr(String source, String target) {
        if ("".equals(target)) {
            return 0;
        }
        if (source == null || target==null) {
            return -1;
        }
        int i = 0, j = 0;
        int[] next = next(target);
        while (i < source.length() && j < target.length()) {
            if (j == -1 || source.charAt(i) == target.charAt(j)) {
                j++;
                i++;
            } else {
                j = next[j];
            }
        }
        if (j == target.length()) {
            return i - j;
        } else {
            return -1;
        }
    }

    public int[] next(String p) {
        int[] next = new int[p.length()];
        int k = -1, j = 0;
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
        System.out.println(Arrays.toString(next("abab")));
    }
}
