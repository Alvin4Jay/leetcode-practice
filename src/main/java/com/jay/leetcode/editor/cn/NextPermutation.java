//整数数组的一个 排列 就是将其所有成员以序列或线性顺序排列。 
//
// 
// 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。 
// 
//
// 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就
//是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。 
//
// 
// 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。 
// 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。 
// 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。 
// 
//
// 给你一个整数数组 nums ，找出 nums 的下一个排列。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
//
// Related Topics 数组 双指针 👍 1921 👎 0

  
package com.jay.leetcode.editor.cn;
public class NextPermutation{
  public static void main(String[] args) {
       Solution solution = new NextPermutation().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      public void nextPermutation(int[] nums) {
          if (nums == null || nums.length <= 1) {
              return;
          }

          int len = nums.length;
          int i = len-2, j = len-1, k = len-1;
          while (i>=0 && nums[i]>=nums[j]) {
              i--;
              j--;
          }
          if (i<0) {
              // 逆转[j(0), end]
              reverse(nums, 0, len-1);
              return;
          }
          while(nums[i]>=nums[k]) {
              k--;
          }
          swap(nums, i, k);
          // 逆序 [j, end];
          reverse(nums, j, len-1);
      }

//      private void reverse(int[] nums, int start, int end) {
//          for (int i = start; i<=(start+end)/2;i++) {
//              swap(nums, i, start+end-i);
//          }
//      }

      private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
      }

      private void swap(int[] nums, int i, int j) {
          int tmp = nums[i];
          nums[i] = nums[j];
          nums[j] = tmp;
      }
}
//leetcode submit region end(Prohibit modification and deletion)

}