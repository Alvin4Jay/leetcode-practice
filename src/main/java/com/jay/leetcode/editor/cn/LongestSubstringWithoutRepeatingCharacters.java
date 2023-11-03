//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 8151 👎 0

  
package com.jay.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters{
  public static void main(String[] args) {
       Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
      System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int len = s.length();
        int l = 0, r = 0, ans = 0;
        Map<Character, Integer> posMap = new HashMap<>(); // <字符，位置>
        for (; r < len; r++) {
            Character c = s.charAt(r);
            // >=l表示当前的c对应的位置是有效的；否则，无效
            if (posMap.containsKey(c) && posMap.get(c) >= l) {
                l = posMap.get(c) + 1;
            }
            posMap.put(c, r);
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}