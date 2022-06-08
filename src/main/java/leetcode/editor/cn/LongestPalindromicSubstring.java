//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
// Related Topics 字符串 动态规划 👍 4688 👎 0

package leetcode.editor.cn;

//Java：最长回文子串
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        String s = solution.longestPalindrome("babad");
        System.out.println(s);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            if (s == null || s.length() < 1) {
                return "";
            }
            char[] chars = s.toCharArray();
            int start = 0;
            int maxLen = 0;
            for (int i = 0; i < s.length(); i++) {
                int len1 = expend(chars, i, i);
                int len2 = expend(chars, i, i + 1);
                int len = Math.max(len1, len2);
                if (maxLen < len) {
                    maxLen = len;
                    start = i - (maxLen-1) / 2;
                }
            }
            return s.substring(start, start + maxLen);
        }

        private int expend(char[] chars, int left, int right) {
            while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
                left--;
                right++;
            }
            return right - left - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
