//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// -5 * 10⁴ <= nums[i] <= 5 * 10⁴ 
// 
// Related Topics 数组 分治 桶排序 计数排序 基数排序 排序 堆（优先队列） 归并排序 👍 572 👎 0

package leetcode.editor.cn;

import java.util.Random;

//Java：排序数组
public class SortAnArray {
    public static void main(String[] args) {
        Solution solution = new SortAnArray().new Solution();
        int[] array = solution.sortArray(new int[]{5, 1, 1, 2, 0, 0});
        System.out.println(array);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] tmp;

        public int[] sortArray(int[] nums) {
            tmp = new int[nums.length];
            //heapSort(nums);
            mergeSort(nums, 0, nums.length - 1);
            //quickSort(nums, 0, nums.length - 1);
            return nums;
        }

        private void mergeSort(int[] nums, int left, int right) {
            if (left < right) {
                int mid = (left + right) / 2;
                mergeSort(nums, left, mid);
                mergeSort(nums, mid + 1, right);
                int i = left;
                int j = mid + 1;
                int count = 0;
                while (i <= mid && j <= right) {
                    if (nums[i] < nums[j]) {
                        tmp[count++] = nums[i++];
                    } else {
                        tmp[count++] = nums[j++];
                    }
                }
                while (i <= mid) {
                    tmp[count++] = nums[i++];
                }
                while (j <= right) {
                    tmp[count++] = nums[j++];
                }
                for (int k = 0; k < right - left + 1; k++) {
                    nums[left + k] = tmp[k];
                }
            }
        }

        private void heapSort(int[] nums) {
            int len = nums.length;
            buildHeap(nums, len);
            for (int i = len - 1; i >= 1; i--) {
                swap(nums, 0, i);
                maxHeapify(nums, 0, i);
            }
        }

        private void buildHeap(int[] nums, int len) {
            int index = (len - 1 - 1) / 2;
            for (int i = index; i >= 0; i--) {
                maxHeapify(nums, i, len);
            }
        }

        private void maxHeapify(int[] nums, int i, int len) {
            int large = i;
            int left = (i << 1) + 1;
            int right = (i << 1) + 2;
            if (left < len && nums[left] > nums[large]) {
                large = left;
            }
            if (right < len && nums[right] > nums[large]) {
                large = right;
            }
            if (large != i) {
                swap(nums, i, large);
                maxHeapify(nums, large, len);
            }
        }

        private void quickSort(int[] nums, int left, int right) {
            if (left < right) {
                int pos = randomPartition(nums, left, right);
                quickSort(nums, left, pos - 1);
                quickSort(nums, pos + 1, right);
            }
        }

        private int randomPartition(int[] nums, int left, int right) {
            int index = new Random().nextInt(right - left + 1) + left;
            swap(nums, left, index);
            return partition(nums, left, right);
        }

        private int partition(int[] nums, int left, int right) {
            int tmp = nums[left];
            while (left < right) {
                while (left < right && nums[right] >= tmp) {
                    right--;
                }
                nums[left] = nums[right];
                while (left < right && nums[left] <= tmp) {
                    left++;
                }
                nums[right] = nums[left];
            }
            nums[left] = tmp;
            return left;
        }


        private void swap(int[] nums, int a, int b) {
            int tmp = nums[a];
            nums[a] = nums[b];
            nums[b] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
