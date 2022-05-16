//给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,3]
//输出：3 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,1,1,1,2,2]
//输出：2
// 
//
// 
//提示：
//
// 
// n == nums.length 
// 1 <= n <= 5 * 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// 
//
// 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。 
// Related Topics 数组 哈希表 分治 计数 排序 👍 1439 👎 0

package leetcode.editor.cn;

import java.util.Random;

//Java：多数元素
public class MajorityElement {
    public static void main(String[] args) {
        Solution solution = new MajorityElement().new Solution();
        int i = solution.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
        System.out.println(i);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            quickSort(nums, 0, nums.length - 1);
            return nums[nums.length / 2];
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
            swap(nums, index, left);
            return partition(nums, left, right);
        }

        private int partition(int[] nums, int left, int right) {
            int tmp = nums[left];
            while (left < right) {
                while (left < right && nums[right] <= tmp) {
                    right--;
                }
                swap(nums, left, right);
                while (left < right && nums[left] >= tmp) {
                    left++;
                }
                swap(nums, left, right);
            }
            return left;
        }

        private void swap(int[] nums, int index, int left) {
            int tmp = nums[index];
            nums[index] = nums[left];
            nums[left] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
