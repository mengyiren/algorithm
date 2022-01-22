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
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 1455 👎 0

package leetcode.editor.cn;

import java.util.Random;

//Java：数组中的第K个最大元素
public class P215KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new P215KthLargestElementInAnArray().new Solution();
        int[] nums = new int[]{3, 1, 2, 6, 5, 4};
        solution.findKthLargest(nums, 2);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private Random random = new Random();

        public int findKthLargest(int[] nums, int k) {
            return quickSelect(nums, 0, nums.length - 1, nums.length - k);
        }

        private int quickSelect(int[] nums, int l, int r, int index) {
            int q = randomPartition(nums, l, r);
            if (q == index) {
                return nums[q];
            } else {
                return q < index ? quickSelect(nums, q + 1, r, index) : quickSelect(nums, l, q - 1, index);
            }
        }

        private int partition(int[] nums, int l, int r) {
            int index = l + 1;
            for (int i = index; i <= r; i++) {
                if (nums[i] < nums[l]) {
                    swap(nums, i, index);
                    index++;
                }
            }
            swap(nums, l, index - 1);
            return index - 1;
        }

        private int randomPartition(int[] nums, int l, int r) {
            int random = this.random.nextInt(r - l + 1) + l;
            swap(nums, random, r);
            return partition(nums, l, r);
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
