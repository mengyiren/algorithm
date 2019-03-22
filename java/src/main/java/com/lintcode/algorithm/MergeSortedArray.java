package com.lintcode.algorithm;

/**
 * 合并排序数组
 * Created by IntelliJ IDEA.
 * User: mengyiren
 * Date: 2018/3/21
 */
public class MergeSortedArray {
    /**
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        int[] result = new int[A.length + B.length];
        int count = 0,left=0,right=0;
        while (left<A.length && right<B.length ) {
            if (A[left] > B[right]) {
                result[count++] = B[right++];
            } else {
                result[count++] = A[left++];
            }
        }
        while (left < A.length) {
            result[count++] = A[left++];
        }
        while (right < B.length) {
            result[count++] = B[right++];
        }
        return result;

    }
}
