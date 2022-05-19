//给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
//输出：3
//解释：长度最长的公共子数组是 [3,2,1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 100 
// 
// Related Topics 数组 二分查找 动态规划 滑动窗口 哈希函数 滚动哈希 👍 707 👎 0

package leetcode.editor.cn;

//Java：最长重复子数组
public class MaximumLengthOfRepeatedSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumLengthOfRepeatedSubarray().new Solution();
        int i = solution.findLength(new int[]{0, 0, 0, 0, 1}, new int[]{1, 0, 0, 0, 0});
        System.out.println(i);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int max = 0;

        public int findLength(int[] nums1, int[] nums2) {
            return nums1.length < nums2.length ? findMax(nums1, nums2) : findMax(nums2, nums1);
        }

        private int findMax(int[] nums1, int[] nums2) {
            for (int i = 1; i <= nums1.length; i++) {
                max = Math.max(max, maxLen(nums1, 0, nums2, nums2.length - i, i));
            }
            for (int i = nums1.length + 1; i <= nums2.length; i++) {
                max = Math.max(max, maxLen(nums1, 0, nums2, nums2.length - i, nums1.length));
                if (max >= nums1.length) {
                    break;
                }
            }
            for (int i = 1; i < nums1.length; i++) {
                max = Math.max(max, maxLen(nums1, i, nums2, 0, nums1.length - i));
                if (max >= nums1.length - i) {
                    break;
                }
            }
            return max;
        }

        private int maxLen(int[] nums1, int start1, int[] nums2, int start2, int len) {
            int count = 0;
            int maxLen = 0;
            while (len > 0) {
                if (nums1[start1] == nums2[start2]) {
                    count++;
                } else if (count > 0) {
                    maxLen = Math.max(count, maxLen);
                    count = 0;
                }
                start1++;
                start2++;
                len--;
            }
            return Math.max(maxLen, count);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
