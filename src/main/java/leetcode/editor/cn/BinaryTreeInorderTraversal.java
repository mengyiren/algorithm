//给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1399 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：二叉树的中序遍历
public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();
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
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            dfs(root, ans);
            return ans;
        }

        private void dfs(TreeNode root, List<Integer> ans) {
            if (root == null) {
                return;
            }
            dfs(root.left, ans);
            ans.add(root.val);
            dfs(root.right, ans);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
