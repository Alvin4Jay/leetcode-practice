//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics 并查集 数组 哈希表 👍 1675 👎 0

  
package com.jay.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence{
  public static void main(String[] args) {
       Solution solution = new LongestConsecutiveSequence().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
      public int longestConsecutive2(int[] nums) {
          if (nums == null || nums.length == 0) {
              return 0;
          }

          Arrays.sort(nums); // 排序 O(NlgN) O(1)
          int ans = 1, cur = 1;
          for (int i = 1; i < nums.length; i++) {
              if (nums[i] - nums[i - 1] == 1) { // 满足
                  cur = cur + 1;
                  ans = Math.max(ans, cur);
              } else if (nums[i] == nums[i - 1]) { // 相等跳过
                  continue;
              } else { // 复位
                  cur = 1;
              }
          }
          return ans;
      }

      public int longestConsecutive(int[] nums) { // O(N) O(N)
          if (nums == null || nums.length == 0) {
              return 0;
          }

          Set<Integer> set = new HashSet<>(); // hash用于O(1)查找
          for (int num : nums) {
              set.add(num);
          }

          int ans = 1;
          for (int num : nums) {
              // 精髓：不存在前驱数num-1才进入查找序列；否则会在后续num-1中查找序列，同样会找到当前num，此处跳过
              if (!set.contains(num - 1)) {
                  int count = 1;
                  int v = num;
                  while (set.contains(v + 1)) { // 查找连续序列
                      count++;
                      v++;
                  }
                  ans = Math.max(ans, count); // 一次查找完成，计算最大值
              }
          }
          return ans;
      }
  }
//leetcode submit region end(Prohibit modification and deletion)

}