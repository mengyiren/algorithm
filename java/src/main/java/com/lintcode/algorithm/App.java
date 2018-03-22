package com.lintcode.algorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public void merge(int[] nums) {
        int[] tmp = new int[nums.length];
        for (int step = 1; step < nums.length; step *= 2) {
            int left_min, left_max, right_min, right_max, next;
            for (left_min = 0; left_min < nums.length; left_min = right_max) {
                left_max = right_min = left_min + step;
                right_max = left_max + step;
                while (right_max > nums.length) {
                    right_max = nums.length;
                }
                next = 0;//初始化tmp数组起始位置
                while (left_min < left_max && right_min < right_max) {
                    tmp[next++] = nums[left_min] > nums[right_min] ? nums[right_min++] : nums[left_min++];
                }
                while (left_min < left_max && right_min <= nums.length) {
                    nums[--right_min] = nums[--left_max];
                }
                while (next > 0) {
                    nums[--right_min] = tmp[--next];
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test() {
        merge(new int[]{1, 2, 3, 4, 5, 6, 8, 9, 10, 7});
    }
}
