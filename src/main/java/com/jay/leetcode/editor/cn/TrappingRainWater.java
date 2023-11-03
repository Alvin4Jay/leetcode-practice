//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
//
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 4424 👎 0

  
package com.jay.leetcode.editor.cn;

import java.util.Stack;

public class TrappingRainWater{
  public static void main(String[] args) {
       Solution solution = new TrappingRainWater().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      public int trap(int[] height) {
          int result = 0, len = height.length;
          Stack<Integer> stack = new Stack<>(); // 栈顶到栈底：递增栈
          stack.push(0);

          for (int i=1; i<len; i++) {
              if (height[i] <= height[stack.peek()]) {
                  stack.push(i);
              } else {
                  while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                      int mid = stack.pop();
                      if (!stack.isEmpty()) {
                          int left = stack.peek();
                          int h = Math.min(height[left], height[i]) - height[mid]; // >= 0
                          int w = i - left - 1;
                          int s = h * w;
                          if (s > 0) {
                              result += s;
                          }
                      }
                  }
                  stack.push(i);
              }
          }

          return result;
      }

      public int trap2(int[] height) {
          int result = 0, len = height.length;

          // 预处理，求取i左右两侧最大值
          int[] leftMax = new int[len];
          leftMax[0] = height[0];
          for (int i=1; i<len; i++) {
              leftMax[i] = Math.max(leftMax[i-1], height[i]);
          }
          int[] rightMax = new int[len];
          rightMax[len-1] = height[len-1];
          for (int i=len-2; i>=0; i--) {
              rightMax[i] = Math.max(rightMax[i+1], height[i]);
          }

          for (int i=0; i<len; i++) {
              if (i==0 || i == len-1) {
                  continue;
              }
              int h = Math.min(leftMax[i], rightMax[i]) - height[i];
              if (h > 0) {
                  result += h;
              }
          }
          return result;
      }


    public int trap3(int[] height) {
        int result = 0, len = height.length;
        for (int i=0; i<len; i++) {
            if (i ==0 || i == len-1) {
                continue;
            }

            int leftMax = height[i];
            for (int j=i; j>=0; j--) {
                leftMax = Math.max(leftMax, height[j]);
            }
            int rightMax = height[i];
            for (int j=i; j<len; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }

            int h = Math.min(leftMax, rightMax) - height[i];
            if (h > 0) {
                result += h;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}