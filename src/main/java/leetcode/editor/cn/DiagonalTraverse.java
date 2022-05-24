//给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,4,7,5,3,6,8,9]
// 
//
// 示例 2： 
//
// 
//输入：mat = [[1,2],[3,4]]
//输出：[1,2,3,4]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 10⁴ 
// 1 <= m * n <= 10⁴ 
// -10⁵ <= mat[i][j] <= 10⁵ 
// 
// Related Topics 数组 矩阵 模拟 👍 297 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Java：对角线遍历
public class DiagonalTraverse {
    public static void main(String[] args) {
        Solution solution = new DiagonalTraverse().new Solution();
        solution.findDiagonalOrder(new int[][]{{2, 3}});
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findDiagonalOrder(int[][] mat) {
            if (mat == null || mat.length == 0) {
                return new int[0];
            }
            int m = mat.length;
            int n = mat[0].length;
            int[] result = new int[m * n];
            int k = 0;
            List<Integer> intermediate = new ArrayList<>();
            for (int i = 0; i < m + n - 1; i++) {
                intermediate.clear();
                int x = i < n ? 0 : i - n + 1;
                int y = i - x;
                while (y >= 0 && x < m) {
                    intermediate.add(mat[x][y]);
                    x++;
                    y--;
                }
                if (i % 2 == 0) {
                    Collections.reverse(intermediate);
                }
                for (int j = 0; j < intermediate.size(); j++) {
                    result[k++] = intermediate.get(j);
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
