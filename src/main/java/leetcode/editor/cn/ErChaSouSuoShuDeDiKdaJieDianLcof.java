//给定一棵二叉搜索树，请找出其中第 k 大的节点的值。 
//
// 
//
// 示例 1: 
//
// 
//输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 
//输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 
// 1 ≤ k ≤ 二叉搜索树元素个数 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 306 👎 0

package leetcode.editor.cn;

//Java：二叉搜索树的第k大节点
public class ErChaSouSuoShuDeDiKdaJieDianLcof {
    public static void main(String[] args) {
        Solution solution = new ErChaSouSuoShuDeDiKdaJieDianLcof().new Solution();
        // TO TEST
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int ans, count;

        public int kthLargest(TreeNode root, int k) {
            count = k;
            dfs(root);
            return ans;
        }

        private void dfs(TreeNode node) {
            if (node != null) {
                dfs(node.right);
                if (count == 0) {
                    return;
                }
                if (--count == 0) {
                    ans = node.val;
                }
                dfs(node.left);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
