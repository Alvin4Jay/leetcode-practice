//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=10⁵ 
// 0 <= heights[i] <= 10⁴ 
// 
//
// Related Topics 栈 数组 单调栈 👍 2479 👎 0

  
package com.jay.leetcode.editor.cn;

import java.util.Stack;

public class LargestRectangleInHistogram{
  public static void main(String[] args) {
       Solution solution = new LargestRectangleInHistogram().new Solution();
      System.out.println(solution.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
        int result = 0, len = heights.length;

        int[] newArray = new int[len+2];
        System.arraycopy(heights, 0, newArray, 1, len);

        Stack<Integer> stack = new Stack<>(); // 栈顶到栈底：单调递减栈
        stack.push(0);
        for (int i=1; i< newArray.length; i++) {
            if (newArray[i] >= newArray[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && newArray[i] < newArray[stack.peek()]) {
                    int mid = stack.pop();
                    if (!stack.isEmpty()) {
                        int left = stack.peek();
                        int w = i - left -1;
                        result = Math.max(result, w * newArray[mid]);
                    }
                }
                stack.push(i);
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}