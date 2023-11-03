//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 6294 👎 0

  
package com.jay.leetcode.editor.cn;
public class LongestPalindromicSubstring{
  public static void main(String[] args) {
       Solution solution = new LongestPalindromicSubstring().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      // 中心扩散法
      public String longestPalindrome(String s) {
          if (s.length() <= 1) {
              return s;
          }

          int l = 0, r = 0;
          int len = s.length(), maxStart = 0, maxLen = 1, tempLen = 1;
          for (int i = 0; i < len; i++) { // i表示中心
              l = i - 1;
              r = i + 1;
              while (l >= 0 && s.charAt(l) == s.charAt(i)) { // 1.往左找与s.charAt(i)相等的数据
                  tempLen++;
                  l--;
              }
              while (r < len && s.charAt(r) == s.charAt(i)) {// 2.往右找与s.charAt(i)相等的数据
                  tempLen++;
                  r++;
              }
              while (l >= 0 && r < len && s.charAt(l) == s.charAt(r)) { // 3.左右扩散，找s.charAt(l) == s.charAt(r)的数据
                  tempLen += 2;
                  l--;
                  r++;
              }
              if (tempLen > maxLen) {
                  maxLen = tempLen;
                  maxStart = l + 1;
              }
              tempLen = 1;   // 下一轮
          }
          // 起始位置，结束位置(不包含)
          return s.substring(maxStart, maxStart + maxLen);
      }

      // 动态规划法
      public String longestPalindrome2(String s) {
          if (s.length() <= 1) {
              return s;
          }

          int len = s.length();
          int start = 0, sLen = 1;
          boolean[][] dp = new boolean[len][len]; // 动态规划
          // dp初始状态
          dp[len - 1][len - 1] = true;
          for (int i = 0; i < len - 1; i++) {
              dp[i][i] = true;
              int j = i + 1;
              dp[i][j] = s.charAt(i) == s.charAt(j);
              if (dp[i][j]) {
                  sLen = 2;
                  start = i;
              }
          }

          for (int t = 2; t <= len - 1; t++) { // 第t轮
              for (int i = 0; i <= len - 1 - t; i++) { // 每一轮的状态计算
                  int j = i + t;
                  // i+1<=j-1 => i+2<=j，dp状态转移方程
                  dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                  if (dp[i][j] && (j - i + 1) > sLen) {
                      sLen = j - i + 1;
                      start = i;
                  }
              }
          }

          return s.substring(start, start + sLen);
      }
}
//leetcode submit region end(Prohibit modification and deletion)

}