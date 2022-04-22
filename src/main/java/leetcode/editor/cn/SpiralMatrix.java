//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 矩阵 模拟 👍 1070 👎 0

package leetcode.editor.cn;

import javax.swing.plaf.SliderUI;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

//Java：螺旋矩阵
public class SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();
        int[][] nums = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        List<Integer> list = solution.spiralOrder(nums);
        System.out.println(list);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> ans = new ArrayList<>();
            int top = 0;
            int left = 0;
            int bottom = matrix.length - 1;
            int right = matrix[0].length - 1;
            while (left <= right && top <= bottom) {
                for (int row = left; row <= right; row++) {
                    ans.add(matrix[top][row]);
                }
                for (int column = top + 1; column <= bottom; column++) {
                    ans.add(matrix[column][right]);
                }
                if (left < right && top < bottom) {

                    for (int row = right - 1; row >= left; row--) {
                        ans.add(matrix[bottom][row]);
                    }
                    for (int column = bottom - 1; column > top; column--) {
                        ans.add(matrix[column][left]);
                    }
                }
                left++;
                top++;
                right--;
                bottom--;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
