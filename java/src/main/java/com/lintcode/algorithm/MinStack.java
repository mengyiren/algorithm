package com.lintcode.algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: mengyiren
 * Date: 2018/3/23
 */
public class MinStack {
    private int minVal;
    private List<Integer> stack;

    public MinStack() {
        this.stack = new ArrayList<>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        if (stack.size() > 0) {
            if (minVal > number) {
                minVal = number;
            }
        } else {
            minVal = number;
        }

        stack.add(number);
    }

    /*
     * @return: An integer
     */
    public int pop() {
        int result = stack.remove(stack.size() - 1);
        if (result == minVal) {
            if (stack.size() > 0) {
                minVal = stack.get(0);
                for (int i = 1; i < stack.size(); i++) {
                    if (minVal > stack.get(i)) {
                        minVal = stack.get(i);
                    }
                }
            }
        }
        return result;
    }

    /*
     * @return: An integer
     */
    public int min() {
        if (stack.size() > 0) {
            return minVal;
        }
        throw new RuntimeException("非法调用");
    }

    @Test
    public void test() {
        push(1);
        System.out.println(pop());
        push(2);
        push(3);
        System.out.println(min());
        push(1);
        System.out.println(min());
    }
}
