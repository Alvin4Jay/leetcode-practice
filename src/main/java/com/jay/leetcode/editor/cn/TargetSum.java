//给你一个整数数组 nums 和一个整数 target 。 
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
//
// Related Topics 数组 动态规划 回溯 👍 1664 👎 0

  
package com.jay.leetcode.editor.cn;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TargetSum{
  public static void main(String[] args) {
       Solution solution = new TargetSum().new Solution();
      System.out.println(solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        if (Math.abs(target) > sum) {
            return 0;
        }
        if ((sum+target) % 2 == 1) {
            return 0;
        }

        int x = (sum+target)/2, y = (sum-target)/2;
        int[] dp = new int[x+1]; // dp[i]装满容量为i的背包有多少种方法
        dp[0] = 1; // 初始值
        for (int i=0; i<nums.length; i++) {
            for (int j=x; j>=nums[i]; j--) {
                // dp[i-1][j], dp[i-1][j-nums]
                dp[j] = dp[j] + dp[j-nums[i]];
            }
            for (int num : dp) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
        return dp[x];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}