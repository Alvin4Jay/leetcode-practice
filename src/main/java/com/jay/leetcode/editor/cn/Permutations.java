//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 回溯 👍 2249 👎 0

  
package com.jay.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Permutations{
  public static void main(String[] args) {
       Solution solution = new Permutations().new Solution();
      List<List<Integer>> permute = solution.permute(new int[]{1, 2, 3});
      System.out.println(permute);
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      public List<List<Integer>> permute(int[] nums) {
          List<List<Integer>> ans = new ArrayList<>();
          if (nums == null || nums.length == 0) {
              return ans;
          }
          List<Integer> path = new ArrayList<>();
          int len = nums.length;
          boolean[] used = new boolean[len];
          backtrack(ans, nums, len, 0, path, used);
          return ans;
      }

      /**
       * 回溯
       * @param ans 结果
       * @param nums  数组
       * @param len 数组长度
       * @param depth 当前深度
       * @param path 路径
       * @param used
       */
      private void backtrack(List<List<Integer>> ans, int[] nums, int len, int depth,
                             List<Integer> path, boolean[] used) {
          if (depth == nums.length) {
              ans.add(new ArrayList<>(path));
              return;
          }
          for (int i = 0; i<len; i++) {
              if (used[i]) {
                  continue;
              }
              path.add(nums[i]);
              used[i] = true;
              backtrack(ans, nums, len, depth+1, path, used);
              path.remove(path.size()-1);
              used[i] = false;
          }
      }
}
//leetcode submit region end(Prohibit modification and deletion)

}