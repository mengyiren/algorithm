//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。 
//
// 
//
// 示例 1: 
//
// 
//输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 
//输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 200 
// num1 和 num2 只能由数字组成。 
// num1 和 num2 都不包含任何前导零，除了数字0本身。 
// 
// Related Topics 数学 字符串 模拟 👍 924 👎 0

package leetcode.editor.cn;

//Java：字符串相乘
public class MultiplyStrings {
    public static void main(String[] args) {
        Solution solution = new MultiplyStrings().new Solution();
        String multiply = solution.multiply("1234", "567");
        System.out.println(multiply);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {
            if ("0".equals(num1) || "0".equals(num2)) {
                return "0";
            }
            int m = num1.length();
            int n = num2.length();
            int[] ans = new int[m + n];
            for (int i = m - 1; i >= 0; i--) {
                int x = num1.charAt(i) - '0';
                for (int j = n - 1; j >= 0; j--) {
                    int y = num2.charAt(j) - '0';
                    ans[i + j + 1] += x * y;
                }
            }
            for (int i = m + n - 1; i > 0; i--) {
                ans[i - 1] += ans[i] / 10;
                ans[i] %= 10;
            }
            int index = ans[0] == 0 ? 1 : 0;
            StringBuilder builder = new StringBuilder();
            while (index < m + n) {
                builder.append(ans[index]);
                index++;
            }
            return builder.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
