//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
// Related Topics 并查集 数组 哈希表 👍 1260 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

//Java：最长连续序列
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution solution = new LongestConsecutiveSequence().new Solution();
        // TO TEST
        solution.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            int res = 0;
            for (int num : set) {
                if (!set.contains(num - 1)) {
                    int currentNum = num;
                    int currentStreak = 1;
                    while (set.contains(currentNum + 1)) {
                        currentNum++;
                        currentStreak++;
                    }
                    res = Math.max(res, currentStreak);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
