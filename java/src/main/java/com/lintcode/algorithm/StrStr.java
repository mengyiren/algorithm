package com.lintcode.algorithm;

import org.junit.Test;

/**
 * 字符串查找
 * Created by IntelliJ IDEA.
 * User: mengyiren
 * Date: 2018/3/23
 */
public class StrStr {
    /*
     * @param source: source string to be scanned.
     * @param target: target string containing the sequence of characters to match
     * @return: a index to the first occurrence of target in source, or -1  if target is not part of source.
     */
    public int strStr(String source, String target) {
        if ("".equals(target)) {
            return 0;
        }
        if (source != null && target != null) {
            char[] s = source.toCharArray();
            char[] t = target.toCharArray();
            int count = 0;
            for (int i = 0; i < s.length; i++) {
                if (s[i] == t[count++]) {
                    if (count == t.length) {
                        return i - t.length + 1;
                    }
                } else {
                    if (count > 1) {
                        i -= 1;
                    }
                    count = 0;
                }
            }
        }
        return -1;
    }

    @Test
    public void test() {
        System.out.println(strStr("ababc", "abc"));
    }
}
