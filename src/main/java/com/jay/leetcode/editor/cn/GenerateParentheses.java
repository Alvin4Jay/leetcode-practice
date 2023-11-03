//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 2886 👎 0

  
package com.jay.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses{
  public static void main(String[] args) {
       Solution solution = new GenerateParentheses().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        getParenthesis(ans, n, n, "");
        return ans;
    }

//    private void getParenthesis(List<String> ans, int left, int right, String cur) {
//        if (left > right) {
//            return;
//        }
//
//        if (left == right && left == 0) {
//            ans.add(cur);
//            return;
//        }
//        if (left == right) {
//            getParenthesis(ans, left-1, right, cur+"(");
//        } else if (left < right && left > 0) {
//            getParenthesis(ans, left-1, right, cur+"(");
//            getParenthesis(ans, left, right-1, cur+")");
//        } else if (left < right && left == 0) {
//            getParenthesis(ans, left, right-1, cur+")");
//        }
//    }

      private void getParenthesis(List<String> ans, int left, int right, String cur) {
        if (left == right && left == 0) { // 有效组合，截止
            ans.add(cur);
            return;
        }

        if (left > right) { // 无效
            return;
        }

        if (left == right) {
            getParenthesis(ans, left-1, right, cur + "("); // 只能取(
        } else {
            if (left > 0) {
                getParenthesis(ans, left-1, right, cur + "("); // 取(
            }
            getParenthesis(ans, left, right-1, cur + ")"); // 取)
        }
      }
}
//leetcode submit region end(Prohibit modification and deletion)

}