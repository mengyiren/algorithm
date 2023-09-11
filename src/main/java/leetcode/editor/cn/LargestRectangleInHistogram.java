//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=10⁵ 
// 0 <= heights[i] <= 10⁴ 
// 
//
// Related Topics 栈 数组 单调栈 👍 2547 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new LargestRectangleInHistogram().new Solution();
        solution.largestRectangleArea(new int[]{2,1,5,6,2,3});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestRectangleArea(int[] heights) {
            int n = heights.length;
            int[] left = new int[n];
            int[] right = new int[n];
            Arrays.fill(right,n);

            Deque<Integer> monoStack = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                while (!monoStack.isEmpty() && heights[monoStack.peek()] >= heights[i]) {
                    right[monoStack.peek()] = i;
                    monoStack.pop();
                }
                left[i] = (monoStack.isEmpty() ? -1 : monoStack.peek());
                monoStack.push(i);
            }

            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, (right[i]-left[i]-1)*heights[i]);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}