//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯 👍 1634 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：子集
public class Subsets {
    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
        solution.subsets(new int[]{1, 2, 3});
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<Integer> value = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            backTrack(nums, res, 0);
            return res;
        }

        private void backTrack(int[] nums, List<List<Integer>> res, int index) {
            if (index == nums.length) {
                res.add(new ArrayList<>(value));
                return;
            }
            value.add(nums[index]);
            backTrack(nums,res,index+1);
            value.remove(value.size() - 1);
            backTrack(nums,res,index+1);
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
