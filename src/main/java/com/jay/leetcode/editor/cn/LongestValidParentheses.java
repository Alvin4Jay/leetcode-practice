//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 10⁴ 
// s[i] 为 '(' 或 ')' 
// 
//
// Related Topics 栈 字符串 动态规划 👍 2212 👎 0

  
package com.jay.leetcode.editor.cn;
public class LongestValidParentheses{
  public static void main(String[] args) {
       Solution solution = new LongestValidParentheses().new Solution();
      System.out.println(solution.longestValidParentheses("())"));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
      // 双指针
      public int longestValidParentheses(String s) {
          int len = s.length();
          if (len <= 1) {
              return 0;
          }
          int[] dp = new int[len];
          char[] ca = s.toCharArray();
          int ans = 0;
          dp[0] = 0;
          for (int i = 1; i<len; i++) {
              if (ca[i] == '(') {
                  dp[i] = 0;
              } else {
                  if (dp[i-1] == '(') {
                      dp[i] =2;
                      if (i >= 2) {
                          dp[i] = 2 + dp[i-2];
                      }
                  } else if (dp[i-1] > 0 && i-1-dp[i-1] >=0 && dp[i-1-dp[i-1]]=='(') {
                      dp[i] = dp[i-1] + 2;
                      if (i-2-dp[i-1] >= 0) {
                          dp[i] += dp[i-2-dp[i-1]];
                      }
                  }
              }
              ans = Math.max(ans, dp[i]);
          }

          return ans;
      }

      // 动态规划
      public int longestValidParentheses2(String s) {
          if (s == null || s.length() < 2) {
              return 0;
          }

          int len = s.length(), maxLength = 0;
          char[] ca = s.toCharArray();
          int[] dp = new int[len]; // 以i结尾的子字符串[0, i]，最长有效括号的长度
          dp[0] = 0;
          for (int i=1; i<len; i++) {
              if (ca[i] == '(') {
                  dp[i] = 0;
              } else { // ca[i] = ')'
                  if (ca[i-1] == '(') { // ca[i-1] = '('
                      dp[i] = 2;
                      if (i >= 2) {
                          dp[i] = dp[i-2] + 2;
                      }
                  } else if (dp[i-1]>0 && i - dp[i-1]-1>=0 && ca[i - dp[i-1]-1] == '(') { // ca[i-1] = ')'
                      dp[i] = dp[i-1] + 2;
                      if (i - dp[i-1]-2>=0) {
                          dp[i] = dp[i] + dp[i - dp[i-1] -2];
                      }
                  }
              }
              maxLength = Math.max(maxLength, dp[i]);
          }
          return maxLength;
      }
  }
//leetcode submit region end(Prohibit modification and deletion)

}