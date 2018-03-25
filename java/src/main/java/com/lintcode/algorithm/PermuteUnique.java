package com.lintcode.algorithm;

import org.junit.Test;

import java.security.interfaces.RSAKey;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * 从第一个数开始，分别与它后面的不重复的数字交换
 * 使用编程语言来说就是交换i与j的时候，要求[i,j)中间没有与第j个数字相同的数字
 */
public class PermuteUnique {
    /*
     * @param :  A list of integers
     * @return: A list of unique permutations
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums == null) {
            return null;
        }
        if (nums.length == 0) {
            result.add(new LinkedList<>());
            return result;
        }
        List<Integer> newList = new LinkedList<>();
        for (int num : nums) {
            newList.add(num);
        }
        result.add(newList);
        int count = 0, sum = result.size();
        while (count < sum) {
            boolean canExchange = true;
            newList = result.get(count);
            for (int i = count++; i < newList.size() - 1; i++) {
                for (int j = i + 1; j < newList.size(); j++) {
                    for (int k = i; k < j; k++) {
                        if (Objects.equals(newList.get(k), newList.get(j))) {
                            canExchange = false;
                            break;
                        }
                    }
                    if (canExchange) {
                        List<Integer> list = new LinkedList<>();
                        list.addAll(newList);
                        list.set(i, newList.get(j));
                        list.set(j, newList.get(i));
                        result.add(list);
                        sum = result.size();
                    }
                }
            }
        }
        return result;
    }

    @Test
    public void test() {
        System.out.println(permuteUnique(new int[]{1, 1, 2}));
    }
}
