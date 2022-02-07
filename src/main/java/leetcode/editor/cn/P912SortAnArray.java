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
// Related Topics 数组 分治 桶排序 计数排序 基数排序 排序 堆（优先队列） 归并排序 👍 464 👎 0

package leetcode.editor.cn;

import java.util.Random;

//Java：排序数组
public class P912SortAnArray {
    public static void main(String[] args) {
        Solution solution = new P912SortAnArray().new Solution();
        solution.sortArray(new int[]{5, 1, 1, 2, 0, 0});
        //solution.sortArray(new int[]{5, 3, 2, 1});
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private Random random = new Random();

        public int[] sortArray(int[] nums) {
            quickSort(nums, 0, nums.length - 1);
            return nums;
        }

        private void quickSort(int[] nums, int l, int r) {
            if (l < r) {
                int i = randomPartition(nums, l, r);
                quickSort(nums, l, i - 1);
                quickSort(nums, i + 1, r);
            }
        }

        private int randomPartition(int[] nums, int l, int r) {
            int index = random.nextInt(r - l + 1) + l;
            swap(nums, r, index);
            return partition(nums, l, r);
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

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
