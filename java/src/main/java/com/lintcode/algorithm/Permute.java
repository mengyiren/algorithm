package com.lintcode.algorithm;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class Permute {
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums == null) {
            return result;
        }
        if (nums.length == 0) {
            result.add(new LinkedList<>());
            return result;
        }
        List<Integer> newList = new LinkedList<>();
        newList.add(nums[0]);
        result.add(newList);
        int sizeOne, sizeTwo;
        for (int i = 1; i < nums.length; i++) {
            sizeOne = result.size();
            for (int j = 0; j < sizeOne; j++) {
                sizeTwo = result.get(0).size();
                for (int k = 0; k <= sizeTwo; k++) {
                    newList = new LinkedList<>(result.get(0));
                    newList.add(k, nums[i]);
                    result.add(newList);
                }
                result.remove(0);
            }
        }
        return result;
    }

    @Test
    public void test() {
        System.out.println(permute(new int[]{1, 2, 3}));
    }
}
