//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。 
//
// 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。 
//
// 
//
// 示例 1： 
//
// 
//输入：num1 = "11", num2 = "123"
//输出："134"
// 
//
// 示例 2： 
//
// 
//输入：num1 = "456", num2 = "77"
//输出："533"
// 
//
// 示例 3： 
//
// 
//输入：num1 = "0", num2 = "0"
//输出："0"
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 10⁴ 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 
// Related Topics 数学 字符串 模拟 👍 550 👎 0

package leetcode.editor.cn;

import java.math.BigDecimal;

//Java：字符串相加
public class AddStrings {
    public static void main(String[] args) {
        Solution solution = new AddStrings().new Solution();
        String s = solution.addStrings("11", "234");
        System.out.println(s);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addStrings(String num1, String num2) {
            StringBuilder builder = new StringBuilder();
            int i = num1.length() - 1;
            int j = num2.length() - 1;
            int add = 0;
            while (i >= 0 || j >= 0 || add != 0) {
                int x = i >= 0 ? num1.charAt(i) - '0' : 0;
                int y = j >= 0 ? num2.charAt(j) - '0' : 0;
                int result = x + y + add;
                add = result / 10;
                builder.append(result % 10);
                i--;
                j--;
            }
            return builder.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
