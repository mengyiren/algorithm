//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 1610 👎 0

package leetcode.editor.cn;

import java.util.Random;

//Java：数组中的第K个最大元素
public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            int n = nums.length;
            int pos = partition(nums, 0, n - 1);
            if (n - pos > k) {
                quickSort(nums, pos + 1, n - 1);
            } else {
                quickSort(nums, 0, pos - 1);
            }
            return nums[n - k];
        }

        private void quickSort(int[] nums, int left, int right) {
            if (left < right) {
                int pos = partition(nums, left, right);
                quickSort(nums, left, pos - 1);
                quickSort(nums, pos + 1, right);
            }
        }

        private int partition(int[] nums, int left, int right) {
            int index = new Random().nextInt(right - left + 1) + left;
            swap(nums, left, index);
            int tmp = nums[left];
            while (left < right) {
                while (left < right && (nums[right] > nums[left] || (nums[left] == tmp && nums[right] == tmp))) {
                    right--;
                }
                swap(nums, left, right);
                while (left < right && nums[left] < nums[right]) {
                    left++;
                }
                swap(nums, left, right);
            }
            return left;
        }

        private void swap(int[] nums, int left, int right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
