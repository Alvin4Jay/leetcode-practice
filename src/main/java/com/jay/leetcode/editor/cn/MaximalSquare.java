//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：4
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [["0","1"],["1","0"]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] 为 '0' 或 '1' 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 1480 👎 0

  
package com.jay.leetcode.editor.cn;
public class MaximalSquare{
  public static void main(String[] args) {
      char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
       Solution solution = new MaximalSquare().new Solution();
      System.out.println(solution.maximalSquare(matrix));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m =matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n]; // dp[i][j] 以i、j为右下角格子的最大正方形边长，且只包含1
        int maxSize = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (i == 0 || j == 0) { // 边界
                    dp[i][j] = matrix[i][j] == '0' ? 0: 1;
                } else if (matrix[i][j] == '0') { // (i,j) 元素为0的情况
                    dp[i][j] = 0;
                } else {
                    // dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                }
                maxSize = Math.max(maxSize, dp[i][j]);
            }
        }
        return maxSize*maxSize;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}