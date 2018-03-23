package com.lintcode.algorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: mengyiren
 * Date: 2018/3/23
 */
public class FizzBuzz {
    /**
     * @param n: An integer
     * @return: A list of strings.
     */
    public List<String> fizzBuzz(int n) {
        List<String> result = new LinkedList<>();
        for (int i=1;i<=n;i++) {
            if (i % 15 == 0) {
                result.add("fizz buzz");
            } else if (i % 3 == 0) {
                result.add("fizz");
            } else if (i % 5 == 0) {
                result.add("buzz");
            } else {
                result.add(Integer.toString(i));
            }
        }
        return result;
    }
}
