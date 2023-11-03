//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 2203 👎 0

  
package com.jay.leetcode.editor.cn;
public class KthLargestElementInAnArray{
  public static void main(String[] args) {
       Solution solution = new KthLargestElementInAnArray().new Solution();
       int[] nums = {3,2,1,5,6,4};
      int kthLargest = solution.findKthLargest(nums, 2);
      System.out.println(kthLargest);
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      public int findKthLargest(int[] nums, int k) {
          int heapSize = nums.length, len = nums.length;
          // 构建大顶堆
          buildHeap(nums);
          for (int i=len-1; i>=len-k+1; i--) {
              swap(nums, 0, heapSize-1);
              heapSize--;
              sink(nums, 0, heapSize);
          }
          return nums[0];
      }

      private void buildHeap(int[] nums) {
          int heapSize = nums.length; // 堆元素个数
          for (int k = (heapSize-2)/2; k>=0; k--) {
              sink(nums, k, heapSize);
          }
      }

      private void sink(int[] nums, int k, int heapSize) {
          while ((2*k+1) <= heapSize-1) {
              int i=2*k+1;
              if (i < heapSize-1 && nums[i]<nums[i+1]) i++; // 两个子节点取较大值
              if (nums[k] >= nums[i]) break;
              swap(nums, k, i);
              k = i;
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