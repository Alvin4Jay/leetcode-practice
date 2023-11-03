//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"SEE"
//输出：true
// 
//
// 示例 3： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
//
// Related Topics 数组 回溯 矩阵 👍 1608 👎 0

  
package com.jay.leetcode.editor.cn;
public class WordSearch{
  public static void main(String[] args) {
       Solution solution = new WordSearch().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      private  int[][] DIRECTION = {{-1, 0}, {0,1}, {1,0}, {0, -1}};
      private char[][] board;
      private boolean[][] visited;
      private int row;
      private int col;

      private String word;

      public boolean exist(char[][] board, String word) {
          this.board = board;
          this.row = board.length;
          this.col = board[0].length;
          this.visited = new boolean[this.row][this.col];

          this.word = word;

          for (int i=0; i< this.row; i++) {
              for (int j=0;j<this.col; j++) {
                  if (dfs(i, j, 0)) {
                      return true;
                  }
              }
          }

          return false;
      }


      private boolean dfs(int x, int y, int index) {
          if (x<0 || y<0 || x>=this.row || y >= this.col) {
              return false;
          }
          if (visited[x][y]) {
              return false;
          }

          if (index == this.word.length()-1) {
              return board[x][y] == this.word.charAt(index);
          }

          if (board[x][y] != this.word.charAt(index)) {
              return false;
          }

          visited[x][y] = true;
          // dfs
          for (int[] d : DIRECTION) {
              int xNew = x + d[0];
              int yNew = y + d[1];
              if (dfs(xNew, yNew, index+1)) {
                  return true;
              }
          }

          visited[x][y] = false;

          return false;
      }
}
//leetcode submit region end(Prohibit modification and deletion)

}