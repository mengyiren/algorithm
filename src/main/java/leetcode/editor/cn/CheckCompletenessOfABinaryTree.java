//给定一个二叉树的 root ，确定它是否是一个 完全二叉树 。 
//
// 在一个 完全二叉树 中，除了最后一个关卡外，所有关卡都是完全被填满的，并且最后一个关卡中的所有节点都是尽可能靠左的。它可以包含 1 到 2ʰ 节点之间的最
//后一级 h 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3,4,5,6]
//输出：true
//解释：最后一层前的每一层都是满的（即，结点值为 {1} 和 {2,3} 的两层），且最后一层中的所有结点（{4,5,6}）都尽可能地向左。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,2,3,4,5,null,7]
//输出：false
//解释：值为 7 的结点没有尽可能靠向左侧。
// 
//
// 
//
// 提示： 
//
// 
// 树的结点数在范围 [1, 100] 内。 
// 1 <= Node.val <= 1000 
// 
// Related Topics 树 广度优先搜索 二叉树 👍 198 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：二叉树的完全性检验
public class CheckCompletenessOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new CheckCompletenessOfABinaryTree().new Solution();
        // TO TEST
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        class Node {
            TreeNode node;
            int code;

            Node(TreeNode node, int code) {
                this.node = node;
                this.code = code;
            }
        }

        public boolean isCompleteTree(TreeNode root) {
            List<Node> nodes = new ArrayList<>();
            nodes.add(new Node(root, 1));
            int i = 0;
            while (i < nodes.size()) {
                Node node = nodes.get(i++);
                if (node.node != null) {
                    nodes.add(new Node(node.node.left, 2 * node.code));
                    nodes.add(new Node(node.node.right, 2 * node.code + 1));
                }
            }
            return nodes.size() == nodes.get(i - 1).code;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
