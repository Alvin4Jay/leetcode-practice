//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
//
// Related Topics 数组 动态规划 👍 1800 👎 0

  
package com.jay.leetcode.editor.cn;
public class PartitionEqualSubsetSum{
  public static void main(String[] args) {
       Solution solution = new PartitionEqualSubsetSum().new Solution();
      System.out.println(solution.canPartition(new int[]{1,5,11,5}));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = nums[0];
        for (int i=1; i<len; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }

        int target = sum / 2; // 背包容量
        int[] dp = new int[target+1];
        for (int i=0; i<len; i++) { // 物品
            for (int j=target; j>=nums[i]; j--) { // 背包
                dp[j] = Math.max(dp[j], dp[j-nums[i]] + nums[i]);
                if (dp[i] == target) {
                    return true;
                }
            }
        }
        return dp[target] == target;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}