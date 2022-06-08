//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 👍 1941 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Java：电话号码的字母组合
public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        List<String> strings = solution.letterCombinations("23");
        System.out.println(strings);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> result = new ArrayList<>();

        List<Character> track = new ArrayList<>();

        public List<String> letterCombinations(String digits) {
            if (digits == null || digits.length() <= 0) {
                return result;
            }
            Map<Character, String> map = new HashMap<>();
            map.put('2', "abc");
            map.put('3', "def");
            map.put('4', "ghi");
            map.put('5', "jkl");
            map.put('6', "mno");
            map.put('7', "pqrs");
            map.put('8', "tuv");
            map.put('9', "wxyz");
            backTrack(digits, new char[digits.length()], 0, map);
            return result;
        }

        private void backTrack(String digits, char[] chars, int depth, Map<Character, String> map) {
            if (depth == digits.length()) {
                result.add(new String(chars));
                return;
            }
            String s1 = map.get(digits.charAt(depth));
            for (int i = 0; i < s1.length(); i++) {
                chars[depth] = s1.charAt(i);
                backTrack(digits, chars, depth + 1, map);
                chars[depth] = ' ';
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
