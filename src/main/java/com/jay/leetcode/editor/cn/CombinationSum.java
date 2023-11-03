//给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的
// 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。 
//
// candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
//
// 对于给定的输入，保证和为 target 的不同组合数少于 150 个。 
//
// 
//
// 示例 1： 
//
// 
//输入：candidates = [2,3,6,7], target = 7
//输出：[[2,2,3],[7]]
//解释：
//2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
//7 也是一个候选， 7 = 7 。
//仅有这两种组合。 
//
// 示例 2： 
//
// 
//输入: candidates = [2,3,5], target = 8
//输出: [[2,2,2,2],[2,3,3],[3,5]] 
//
// 示例 3： 
//
// 
//输入: candidates = [2], target = 1
//输出: []
// 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都 互不相同 
// 1 <= target <= 500 
// 
//
// Related Topics 数组 回溯 👍 2201 👎 0

  
package com.jay.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum{
  public static void main(String[] args) {
       Solution solution = new CombinationSum().new Solution();
       solution.combinationSum(new int[]{2,3,6,7}, 7);
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      private List<List<Integer>> ans = new ArrayList<>();

      public List<List<Integer>> combinationSum(int[] candidates, int target) {
          if (candidates == null || candidates.length == 0) {
              return ans;
          }

          Arrays.sort(candidates); // 排序是为了剪枝
          List<Integer> path = new ArrayList<>();
          backtrack(candidates, 0, path, 0, target);
          return ans;
      }

      /**
       * 回溯算法
       * @param candidates 候选数组
       * @param begin 开始搜索的位置(去重)
       * @param path 路径
       * @param curSum 当前的和
       * @param target 目标值
       */
      private void backtrack(int[] candidates, int begin, List<Integer> path, int curSum, int target) {
          // if (curSum > target) {
          //     return;
          // }
          if (curSum == target) {
              ans.add(new ArrayList<>(path));
              return;
          }
          for (int i = begin; i<candidates.length; i++) {
              if (curSum + candidates[i] > target) {
                  break;
              }
              path.add(candidates[i]);
              // System.out.println("递归之前 => " + path + "，总和 = " + (curSum + candidates[i]));
              backtrack(candidates, i, path, curSum + candidates[i], target);
              path.remove(path.size()-1);
              // System.out.println("递归之后 => " + path+ "，总和 = " + curSum);
          }
      }
}
//leetcode submit region end(Prohibit modification and deletion)

}