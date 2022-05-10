//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
//
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1581 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：从前序与中序遍历序列构造二叉树
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        int[] pre = new int[]{3, 9, 20, 15, 7};
        int[] in = new int[]{9, 3, 15, 20, 7};
        solution.buildTree(pre, in);
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
        private Map<Integer, Integer> indexMap;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int n = preorder.length;
            indexMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                indexMap.put(inorder[i], i);
            }
            return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
        }

        private TreeNode myBuildTree(int[] preorder, int[] inorder, int preorderLeft, int preorderRight,
                                     int inorderLeft, int inorderRight) {
            if (preorderLeft > preorderRight) {
                return null;
            }
            //前序遍历根节点
            int preorderRoot = preorderLeft;
            //中序遍历根节点
            int inorderRoot = indexMap.get(preorder[preorderRoot]);
            //建立根节点
            TreeNode root = new TreeNode(preorder[preorderRoot]);
            //左子树节点数目
            int leftSubTreeSize = inorderRoot - inorderLeft;
            //递归构造左子树，并连接根节点
            //前序遍历从左边界+1开始的leftSubTreeSize个元素对应了中序遍历中左边界开始到根节点-1开始的节点序列
            root.left = myBuildTree(preorder, inorder, preorderLeft + 1,
                    leftSubTreeSize + preorderLeft, inorderLeft, inorderRoot - 1);
            //递归构造右子树
            root.right = myBuildTree(preorder, inorder, preorderLeft + leftSubTreeSize + 1, preorderRight, inorderRoot + 1, inorderRight);
            return root;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
