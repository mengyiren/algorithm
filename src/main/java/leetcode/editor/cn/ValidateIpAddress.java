//给定一个字符串 queryIP。如果是有效的 IPv4 地址，返回 "IPv4" ；如果是有效的 IPv6 地址，返回 "IPv6" ；如果不是上述类型的 
//IP 地址，返回 "Neither" 。 
//
// 有效的IPv4地址 是 “x1.x2.x3.x4” 形式的IP地址。 其中 0 <= xi <= 255 且 xi 不能包含 前导零。例如: “192.1
//68.1.1” 、 “192.168.1.0” 为有效IPv4地址， “192.168.01.1” 为无效IPv4地址; “192.168.1.00” 、 “1
//92.168@1.1” 为无效IPv4地址。 
//
// 一个有效的IPv6地址 是一个格式为“x1:x2:x3:x4:x5:x6:x7:x8” 的IP地址，其中: 
//
// 
// 1 <= xi.length <= 4 
// xi 是一个 十六进制字符串 ，可以包含数字、小写英文字母( 'a' 到 'f' )和大写英文字母( 'A' 到 'F' )。 
// 在 xi 中允许前导零。 
// 
//
// 例如 "2001:0db8:85a3:0000:0000:8a2e:0370:7334" 和 "2001:db8:85a3:0:0:8A2E:0370:7
//334" 是有效的 IPv6 地址，而 "2001:0db8:85a3::8A2E:037j:7334" 和 "02001:0db8:85a3:0000:000
//0:8a2e:0370:7334" 是无效的 IPv6 地址。 
//
// 
//
// 示例 1： 
//
// 
//输入：queryIP = "172.16.254.1"
//输出："IPv4"
//解释：有效的 IPv4 地址，返回 "IPv4"
// 
//
// 示例 2： 
//
// 
//输入：queryIP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
//输出："IPv6"
//解释：有效的 IPv6 地址，返回 "IPv6"
// 
//
// 示例 3： 
//
// 
//输入：queryIP = "256.256.256.256"
//输出："Neither"
//解释：既不是 IPv4 地址，又不是 IPv6 地址
// 
//
// 
//
// 提示： 
//
// 
// queryIP 仅由英文字母，数字，字符 '.' 和 ':' 组成。 
// 
// Related Topics 字符串 👍 138 👎 0

package leetcode.editor.cn;

//Java：验证IP地址
public class ValidateIpAddress {
    public static void main(String[] args) {
        Solution solution = new ValidateIpAddress().new Solution();
        String s = solution.validIPAddress("20EE:FGb8:85a3:0:0:8A2E:0370:7334");
        System.out.println(s);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String validIPAddress(String queryIP) {
            if (queryIP.chars().filter(ch -> ch == '.').count() == 3) {
                return validIpV4(queryIP);
            } else if (queryIP.chars().filter(ch -> ch == ':').count() == 7) {
                return validIpV6(queryIP);
            } else {
                return "Neither";
            }
        }

        private String validIpV6(String queryIP) {
            String[] strings = queryIP.split(":");
            if (strings.length < 8) {
                return "Neither";
            }
            String hex = "0123456789abcdefABCDEF";
            for (String string : strings) {
                int n = string.length();
                if (n < 1 || n > 4) {
                    return "Neither";
                }
                for (char ch : string.toCharArray()) {
                    if (hex.indexOf(ch) == -1) {
                        return "Neither";
                    }
                }
            }
            return "IPv6";

        }

        private String validIpV4(String queryIP) {
            String[] splits = queryIP.split("\\.");
            if (splits.length < 4) {
                return "Neither";
            }
            for (String str : splits) {
                if (str.length() == 0 || str.length() > 3) {
                    return "Neither";
                }
                if (str.charAt(0) == '0' && str.length() != 1) {
                    return "Neither";
                }
                for (char ch : str.toCharArray()) {
                    if (!Character.isDigit(ch)) {
                        return "Neither";
                    }
                }
                int i = Integer.parseInt(str);
                if (i < 0 || i > 255) {
                    return "Neither";
                }
            }
            return "IPv4";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
