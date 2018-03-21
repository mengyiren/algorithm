package com.lintcode.algorithm;

import org.junit.Test;

import java.util.Arrays;
import java.util.TooManyListenersException;

/**
 * Created by IntelliJ IDEA.
 * User: mengyiren
 * Date: 2018/3/20
 */
public class KthLargestElement {
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
        //归并排序
        int[] tmp = new int[nums.length];
        mergeSort(nums, tmp, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        return nums[nums.length-k];
    }

    private void mergeSort(int[] sr, int[] tr, int first, int last) {
        int mid = (first + last) >> 1;
        if (first >= last) {
            return;
        }
        mergeSort(sr, tr, first, mid);
        mergeSort(sr, tr, mid + 1, last);
        for (int i = 0; i < sr.length; i++) {
            tr[i] = sr[i];
        }
        int left = first;
        int right = mid + 1;
        for (int current = first; current <= last; current++) {
            if (left > mid) {
                //左边用尽，取右边的元素
                sr[current] = tr[right++];
            } else if (right > last) {
                //右边用尽取左边的元素
                sr[current] = tr[left++];
            } else if (tr[right] < tr[left]) {
                //右半边的元素小于左半边，取右半边的元素
                sr[current] = tr[right++];
            } else {
                //右半边的元素小于等于左半边，取左半边的元素
                sr[current] = tr[left++];
            }
        }
    }


    @Test
    public void test() {
        System.out.println(kthLargestElement(3, new int[]{9, 3, 2, 4, 8}));
    }

}
