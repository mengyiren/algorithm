//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 栈 递归 链表 双指针 👍 1387 👎 0

package leetcode.editor.cn;

//Java：回文链表
public class PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
        // TO TEST
    }


    public class ListNode {
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
        private ListNode frontNode;

        public boolean isPalindrome(ListNode head) {
            frontNode = head;
            return recycleNode(head);
        }

        private boolean recycleNode(ListNode node) {
            if (node != null) {
                if (!recycleNode(node.next)) {
                    return false;
                }
                if (frontNode.val != node.val) {
                    return false;
                }
                frontNode = frontNode.next;
            }
            return true;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
