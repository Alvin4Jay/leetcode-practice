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
//
// Related Topics 数组 排序 👍 1676 👎 0

  
package com.jay.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals{
    // https://leetcode.jp/leetcode-56-merge-intervals-%E8%A7%A3%E9%A2%98%E6%80%9D%E8%B7%AF%E5%88%86%E6%9E%90/
    /**
     * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
     *
     * 示例 1：
     *
     * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
     * 输出：[[1,6],[8,10],[15,18]]
     * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     * 示例 2：
     *
     * 输入：intervals = [[1,4],[4,5]]
     * 输出：[[1,5]]
     * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
     * 提示：
     *
     * 1 <= intervals.length <= 10^4
     * intervals[i].length == 2
     * 0 <= starti <= endi <= 10^4
     * @param args
     */
  public static void main(String[] args) {
       Solution solution = new MergeIntervals().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 0) {
            return null;
        }

        // 排序
        Arrays.sort(intervals, (x1, x2) -> (x1[0]-x2[0]));

        List<int[]> list = new ArrayList<>();
        int[] pre = intervals[0];
        for (int i=1; i<intervals.length; i++) {
            int[] current = intervals[i];
            if (current[0] > pre[1]) {
                list.add(pre);
                pre = current;
            } else if (current[1] <= pre[1]) {
                continue;
            } else {
                pre[1] = current[1];
            }
        }
        list.add(pre);
        int[][] ans = new int[list.size()][2];
        int i = 0;
        for (int[] a : list) {
            ans[i] = a;
            i++;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}