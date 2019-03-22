package com.lintcode.algorithm;

import org.junit.Test;

/**
 * 旋转字符
 * Created by IntelliJ IDEA.
 * User: mengyiren
 * Date: 2018/3/22
 */
public class RotateString {
    /**
     * @param str:    An array of char
     * @param offset: An integer
     */
    public void rotateString(char[] str, int offset) {
        if (str.length == 2) {
            System.out.println("");
            return;
        }
        if (offset > str.length) {
            offset = offset % str.length;
        }
        char[] tmp = new char[offset];
        int i = str.length - 1, j = 0;
        while (j < offset) {
            tmp[j++] = str[i--];
        }
        i = str.length - 1;
        j = str.length - offset - 1;
        while (j >= 0) {
            str[i--] = str[j--];
        }
        i = offset;
        j = 0;
        while (i > 0) {
            str[j++] = tmp[--i];
        }
        for (i = 0; i < str.length; i++) {
            System.out.print(str[i]);
        }
    }

    @Test
    public void test() {
        rotateString(new char[]{'a','b'}, 1);
    }
}
