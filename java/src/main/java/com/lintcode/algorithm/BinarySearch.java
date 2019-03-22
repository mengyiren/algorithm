package com.lintcode.algorithm;

import org.junit.Test;

/**
 * 二分查找
 */
public class BinarySearch {
    public int binarySearch(int[] nums, int target) {
        int find = -1;
        int first = 0, last = nums.length - 1, mid = nums.length / 2;
        if (nums[first] > target || nums[last] < target) {
            return -1;
        }
        while (first <= last) {
            if (nums[mid] == target) {
                find = mid;
                break;
            } else if (nums[mid] < target) {
                first = first + 1;
            } else {
                last = last - 1;
            }
            mid = (first + last) >> 1;
        }
        while (find > 0) {
            if (nums[find--] != target) {
                return find+2;
            }
        }
        return find;
    }


    @Test
    public void test() {
        System.out.println(binarySearch(new int[]{2,6,8,13,15,17,17,18,19,20}, 15));
    }
}
