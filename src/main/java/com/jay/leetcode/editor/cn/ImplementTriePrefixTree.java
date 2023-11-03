//Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼
//写检查。 
//
// 请你实现 Trie 类： 
//
// 
// Trie() 初始化前缀树对象。 
// void insert(String word) 向前缀树中插入字符串 word 。 
// boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 
//false 。 
// boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否
//则，返回 false 。 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
//[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
//输出
//[null, null, true, false, true, null, true]
//
//解释
//Trie trie = new Trie();
//trie.insert("apple");
//trie.search("apple");   // 返回 True
//trie.search("app");     // 返回 False
//trie.startsWith("app"); // 返回 True
//trie.insert("app");
//trie.search("app");     // 返回 True
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length, prefix.length <= 2000 
// word 和 prefix 仅由小写英文字母组成 
// insert、search 和 startsWith 调用次数 总计 不超过 3 * 10⁴ 次 
// 
//
// Related Topics 设计 字典树 哈希表 字符串 👍 1500 👎 0

  
package com.jay.leetcode.editor.cn;
public class ImplementTriePrefixTree{
  public static void main(String[] args) {
      Trie trie = new ImplementTriePrefixTree().new Trie();
      trie.insert("apple");
      trie.search("apple");   // 返回 True
      trie.search("app");     // 返回 False
      trie.startsWith("app"); // 返回 True
      trie.insert("app");
      trie.search("app");     // 返回 True
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Trie {

      class Node {
          Node[] child = new Node[26];
          boolean finish = false;
      }

      Node root;

      public Trie() {
          root = new Node();
      }

      public void insert(String word) {
          if (word == null || word.equals("")) {
              return;
          }
          char[] ca = word.toCharArray();
          Node cur = root;
          for (int i=0; i<ca.length; i++) {
              int index = ca[i] - 'a';
              if (cur.child[index] == null) {
                  cur.child[index] = new Node();
                  cur = cur.child[index];
              } else {
                  cur = cur.child[index];
              }
          }
          cur.finish = true;
      }

      public boolean search(String word) {
          if (word == null || word.equals("")) {
              return false;
          }
          char[] ca = word.toCharArray();
          Node cur = root;
          for (int i=0; i<ca.length; i++) {
              int index = ca[i] - 'a';
              if (cur.child[index] == null) {
                  return false;
              } else {
                  cur = root.child[index];
              }
          }
          return cur.finish;
      }

      public boolean startsWith(String prefix) {
          if (prefix == null || prefix.equals("")) {
              return false;
          }
          char[] ca = prefix.toCharArray();
          Node cur = root;
          for (int i=0; i<ca.length; i++) {
              int index = ca[i] - 'a';
              if (cur.child[index] == null) {
                  return false;
              } else {
                  cur = root.child[index];
              }
          }
          return true;
      }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}