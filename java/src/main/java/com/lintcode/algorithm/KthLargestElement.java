package com.lintcode.algorithm;

import org.junit.Test;

import java.util.Arrays;
import java.util.TooManyListenersException;

/**
 * 在数组中找到第 k 大的元素
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
        mergeSort(nums,  nums.length );
        System.out.println(Arrays.toString(nums));
        return nums[nums.length-k];
    }

    private void mergeSort(int[] sr, int length) {
        int[] tmp = new int[length];
        int left_min,right_max=0,right_min,left_max,next;
        for (int step =1;step<length;step*=2) {
            for (left_min=0;left_min<length-1;left_min=right_max) {
                right_min = left_max = left_min + step;
                right_max = left_max + step;
                if (right_max >= length) {
                    right_max = length;
                }
                next = 0;
                while (left_min < left_max && right_min < right_max) {
                    tmp[next++] = sr[left_min] > sr[right_min] ? sr[right_min++] : sr[left_min++];
                }
                while (left_min < left_max && right_min<=length) {
                    sr[--right_min] = sr[--left_max];
                }

                while (next > 0) {
                    sr[--right_min] = tmp[--next];
                }
            }
        }
    }


    @Test
    public void test() {
        System.out.println(kthLargestElement(10, new int[]{1,2,3,4,5,6,8,9,10,7}));
    }

}
