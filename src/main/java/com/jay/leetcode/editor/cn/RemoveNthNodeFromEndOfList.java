//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// Related Topics 链表 双指针 👍 2217 👎 0

  
package com.jay.leetcode.editor.cn;
public class RemoveNthNodeFromEndOfList{
  public static void main(String[] args) {
       Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
      ListNode head = new ListNode(1);
      ListNode node2 = new ListNode(2);
      ListNode node3 = new ListNode(3);
      ListNode node4 = new ListNode(4);
      ListNode node5 = new ListNode(5);
      head.next = node2;
      node2.next=node3;
      node3.next=node4;
      node4.next=node5;
      System.out.println(solution.removeNthFromEnd(head, 2));
  }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
  //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }

        if (len == n) {
            return head.next;
        }

        ListNode guard = new ListNode();
        guard.next = head;
        ListNode l =guard, r=guard;
        int i=0;
        while (i< n) {
            r = r.next;
            i++;
        }
        while (i<len) {
            l = l.next;
            r = r.next;
            i++;
        }
        l.next = l.next.next;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}