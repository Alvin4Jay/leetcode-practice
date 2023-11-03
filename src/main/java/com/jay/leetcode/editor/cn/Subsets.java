//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
//
// Related Topics 位运算 数组 回溯 👍 2055 👎 0

  
package com.jay.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Subsets{
  public static void main(String[] args) {
       Solution solution = new Subsets().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> state =   new ArrayList<>();
        dfs(nums, ans, state, 0);
        return ans;
    }

    private void dfs(int[] nums, List<List<Integer>> ans, List<Integer> state, int index) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(state));
            return;
        }

        state.add(nums[index]);
        dfs(nums, ans, state, index+1);

        state.remove(state.size()-1);
        dfs(nums, ans, state, index+1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}