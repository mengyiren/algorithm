//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 👍 2593 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：括号生成
public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        List<String> list = solution.generateParenthesis(3);
        System.out.println(list);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList<>();
            backTrack(ans, new StringBuilder(), 0, 0, n);
            return ans;
        }

        private void backTrack(List<String> ans, StringBuilder builder, int left, int right, int n) {
            if (builder.length() == n * 2) {
                ans.add(builder.toString());
                return;
            }
            if (left < n) {
                builder.append("(");
                backTrack(ans, builder, left + 1, right, n);
                builder.deleteCharAt(builder.length() - 1);
            }
            if (right < left) {
                builder.append(")");
                backTrack(ans, builder, left, right + 1, n);
                builder.deleteCharAt(builder.length() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
