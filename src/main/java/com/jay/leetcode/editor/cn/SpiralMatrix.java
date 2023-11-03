//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1468 👎 0

  
package com.jay.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix{
  public static void main(String[] args) {
       Solution solution = new SpiralMatrix().new Solution();
      System.out.println(solution.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      public List<Integer> spiralOrder(int[][] matrix) {
          int m = matrix.length, n= matrix[0].length;
          List<Integer> ans = new ArrayList<>();
          for (int i=0; i<=(n-1)/2;i++) {
              int x1=i, y1=i, x2=m-1-i, y2=n-1-i;
              if (y1==y2 && x1<x2) {
                  for (int j=x1; j<=x2;j++) {
                      ans.add(matrix[j][y1]);
                  }
                  return ans;
              }
              if (x1 == x2 && y1<=y2) {
                  for (int j=y1; j<=y2; j++) {
                      ans.add(matrix[x1][j]);
                      return ans;
                  }
              }
              for (int j=y1; j<y2;j++) {
                  ans.add(matrix[x1][j]);
              }
              if (y2 > y1) {
                  for (int j=x1; j<x2;j++) {
                      ans.add(matrix[j][y2]);
                  }
              }
              if (x2 > x1) {
                  for (int j=y2;j>y1;j--) {
                      ans.add(matrix[x2][j]);
                  }
              }
              if (y2 > y1) {
                  for (int j=x2;j>x1;j--) {
                      ans.add(matrix[j][y1]);
                  }
              }
          }
          return ans;
      }
}
//leetcode submit region end(Prohibit modification and deletion)
}
