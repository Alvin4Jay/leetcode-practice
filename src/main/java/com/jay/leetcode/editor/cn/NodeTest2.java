package com.jay.leetcode.editor.cn;

/**
 * desc.
 *
 * @author zhongshuo.xwj
 */
public class NodeTest2 {
     static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode firstPartEnd = findFirstPartEnd(head);
        ListNode secondPart = firstPartEnd.next;
        firstPartEnd.next = null;
        ListNode secondPartRev = reverse(secondPart);
        ListNode first = head, second = secondPartRev;
        boolean ans = true;
        while (first != null && second != null) {
            if (first.val != second.val) {
                ans = false;
                break;
            }
            first = first.next;
            second = second.next;
        }
        firstPartEnd.next = reverse(secondPartRev);
        return ans;
    }

    private static ListNode reverse(ListNode node) {
        ListNode cur = node, pre = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre =cur;
            cur = tmp;
        }
        return pre;
    }

    private static ListNode findFirstPartEnd(ListNode node) {
        ListNode fast = node.next, slow = node;
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(head));
    }
}
