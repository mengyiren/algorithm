//有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
// 
//
// 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新
//排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// s 仅由数字组成 
// 
// Related Topics 字符串 回溯 👍 896 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：复原 IP 地址
public class RestoreIpAddresses {
    public static void main(String[] args) {
        Solution solution = new RestoreIpAddresses().new Solution();
        List<String> list = solution.restoreIpAddresses("101023");
        System.out.println(list);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> result = new ArrayList<>();

        public List<String> restoreIpAddresses(String s) {
            int n = s.length();
            if (n <= 12) {
                backTrack(s, 0, new ArrayList<String>());
            }
            return result;
        }

        private void backTrack(String s, int start, List<String> track) {
            if (start == s.length() && track.size() == 4) {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < track.size(); i++) {
                    if (i == 0) {
                        builder.append(track.get(i));
                    } else {
                        builder.append(".").append(track.get(i));
                    }
                }
                result.add(builder.toString());
                return;
            }
            for (int i = start; i < start + 3 && i < s.length(); i++) {
                if (i > start && s.charAt(start) == '0') {
                    continue;
                }
                if (s.length() - i > 3 * (4 - track.size())) {
                    continue;
                }
                String str = s.substring(start, i + 1);
                int t = Integer.parseInt(str);
                if (t > 255) {
                    continue;
                }
                track.add(str);
                backTrack(s, i + 1, track);
                track.remove(track.size() - 1);
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
