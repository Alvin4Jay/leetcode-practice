//给定一个包含红色、白色和蓝色、共 n 个元素的数组
// nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 
// 
//
// 必须在不使用库内置的 sort 函数的情况下解决这个问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,0,1]
//输出：[0,1,2]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
//
// 
//
// 进阶： 
//
// 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
//
// Related Topics 数组 双指针 排序 👍 1600 👎 0

  
package com.jay.leetcode.editor.cn;
public class SortColors{
  public static void main(String[] args) {
       Solution solution = new SortColors().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public void sortColors(int[] nums) {
//           int n0 = 0, n1=0, n2=0;
//           for (int num: nums) {
//               if (num == 0) {
//                   n0++;
//               } else if (num==1) {
//                   n1++;
//               } else {
//                   n2++;
//               }
//           }
//
//           int i=0;
//           while(n0 > 0) {
//               nums[i] = 0;
//               i++;
//               n0--;
//           }
//           while(n1 > 0) {
//               nums[i] = 1;
//               i++;
//               n1--;
//           }
//           while(n2 > 0) {
//               nums[i] = 2;
//               i++;
//               n2--;
//           }
//       }

//       public void sortColors(int[] nums) {
//           int len = nums.length;
//           int p = 0;
//           for (int i=0; i<len; i++) {
//               if (nums[i] == 0) {
//                   int temp = nums[p];
//                   nums[p] = nums[i];
//                   nums[i] = temp;
//                   p++;
//               }
//           }
//           for (int i=p; i<len; i++) {
//               if (nums[i] == 1) {
//                   int temp = nums[p];
//                   nums[p] = nums[i];
//                   nums[i] = temp;
//                   p++;
//               }
//           }
//       }

      public void sortColors(int[] nums) {
          int len = nums.length;
          int p0 = 0, p1=0;
          for (int i=0; i<len; i++) {
            if (nums[i] == 0) {
                int temp = nums[p0];
                nums[p0] = nums[i];
                nums[i] = temp;
                if (p0 < p1) {
                    temp = nums[p1];
                    nums[p1] = nums[i];
                    nums[i]  = temp;
                }
                p0++;
                p1++;
            } else if (nums[i] == 1) {
                int temp = nums[p1];
                nums[p1] = nums[i];
                nums[i] = temp;
                p1++;
            }
          }
      }
}
//leetcode submit region end(Prohibit modification and deletion)

}