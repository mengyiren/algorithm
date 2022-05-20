//给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。 
//
// 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,2]
//输出："210" 
//
// 示例 2： 
//
// 
//输入：nums = [3,30,34,5,9]
//输出："9534330"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 10⁹ 
// 
// Related Topics 贪心 字符串 排序 👍 933 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：最大数
public class LargestNumber {
    public static void main(String[] args) {
        Solution solution = new LargestNumber().new Solution();
        String s = solution.largestNumber(new int[]{3, 30, 34, 5, 9});
        System.out.println(s);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String largestNumber(int[] nums) {
            int n = nums.length;
            Integer[] numsArray = new Integer[n];
            for (int i = 0; i < nums.length; i++) {
                numsArray[i] = nums[i];
            }
            Arrays.sort(numsArray, (x, y) -> {
                long sx = 10;
                long sy = 10;
                while (sx <= x) {
                    sx *= 10;
                }
                while (sy <= y) {
                    sy *= 10;
                }
                return (int) (-sy * x - y + sx * y + x);
            });
            if (numsArray[0] == 0) {
                return "0";
            }
            StringBuilder builder = new StringBuilder();
            for (Integer num : numsArray) {
                builder.append(num);
            }
            return builder.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
