//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics 栈 字符串 👍 3522 👎 0

  
package com.jay.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses{
  public static void main(String[] args) {
       Solution solution = new ValidParentheses().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }

        Map<Character, Character> map = new HashMap(){{
            put(']', '[');
            put(')', '(');
            put('}', '{');
        }};
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == ']' || c== '}' || c==')') {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.pop() != map.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}