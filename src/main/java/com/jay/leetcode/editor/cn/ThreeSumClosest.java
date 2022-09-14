//给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。 
//
// 返回这三个数的和。 
//
// 假定每组输入只存在恰好一个解。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,0], target = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 1000 
// -1000 <= nums[i] <= 1000 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics 数组 双指针 排序 👍 1242 👎 0

  
package com.jay.leetcode.editor.cn;

import java.util.Arrays;

public class ThreeSumClosest{
  public static void main(String[] args) {
       Solution solution = new ThreeSumClosest().new Solution();
       int [] nums = {-1, 2, 1, -4};
       int target = 1;
      System.out.println(solution.threeSumClosest(nums, target));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums); // -4 -1 1 2
        int len = nums.length;
        int ans = nums[0] + nums[1]+nums[2];
        for (int i=0; i<len-2; i++) {
            if (i>0 && nums[i] == nums[i-1]) {  // 去重1
                continue;
            }
            int l = i+1, r = len-1;
            while (l<r) {
                int temp = nums[i] + nums[l]+nums[r];
                if (temp == target) {
                    return target;
                }
                if (Math.abs(temp-target) < Math.abs(ans-target)) {
                    ans = temp;
                }
                if (temp > target) {
                    while(--r > l && nums[r] == nums[r+1]); // 去重2
                } else {
                    while(++l < r && nums[l] == nums[l-1]); // 去重3
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}