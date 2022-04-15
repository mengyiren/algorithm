//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 进阶： 
//
// 
// 你可以设计一个只使用常数额外空间的算法来解决此问题吗？ 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2,3,4,5], k = 1
//输出：[1,2,3,4,5]
// 
//
// 示例 4： 
//
// 
//输入：head = [1], k = 1
//输出：[1]
// 
//
// 
// 
//
// 提示： 
//
// 
// 列表中节点的数量在范围 sz 内 
// 1 <= sz <= 5000 
// 0 <= Node.val <= 1000 
// 1 <= k <= sz 
// 
// Related Topics 递归 链表 👍 1585 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：K 个一组翻转链表
public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new ReverseNodesInKGroup().new Solution();
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        ListNode node = solution.reverseKGroup(n1, 2);
        System.out.println(node.val);
        // TO TEST
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)


    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode pre = new ListNode(0);
            pre.next = head;
            ListNode start = pre;
            ListNode end = pre;
            while (end.next != null) {
                for (int i = 0; i < k; i++) {
                    end = end.next;
                    if (end == null) {
                        return pre.next;
                    }
                }
                ListNode tmp = end.next;
                end.next = null;
                start.next = reverse(start.next);
                while (start.next != null) {
                    start = start.next;
                }
                end = start;
                end.next = tmp;
            }
            return pre.next;
        }

        private ListNode reverse(ListNode head) {
            ListNode current = head;
            ListNode tail = null;
            while (current != null) {
                ListNode tmp = current.next;
                current.next = tail;
                tail = current;
                current = tmp;
            }
            return tail;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
