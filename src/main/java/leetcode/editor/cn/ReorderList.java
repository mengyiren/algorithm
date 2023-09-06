//给定一个单链表 L 的头节点 head ，单链表 L 表示为： 
//
// 
//L0 → L1 → … → Ln - 1 → Ln
// 
//
// 请将其重新排列后变为： 
//
// 
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → … 
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [1,2,3,4]
//输出：[1,4,2,3] 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[1,5,2,4,3] 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 5 * 10⁴] 
// 1 <= node.val <= 1000 
// 
// Related Topics 栈 递归 链表 双指针 👍 887 👎 0

package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;

//Java：重排链表
public class ReorderList {
    public static void main(String[] args) {
        Solution solution = new ReorderList().new Solution();
        ListNode n5 = new ListNode(5);
        ListNode n1 = new ListNode(4, n5);
        ListNode n2 = new ListNode(3, n1);
        ListNode n3 = new ListNode(2, n2);
        ListNode n4 = new ListNode(1, n3);
        solution.reorderList(n4);
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
        public void reorderList(ListNode head) {
            List<ListNode> list = new ArrayList<>();
            ListNode pre = head;
            while (pre != null) {
                list.add(pre);
                pre = pre.next;
            }
            int i = 0;
            int j = list.size() - 1;
            ListNode node = head;
            while (i < j) {
                node.next = list.get(j);
                node = node.next;
                j--;
                i++;
                node.next = list.get(i);
                node = node.next;
            }
            node.next = list.get(i);
            node = node.next;
            node.next = null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
