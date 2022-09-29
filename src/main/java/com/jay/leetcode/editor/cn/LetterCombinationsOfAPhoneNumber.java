//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
//
// Related Topics 哈希表 字符串 回溯 👍 2124 👎 0

  
package com.jay.leetcode.editor.cn;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber{
  public static void main(String[] args) {
       Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      // 回溯
       public List<String> letterCombinations(String digits) {
           List<String> ans = new ArrayList<>();
           if (digits == null || digits.length() == 0) {
               return ans;
           }

           Map<Character, String[]> map = new HashMap<>();
           map.put('2', new String[]{"a", "b", "c"});
           map.put('3', new String[]{"d", "e", "f"});
           map.put('4', new String[]{"g", "h", "i"});
           map.put('5', new String[]{"j", "k", "l"});
           map.put('6', new String[]{"m", "n", "o"});
           map.put('7', new String[]{"p", "q", "r", "s"});
           map.put('8', new String[]{"t", "u", "v"});
           map.put('9', new String[]{"w", "x", "y", "z"});

           StringBuilder sb = new StringBuilder();
           backtrack(digits, map, ans, 0, sb);
           return ans;
       }

       private void backtrack(String digits, Map<Character, String[]> map, List<String> ans, int index, StringBuilder cur) {
           if (index == digits.length()) {
               ans.add(cur.toString());
               return;
           }
           char c = digits.charAt(index);
           String[] array = map.get(c);
           for (int i=0;i<array.length;i++) {
               cur.append(array[i]);
               backtrack(digits, map, ans, index+1, cur);
               cur.deleteCharAt(cur.length()-1);
           }
       }

      // 队列解法
//      public List<String> letterCombinations(String digits) {
//          List<String> ans = new ArrayList<>();
//          if (digits == null || digits.length() == 0) {
//              return ans;
//          }
//
//          Map<Character, String[]> map = new HashMap<>();
//          map.put('2', new String[]{"a", "b", "c"});
//          map.put('3', new String[]{"d", "e", "f"});
//          map.put('4', new String[]{"g", "h", "i"});
//          map.put('5', new String[]{"j", "k", "l"});
//          map.put('6', new String[]{"m", "n", "o"});
//          map.put('7', new String[]{"p", "q", "r", "s"});
//          map.put('8', new String[]{"t", "u", "v"});
//          map.put('9', new String[]{"w", "x", "y", "z"});
//
//          Queue<String> queue = new LinkedList<>();
//
//          for (int i=0;i<digits.length();i++) {
//              char c = digits.charAt(i);
//              String[] array = map.get(c);
//              if (i == 0) {
//                  for (int j=0;j<array.length;j++) {
//                      queue.add(array[j]);
//                  }
//                  continue;
//              }
//              int size = queue.size();
//              for (int start=0;start<size;start++) {
//                  String ele = queue.poll();
//                  for (int j=0;j<array.length;j++) {
//                      queue.add(ele + array[j]);
//                  }
//              }
//          }
//          while (!queue.isEmpty()) {
//              ans.add(queue.poll());
//          }
//          return ans;
//      }
  }
//leetcode submit region end(Prohibit modification and deletion)

}