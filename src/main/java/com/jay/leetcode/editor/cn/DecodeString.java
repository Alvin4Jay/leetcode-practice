//给定一个经过编码的字符串，返回它解码后的字符串。 
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "3[a]2[bc]"
//输出："aaabcbc"
// 
//
// 示例 2： 
//
// 
//输入：s = "3[a2[c]]"
//输出："accaccacc"
// 
//
// 示例 3： 
//
// 
//输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
// 
//
// 示例 4： 
//
// 
//输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 30 
// 
// s 由小写英文字母、数字和方括号
// '[]' 组成 
// s 保证是一个 有效 的输入。 
// s 中所有整数的取值范围为
// [1, 300] 
// 
//
// Related Topics 栈 递归 字符串 👍 1539 👎 0

  
package com.jay.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DecodeString{
  public static void main(String[] args) {
       Solution solution = new DecodeString().new Solution();
      System.out.println(solution.decodeString("3[a2[c]]"));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      Stack<String> stack = new Stack<>(); // 存放未计算的字符数据
      int index=0;
    public String decodeString(String s) {
        // 3[a2[c]]
        int len = s.length();
        while (index < len) {
            char c = s.charAt(index);
            if (c>='a' && c<='z' || c == '[') {
                stack.push(String.valueOf(c));
                index++;
            } else if (c>='0'&&c<='9') {
                String digital = getDigital(s);
                stack.push(digital);
            } else {
                String tmp = getString();
                stack.pop(); // 弹出'['
                int count = Integer.parseInt(stack.pop());
                StringBuilder sb = new StringBuilder();
                while(count>0) {
                    sb.append(tmp);
                    count--;
                }
                stack.push(sb.toString());
                index++;
            }
        }

        return getString();
    }

    private String getString() {
        List<String> tmp = new ArrayList<>();
        while(!stack.isEmpty() && !stack.peek().equals("[")) {
            tmp.add(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        for (int i=tmp.size()-1;i>=0;i--) {
            sb.append(tmp.get(i));
        }
        return sb.toString();
    }

      private String getDigital(String s) {
        StringBuilder sb = new StringBuilder();
        char c = s.charAt(index);
        while(c >= '0' && c<='9') {
            sb.append(c);
            index++;
            c = s.charAt(index);
        }
        return sb.toString();
      }
  }
//leetcode submit region end(Prohibit modification and deletion)

}