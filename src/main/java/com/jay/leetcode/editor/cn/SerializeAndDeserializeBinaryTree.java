//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
//式重构得到原数据。 
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
//反序列化为原始的树结构。 
//
// 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的
//方法解决这个问题。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,null,null,4,5]
//输出：[1,2,3,null,null,4,5]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 10⁴] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 设计 字符串 二叉树 👍 1157 👎 0

  
package com.jay.leetcode.editor.cn;
public class SerializeAndDeserializeBinaryTree{
  public static void main(String[] args) {
    Codec ser = new Codec();
    Codec deser = new Codec();
      Codec.TreeNode root  = new Codec.TreeNode(1);
      root.left = new Codec.TreeNode(2);
      root.right = new Codec.TreeNode(3);
      root.right.left = new Codec.TreeNode(4);
      root.right.right = new Codec.TreeNode(5);
    Codec.TreeNode ans = deser.deserialize(ser.serialize(root));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public static class Codec {

    public static class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }

        StringBuilder sb1 = new StringBuilder();
        preOrder(root, sb1);
        String tmp1 = sb1.toString();
        tmp1 = tmp1.substring(1, tmp1.length());

        StringBuilder sb2 = new StringBuilder();
        inOrder(root, sb2);
        String tmp2 = sb2.toString();
        tmp2 = tmp2.substring(1, tmp2.length());
        return tmp1+ "," + tmp2;
    }

    private void preOrder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        sb.append("|" + node.val);
        preOrder(node.left, sb);
        preOrder(node.right, sb);
    }

    private void inOrder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        inOrder(node.left, sb);
        sb.append("|" + node.val);
        inOrder(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] array = data.split("\\,");
        String preStr = array[0];
        String inStr = array[1];
        String[] preStrArray  = preStr.split("\\|");
        String[] inStrArray  = inStr.split("\\|");

        int[] preNums = new int[preStrArray.length];
        int i = 0;
        for (String s : preStrArray) {
            preNums[i] = Integer.parseInt(s);
            i++;
        }
        int[] inNums = new int[inStrArray.length];
        i = 0;
        for (String s : inStrArray) {
            inNums[i] = Integer.parseInt(s);
            i++;
        }
        return buildTree(preNums, 0, preNums.length-1, inNums,0, inNums.length-1);
    }

    private TreeNode buildTree(int[] preNums, int ps, int pe, int[] inNums, int is, int ie) {
        if  (ps > pe || is > ie) {
            return null;
        }

        int rootMidInex = -1, leftLength=-1, rightLength=-1;
        for (int i=is; i<=ie; i++) {
            if (inNums[i] == preNums[ps]) {
                rootMidInex = i;
                leftLength = rootMidInex-is;
                rightLength = ie-rootMidInex;
                break;
            }
        }
        TreeNode root = new TreeNode(preNums[ps]);
        if (leftLength > 0) {
            root.left = buildTree(preNums, ps+1, ps+leftLength, inNums,is, rootMidInex-1);
        }
        if (rightLength > 0) {
            root.right = buildTree(preNums, ps+leftLength+1, pe, inNums, rootMidInex+1, ie);
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}