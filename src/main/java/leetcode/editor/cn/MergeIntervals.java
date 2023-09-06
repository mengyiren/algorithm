//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
// Related Topics 数组 排序 👍 1442 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//Java：合并区间
public class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals == null || intervals.length == 0) {
                return new int[0][];
            }
            Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));
            List<int[]> merged = new ArrayList<>();
            int[] currentInterval = intervals[0];
            for (int i = 1; i < intervals.length; i++) {
                int[] interval = intervals[i];
                if (interval[0] <= currentInterval[1]) {
                    //当前区间开头小于等于上个区间的结尾，合并
                    currentInterval[1] = Math.max(currentInterval[1], interval[1]);
                } else {
                    //不需要合并，直接计入结果
                    merged.add(currentInterval);
                    currentInterval = interval;
                }
            }
            //将最后一个区间加入结果
            merged.add(currentInterval);
            return merged.toArray(new int[merged.size()][]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
