//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[
//b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）： 
//
// 
// 0 <= a, b, c, d < n 
// a、b、c 和 d 互不相同 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// 你可以按 任意顺序 返回答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 双指针 排序 👍 1374 👎 0

  
package com.jay.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum{
  public static void main(String[] args) {
       Solution solution = new FourSum().new Solution();
      System.out.println(solution.fourSum(new int[]{-1,0,1,2,-1,-4}, -1));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return ans;
        }

         // -4 -1 -1 0 1 2
        Arrays.sort(nums);
        int len = nums.length;
        for (int i=0; i<=len-4; i++) {
            if (i>0 && nums[i] == nums[i-1]) {
                continue;
            }
            long temp = (long)nums[i] + (long)nums[i+1] +  (long)nums[i+2] + (long)nums[i+3];
            if (temp > (long)target) {
                return ans;
            }
            temp = (long)nums[i] + (long)nums[len-3] +  (long)nums[len-2] + (long)nums[len-1];
            if (temp < (long)target) {
                continue;
            }
            for (int j=i+1;j<=len-3;j++) {
                if (j>i+1 && nums[j] == nums[j-1]) {
                    continue;
                }
                temp = (long)nums[i] + (long)nums[j] + (long)nums[j+1] + (long)nums[j+2];
                if (temp > (long)target) {
                    break;
                }
                temp = (long)nums[i] + (long)nums[j] + (long)nums[len-2] + (long)nums[len-1];
                if (temp < (long)target) {
                    continue;
                }
                int l = j+1, r=len-1;
                while (l<r) {
                    long res = (long)nums[i] + (long)nums[j] + (long)nums[l] + (long)nums[r];
                    if (res == (long)target) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[l]);
                        tmp.add(nums[r]);
                        ans.add(tmp);
                        while(++l<r && nums[l] == nums[l-1]);
                        while(--r>l && nums[r] == nums[r+1]);
                    } else if (res > target) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}