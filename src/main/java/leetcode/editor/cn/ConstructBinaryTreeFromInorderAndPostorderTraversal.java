//给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并
//返回这颗 二叉树 。 
//
// 
//
// 示例 1: 
//
// 
//输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//输出：[3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入：inorder = [-1], postorder = [-1]
//输出：[-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= inorder.length <= 3000 
// postorder.length == inorder.length 
// -3000 <= inorder[i], postorder[i] <= 3000 
// inorder 和 postorder 都由 不同 的值组成 
// postorder 中每一个值都在 inorder 中 
// inorder 保证是树的中序遍历 
// postorder 保证是树的后序遍历 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 738 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：从中序与后序遍历序列构造二叉树
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
        int[] in = new int[]{9, 3, 15, 20, 7};
        int[] post = new int[]{9, 15, 7, 20, 3};
        solution.buildTree(in, post);
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
        Map<Integer, Integer> indexMap;

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            int n = inorder.length;
            indexMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                indexMap.put(inorder[i], i);
            }
            return myBuildTree(inorder, postorder, 0, n - 1, 0, n - 1);
        }

        private TreeNode myBuildTree(int[] inorder, int[] postorder, int inorderLeft, int inorderRight,
                                     int postorderLeft, int postorderRight) {
            if (inorderLeft > inorderRight) {
                return null;
            }
            //后序根节点索引
            int postorderRoot = postorderRight;
            //中序根节点索引
            int inorderRoot = indexMap.get(postorder[postorderRoot]);
            //左子树数量
            int leftSubTreeSize = inorderRoot - inorderLeft;
            //创建根节点
            TreeNode root = new TreeNode(inorder[inorderRoot]);
            //递归构建左子树（每次减少一个根节点）
            root.left = myBuildTree(inorder, postorder, inorderLeft, inorderRoot - 1,
                    postorderLeft, postorderLeft + leftSubTreeSize - 1);
            //递归构建右子树
            root.right = myBuildTree(inorder, postorder, inorderRoot + 1, inorderRight,
                    postorderLeft + leftSubTreeSize, postorderRight - 1);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
