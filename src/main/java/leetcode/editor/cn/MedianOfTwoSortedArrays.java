//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
// Related Topics 数组 二分查找 分治 👍 5486 👎 0

package leetcode.editor.cn;

//Java：寻找两个正序数组的中位数
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if (nums1.length > nums2.length) {
                int[] tmp = nums2;
                nums2 = nums1;
                nums1 = tmp;
            }
            int m = nums1.length;
            int n = nums2.length;
            int total = (m + n + 1) / 2;
            int left = 0;
            int right = m;
            while (left < right) {
                int i = left + (right - left + 1) / 2;
                int j = total - i;
                if (nums1[i - 1] > nums2[j]) {
                    right = i - 1;
                } else {
                    left = i;
                }
            }
            int i = left;
            int j = total - i;
            int num1Left = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
            int num1Right = i == m ? Integer.MAX_VALUE : nums1[i];
            int num2Left = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
            int num2Right = j == n ? Integer.MAX_VALUE : nums2[j];
            if ((m + n) % 2 == 1) {
                return Math.max(num1Left, num2Left);
            } else {
                return (double) (Math.max(num1Left, num2Left) + Math.min(num1Right, num2Right)) / 2;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
